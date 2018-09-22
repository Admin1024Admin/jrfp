package com.ky.ct.rzdj.service;

import com.ky.ct.rzdj.dao.BaseXmjzfpdkDao;
import com.ky.ct.rzdj.dao.BaseXmjzfpdkHistoryDao;
import com.ky.ct.rzdj.dao.RoleDao;
import com.ky.ct.rzdj.model.*;
import com.ky.ct.rzdj.util.TwoObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.*;

@Service
public class BaseXmjzfpdkService {
    @Autowired
    BaseXmjzfpdkHistoryDao baseXmjzfpdkHistoryDao;
    @Autowired
    BaseXmjzfpdkDao baseXmjzfpdkDao;
    @Autowired
    RoleDao roleDao;

    public List<BaseXmjzfpdkBeanOut> findPage(Integer page, Integer limit, HttpSession session){
        Map<String, Object> map = weiHuDanWei(session);

        List<BaseXmjzfpdkBean> list = baseXmjzfpdkDao.findPageByCondition(page, limit, map);
        return getOut(list);
    }

    public List<BaseXmjzfpdkHistoryBeanOut> findPageSH(Integer page, Integer limit, HttpSession session){
        Map<String, Object> map = weiHuDanWei(session);

        List<BaseXmjzfpdkHistoryBean> list = baseXmjzfpdkHistoryDao.findPageByCondition(page, limit, map);
        for (BaseXmjzfpdkHistoryBean baseXmjzfpdkHistoryBean : list) {
            System.out.println(baseXmjzfpdkHistoryBean);
        }
        return getOutHistory(list);
    }

    public List<BaseXmjzfpdkBeanOut> search(Integer page, Integer limit,String value, String column, HttpSession session){
        Map<String, Object> map = weiHuDanWei(session);
        map.put(column,value);

        List<BaseXmjzfpdkBean> list = baseXmjzfpdkDao.findPageByCondition(page, limit, map);
        return getOut(list);
    }
    public List<BaseXmjzfpdkHistoryBeanOut> searchSH(Integer page, Integer limit,String value, String column, HttpSession session){
        Map<String, Object> map = weiHuDanWeiSH(session);
        map.put(column,value);

        List<BaseXmjzfpdkHistoryBean> list = baseXmjzfpdkHistoryDao.findPageByCondition(page, limit, map);
        return getOutHistory(list);
    }

    public long getCount(HttpSession session) {
        Map<String, Object> map = weiHuDanWei(session);
        return (long)baseXmjzfpdkDao.getCount(map);
    }
    public long getCountSH(HttpSession session) {
        Map<String, Object> map = weiHuDanWeiSH(session);
        return (long)baseXmjzfpdkHistoryDao.getCount(map);
    }

    public Map<String, Object> weiHuDanWei(HttpSession session){
        RzdjUserEntity user = getCurrentUser(session);
        Map<String, Object> map = new HashMap<>();
        if (!currentUserIsAdmin(user))
            map.put("shuJuWeiHuDanWei",getCurrentUser(session).getType());
        return map;
    }
    public Map<String, Object> weiHuDanWeiSH(HttpSession session){
        RzdjUserEntity user = getCurrentUser(session);
        Map<String, Object> map = new HashMap<>();
        if (!currentUserIsAdmin(user)) {
            map.put("shuJuWeiHuDanWei", getCurrentUser(session).getType());
            map.put("operationPerson", getCurrentUser(session).getName());
        }
        return map;
    }

    public Long getHistoryUid(BaseXmjzfpdkHistoryBean bean){
        Map<String, Object> map = new HashMap<>();
        map.put("operationPerson",bean.getOperationPerson());
        map.put("checkStatus","未审核");
        map.put("shuJuWeiHuDanWei",bean.getShuJuWeiHuDanWei());
        if (bean.getUid() == null){
            map.put("daiKuanJiGou",bean.getDaiKuanJiGou());
            map.put("daiKuanAgreementNo",bean.getDaiKuanAgreementNo());
            map.put("touFangDate",bean.getTouFangDate());
            map.put("changHuanPlanDate",bean.getChangHuanPlanDate());
            map.put("changHuanDate",bean.getChangHuanDate());
        }else {
            bean.setGid(bean.getUid());
            map.put("gid",bean.getUid());
        }
        List<BaseXmjzfpdkHistoryBean> list = baseXmjzfpdkHistoryDao.findByCondition(map);
        if (list.size() == 0) return null;
        return list.get(0).getUid();
    }

    public boolean saveOrUpdateH(BaseXmjzfpdkHistoryBean bean, HttpSession session) {
        String[] type = getTypeValue(bean.getType());
        bean.setType(type[0]);
        bean.setYiDaiDaiKuanType(type[1]);
        RzdjUserEntity user = getCurrentUser(session);

        System.out.println(user.getType()+"00000000000000000000000000000000000000000000000000000000000");
        bean.setShuJuWeiHuDanWei(user.getType());
        bean.setOperationPerson(user.getName());
        bean.setOperationDate(new Date());
        bean.setCheckStatus("未审核");
        bean.setOperation(bean.getUid()==null?"新增":"修改");
        bean.setUid(getHistoryUid(bean));
        boolean is = true;
        try {
//            System.out.println("++++++++++++++++++++++++++++++++++++++\n"+bean);
            baseXmjzfpdkHistoryDao.saveOrUpdate(bean);
        }catch (Exception e){
            is = false;
        }
        return is;
    }


    public boolean saveOrUpdateHSH(BaseXmjzfpdkHistoryBean bean, HttpSession session) {
        RzdjUserEntity user = getCurrentUser(session);
        boolean is = false;
        if(currentUserIsAdmin(user)) {
            BaseXmjzfpdkHistoryBean historyBean = baseXmjzfpdkHistoryDao.findById(bean.getUid());
            if (!notCheck(historyBean.getCheckStatus()))
                return false;
            is = saveOrUpdateOne(historyBean, session, bean.getCheckStatus(), bean.getReason());
        }
        return is;
    }

    public boolean saveOrUpdateOne(BaseXmjzfpdkHistoryBean bean, HttpSession session, String status, String reason) {
        RzdjUserEntity user = getCurrentUser(session);
        bean.setCheckPerson(user.getName());
        bean.setCheckDate(new Date());
        bean.setCheckStatus(status);
        bean.setReason(reason);
        BaseXmjzfpdkBean baseXmjzfpdkBean = (BaseXmjzfpdkBean) TwoObjectUtil.copyToFpxexd(bean, new BaseXmjzfpdkBean());
        baseXmjzfpdkBean.setUid(bean.getUid());
        baseXmjzfpdkBean.setGid(bean.getUid());
        if (bean.getGid() == null){
            baseXmjzfpdkBean.setUid(null);
        }
        boolean is = true;
        try {
            baseXmjzfpdkHistoryDao.saveOrUpdate(bean);
            if ("审核通过".equals(status)) {
                if ("删除".equals(bean.getOperation())) {
                    baseXmjzfpdkDao.deleteById(baseXmjzfpdkBean.getUid());
                } else {
                    baseXmjzfpdkDao.saveOrUpdate(baseXmjzfpdkBean);
                }
            }
        }catch (Exception e){
            is = false;
            e.printStackTrace();
        }
        return is;
    }


    public boolean del(String value, HttpSession session){
        boolean is = true;
        String[] values = value.split(",");
        try {
            for (int i = 1; i < values.length; i++) {
                Long uid = Long.valueOf(values[i]);
                BaseXmjzfpdkBean baseXmjzfpdkBean = baseXmjzfpdkDao.findById(uid);
                BaseXmjzfpdkHistoryBean baseXmjzfpdkHistoryBean =
                        (BaseXmjzfpdkHistoryBean) TwoObjectUtil.copyToFpxexd(baseXmjzfpdkBean,new BaseXmjzfpdkHistoryBean());
                baseXmjzfpdkHistoryBean.setUid(baseXmjzfpdkBean.getUid());

                baseXmjzfpdkHistoryBean.setOperation("删除");
                RzdjUserEntity user = getCurrentUser(session);
                baseXmjzfpdkHistoryBean.setShuJuWeiHuDanWei(user.getType());
                baseXmjzfpdkHistoryBean.setOperationPerson(user.getName());
                baseXmjzfpdkHistoryBean.setOperationDate(new Date());
                baseXmjzfpdkHistoryBean.setCheckStatus("未审核");
                baseXmjzfpdkHistoryBean.setUid(getHistoryUid(baseXmjzfpdkHistoryBean));
//                System.out.println("++++++++++++++++++++++++++++++++++++++\n"+baseXmjzfpdkHistoryBean);
                baseXmjzfpdkHistoryDao.saveOrUpdate(baseXmjzfpdkHistoryBean);
            }
        }catch (Exception e){
            is = false;
        }
        return is;
    }


    public boolean delSH(String value, HttpSession session){
        RzdjUserEntity user = getCurrentUser(session);
        boolean is = true;
        String[] values = value.split(",");
        try {
            for (int i = 1; i < values.length; i++) {
                Long uid = Long.valueOf(values[i]);
                BaseXmjzfpdkHistoryBean baseXmjzfpdkHistoryBean = baseXmjzfpdkHistoryDao.findById(uid);


                if(currentUserIsAdmin(user)) {
                    if (!notCheck(baseXmjzfpdkHistoryBean.getCheckStatus()))
                        continue;
                    saveOrUpdateOne(baseXmjzfpdkHistoryBean,session,"审核未通过", "批量操作");
                }else {
                    baseXmjzfpdkHistoryDao.deleteById(uid);
                }
            }
        }catch (Exception e){
            is = false;
            e.printStackTrace();
        }
        return is;
    }

    public boolean passSH(String value, HttpSession session){
        RzdjUserEntity user = getCurrentUser(session);
        boolean is = true;
        String[] values = value.split(",");
        try {
            for (int i = 1; i < values.length; i++) {
                Long uid = Long.valueOf(values[i]);
                BaseXmjzfpdkHistoryBean baseXmjzfpdkHistoryBean = baseXmjzfpdkHistoryDao.findById(uid);


                if (currentUserIsAdmin(user)) {
                    if (!notCheck(baseXmjzfpdkHistoryBean.getCheckStatus()))
                        continue;
                    saveOrUpdateOne(baseXmjzfpdkHistoryBean, session, "审核通过", "批量操作");
                }
            }
        }catch (Exception e){
            is = false;
            e.printStackTrace();
        }
        return is;
    }

    public boolean notCheck(String status){
        return "未审核".equals(status);
    }

    public RzdjUserEntity getCurrentUser(HttpSession session){
        return (RzdjUserEntity) session.getAttribute("currentUser");
    }

    public Boolean currentUserIsAdmin(RzdjUserEntity user){
        boolean is = false;

        Map<String, Object> map = new HashMap<>();
        map.put("rid",user.getRole());
        List<RoleEntity> list = roleDao.findByCondition(map);
        if (list.size()>0 && "admin".equals(list.get(0).getRname())){
            is = true;
        }

        return is;
    }

    private String[] getTypeValue(String type){
        String[] out = {"",""};
        switch (type){
            case "易地扶贫搬迁随迁户贷款":
                out[0] = "易地扶贫搬迁贷款";
                out[1] = "易地扶贫搬迁随迁户贷款";
                break;
            case "易地扶贫搬迁贫困户贷款":
                out[0] = "易地扶贫搬迁贷款";
                out[1] = "易地扶贫搬迁贫困户贷款";
                break;
            case "农田基本建设贷款":
                out[0] = "农田基本建设贷款";
                break;
            case "生产环境改造贷款":
                out[0] = "生产环境改造贷款";
                break;
            case "农村基础设施贷款":
                out[0] = "农村基础设施贷款";
                break;
            case "其他":
                out[0] = "其他";
                break;
            default:
                break;
        }
        return out;
    }

    /**
     * 以下是实体类转数据传输对象
     * @param list
     * @return
     */
    public List<BaseXmjzfpdkHistoryBeanOut> getOutHistory(List<BaseXmjzfpdkHistoryBean> list){
        List<BaseXmjzfpdkHistoryBeanOut> out = new ArrayList<>();
        for (BaseXmjzfpdkHistoryBean bean : list){
            out.add(getOutHistory(bean));
        }
        return out;
    }

    private BaseXmjzfpdkHistoryBeanOut getOutHistory(BaseXmjzfpdkHistoryBean in){
        BaseXmjzfpdkHistoryBeanOut out = (BaseXmjzfpdkHistoryBeanOut) TwoObjectUtil.copyToFpxexd(in,new BaseXmjzfpdkHistoryBeanOut());

        out.setUid(in.getUid());
//        out.setType_nongCunJiChuSheSi("否");
//        out.setType_nongTianJiBenJianSe("否");
//        out.setType_qiTa("否");
//        out.setType_shengChanHuanJinGaiZhao("否");
//        out.setType_yiDiBanQianPinKun("否");
//        out.setType_yiDiBanQianSuiQian("否");

        String is = "√";

        if (in.getType()!=null) {
            switch (in.getType()) {
                case "易地扶贫搬迁贷款":
                    switch (in.getYiDaiDaiKuanType()) {
                        case "易地扶贫搬迁随迁户贷款":
                            out.setType_yiDiBanQianSuiQian(is);
                            break;
                        case "易地扶贫搬迁贫困户贷款":
                            out.setType_yiDiBanQianPinKun(is);
                            break;
                        default:
                            break;
                    }
                    break;
                case "农田基本建设贷款":
                    out.setType_nongTianJiBenJianSe(is);
                    break;
                case "生产环境改造贷款":
                    out.setType_shengChanHuanJinGaiZhao(is);
                    break;
                case "农村基础设施贷款":
                    out.setType_nongCunJiChuSheSi(is);
                    break;
                case "其他":
                    out.setType_qiTa(is);
                    break;
                default:
                    break;
            }
        }
        return out;
    }

    public List<BaseXmjzfpdkBeanOut> getOut(List<BaseXmjzfpdkBean> list){
        List<BaseXmjzfpdkBeanOut> out = new ArrayList<>();
        for (BaseXmjzfpdkBean bean : list){
            out.add(getOut(bean));
        }
        return out;
    }

    private BaseXmjzfpdkBeanOut getOut(BaseXmjzfpdkBean in){
        BaseXmjzfpdkBeanOut out = (BaseXmjzfpdkBeanOut) TwoObjectUtil.copyToFpxexd(in,new BaseXmjzfpdkBeanOut());
        out.setUid(in.getUid());
//        out.setType_nongCunJiChuSheSi("否");
//        out.setType_nongTianJiBenJianSe("否");
//        out.setType_qiTa("否");
//        out.setType_shengChanHuanJinGaiZhao("否");
//        out.setType_yiDiBanQianPinKun("否");
//        out.setType_yiDiBanQianSuiQian("否");

        String is = "√";

        if (in.getType()!=null) {
            switch (in.getType()) {
                case "易地扶贫搬迁贷款":
                    switch (in.getYiDaiDaiKuanType()) {
                        case "易地扶贫搬迁随迁户贷款":
                            out.setType_yiDiBanQianSuiQian(is);
                            break;
                        case "易地扶贫搬迁贫困户贷款":
                            out.setType_yiDiBanQianPinKun(is);
                            break;
                        default:
                            break;
                    }
                    break;
                case "农田基本建设贷款":
                    out.setType_nongTianJiBenJianSe(is);
                    break;
                case "生产环境改造贷款":
                    out.setType_shengChanHuanJinGaiZhao(is);
                    break;
                case "农村基础设施贷款":
                    out.setType_nongCunJiChuSheSi(is);
                    break;
                case "其他":
                    out.setType_qiTa(is);
                    break;
                default:
                    break;
            }
        }
        return out;
    }
}
