package com.ky.ct.rzdj.service;

import com.ky.ct.rzdj.dao.QtgrjzfpdkDdpkhDao;
import com.ky.ct.rzdj.dao.QtgrjzfpdkDdpkhHistoryDao;
import com.ky.ct.rzdj.dao.QtgrjzfpdkHistoryDao;
import com.ky.ct.rzdj.dao.QtgrjzpfdkDao;
import com.ky.ct.rzdj.model.*;
import com.ky.ct.rzdj.util.TwoObjectUtil;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class QtgrjzfpdkHistoryService {
    @Autowired
    private QtgrjzfpdkHistoryDao qtgrjzfpdkHistoryDao;
    @Autowired
    private QtgrjzpfdkDao qtgrjzpfdkDao;
    @Autowired
    private QtgrjzfpdkDdpkhHistoryDao qtgrjzfpdkDdpkhHistoryDao;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    /**
     *  分页其他个人精准贷款 历史表
     */
    public Map<String,Object> findQtgrjzpfdkHistoryPage(int page, int limit){
        List<BaseQtgrjzfpdkHistory> baseQtgrjzfpdkHistories = new ArrayList<>();
        RzdjUserEntity user = (RzdjUserEntity) SecurityUtils.getSubject().getSession().getAttribute("currentUser");
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("checkStatus","未审核");
        if(user.getRole()==1){
            baseQtgrjzfpdkHistories = qtgrjzfpdkHistoryDao.findPageByCondition(page,limit,paramMap);
        }else{

            paramMap.put("shuJuWeiHuDanWei",user.getType());
            baseQtgrjzfpdkHistories = qtgrjzfpdkHistoryDao.findPageByCondition(page,limit,paramMap);
        }
        for(BaseQtgrjzfpdkHistory b:baseQtgrjzfpdkHistories){
            switch(b.getZhuTiDaiKuanLeiBie()){
                case "家庭农场贷款":{
                    b.setT1("√");
                    b.setT2("");
                    b.setT3("");
                    break;
                }
                case "农业专业大户贷款":{
                    b.setT1("");
                    b.setT2("√");
                    b.setT3("");
                    break;
                }
                case "其他":{
                    b.setT1("");
                    b.setT2("");
                    b.setT3("√");
                    break;
                }
            }
        }
        Map<String,Object> map = new HashMap<>();
        map.put("data",baseQtgrjzfpdkHistories);
        return map;
    }

    /**
     * 获取数据的总条数
     */
    public long getCount(Map<String,Object> map){
        System.out.println("------------>dateMap"+map);
        Map<String,Object> parmMap = new HashMap<>();
        for(String key:map.keySet()){
            if(map.get(key)!=null&&!"".equals(map.get(key))&&!"page".equals(key)&&!"limit".equals(key)){
                parmMap.put(key,map.get(key));
            }
        }
        RzdjUserEntity user = (RzdjUserEntity) SecurityUtils.getSubject().getSession().getAttribute("currentUser");
        long count = 0;
        if(user.getRole()==1){
            count  =(long) qtgrjzfpdkHistoryDao.getCount(parmMap);
        }else{
            parmMap.put("shuJuWeiHuDanWei",user.getType());
            count = (long) qtgrjzfpdkHistoryDao.getCount(parmMap);
        }
        return count;
    }

    /**
     * 按条件查询
     */
    public List<BaseQtgrjzfpdkHistory> findQtgrjzfpdkHistoryWhere(Map<String,Object> map, int page, int limit){
        RzdjUserEntity user = (RzdjUserEntity) SecurityUtils.getSubject().getSession().getAttribute("currentUser");
        Map<String,Object> parmMap = new HashMap<>();
        for(String key:map.keySet()){
            if(map.get(key)!=null&&!"".equals(map.get(key))&&!"page".equals(key)&&!"limit".equals(key)){
                parmMap.put(key,map.get(key));
            }
        }
        if(user.getRole()!=1){
            parmMap.put("shuJuWeiHuDanWei",user.getType());
        }
        System.out.println("-------------------->param"+parmMap);
        List<BaseQtgrjzfpdkHistory> baseQtgrjzfpdkHistories = qtgrjzfpdkHistoryDao.findPageByCondition(page,limit,parmMap);
        return baseQtgrjzfpdkHistories;
    }

    /**
     * 据贷款合同编号和贷款机构和投放日期和偿还贷款时间是否存在该用户
     */
    public BaseQtgrjzfpdkHistory fingByNoAndJiGouAndTouDateAndChangDate(String agreementNo,String daiKuanJinRongJiGou,String touFangDate,String changHuanDate ){
        Map<String,Object> whereMap = new HashMap<>();
        whereMap.put("agreementNo",agreementNo);
        whereMap.put("daiKuanJinRongJiGou",daiKuanJinRongJiGou);
        whereMap.put("touFangDate",touFangDate);
        whereMap.put("changHuanDate",changHuanDate);
        List<BaseQtgrjzfpdkHistory> list = qtgrjzfpdkHistoryDao.findByCondition(whereMap);
        if(list!=null&&list.size()>0){
            return list.get(0);
        }
        return null;
    }

    /**
     * 根据编号查看具体信息
     */
    public BaseQtgrjzfpdkHistory findByNo(int no){
        return qtgrjzfpdkHistoryDao.findById(no);
    }
    /**
     * 根据getHistoryNo查看qtgrjzfpdk真实表中是否存在已经存在这个记录
     */
    public BaseQtgrjzfpdk findByHistoryNo(int no){
        BaseQtgrjzfpdk baseQtgrjzfpdk = qtgrjzpfdkDao.findByNo("historyNo",no);
        return baseQtgrjzfpdk;
    }

    /**
     * 审核通过
     */
    public boolean audit(BaseQtgrjzfpdkHistory baseQtgrjzfpdkHistory,String operation){
        RzdjUserEntity user = (RzdjUserEntity) SecurityUtils.getSubject().getSession().getAttribute("currentUser");
        Date date = new Date();
        boolean b = false;
        try{
            Date newdDate = new SimpleDateFormat("yyyy-MM-dd").parse(sdf.format(date));
            baseQtgrjzfpdkHistory.setOperationDate(newdDate);
            baseQtgrjzfpdkHistory.setOperationPerson(user.getName());
            baseQtgrjzfpdkHistory.setCheckDate(newdDate);
            baseQtgrjzfpdkHistory.setCheckPerson(user.getName());
            baseQtgrjzfpdkHistory.setCheckStatus("通过");
            baseQtgrjzfpdkHistory.setReason("");
            baseQtgrjzfpdkHistory.setOperation(operation);
            baseQtgrjzfpdkHistory.setDelStatus("未删除");
            b = qtgrjzfpdkHistoryDao.update(baseQtgrjzfpdkHistory);
            BaseQtgrjzfpdk baseQtgrjzfpdk = new BaseQtgrjzfpdk();
            baseQtgrjzfpdk =(BaseQtgrjzfpdk) TwoObjectUtil.copyToFpxexd(baseQtgrjzfpdkHistory,baseQtgrjzfpdk);
            baseQtgrjzfpdk.setHistoryNo(baseQtgrjzfpdkHistory.getUid());
            System.out.println("xxxxxxx--->"+baseQtgrjzfpdk);
            b = qtgrjzpfdkDao.add(baseQtgrjzfpdk);
        }catch (Exception e){
            e.printStackTrace();
        }
        return b;
    }
    /**
     * 审核不通过
     */
    public boolean noAudit(BaseQtgrjzfpdkHistory baseQtgrjzfpdkHistory,String operation){
        RzdjUserEntity user = (RzdjUserEntity) SecurityUtils.getSubject().getSession().getAttribute("currentUser");
        Date date = new Date();
        boolean b  = false;
        try{
            Date newdDate = new SimpleDateFormat("yyyy-MM-dd").parse(sdf.format(date));
            baseQtgrjzfpdkHistory.setOperationDate(newdDate);
            baseQtgrjzfpdkHistory.setOperationPerson(user.getName());
            baseQtgrjzfpdkHistory.setCheckDate(newdDate);
            baseQtgrjzfpdkHistory.setCheckPerson(user.getName());
            baseQtgrjzfpdkHistory.setCheckStatus("未通过");
            baseQtgrjzfpdkHistory.setOperation(operation);
            baseQtgrjzfpdkHistory.setDelStatus("未删除");
            b = qtgrjzfpdkHistoryDao.update(baseQtgrjzfpdkHistory);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return b;
    }
    /**
     * 根据cardId删除
     */
    public boolean delByNo(int no){
         BaseQtgrjzfpdkHistory qtgrjzfpdkHistory=qtgrjzfpdkHistoryDao.findById(no);
         Date date = new Date();
         boolean b = false;
         try{
             Date newdDate = new SimpleDateFormat("yyyy-MM-dd").parse(sdf.format(date));
             qtgrjzfpdkHistory.setOperationDate(newdDate);
             qtgrjzfpdkHistory.setDelStatus("已删除");
             b = qtgrjzfpdkHistoryDao.update(qtgrjzfpdkHistory);
         }catch (Exception e){e.printStackTrace();}

        return b;
    }

    /**
     * 保存一条新纪录
     */
    public boolean savaSingle(BaseQtgrjzfpdkHistory baseQtgrjzfpdkHistory,BaseQtgrjzfpdkDdpkhHistory baseQtgrjzfpdkDdpkhHistory){
        //从session中获取用户对象
        RzdjUserEntity user = (RzdjUserEntity) SecurityUtils.getSubject().getSession().getAttribute("currentUser");
        //设置默认的操作
        baseQtgrjzfpdkHistory.setOperationPerson(user.getName());
        baseQtgrjzfpdkHistory.setCheckStatus("未审核");
        baseQtgrjzfpdkHistory.setOperation("新增");
        baseQtgrjzfpdkHistory.setDelStatus("未删除");
        baseQtgrjzfpdkHistory.setShuJuWeiHuDanWei(user.getType());
        Boolean b = qtgrjzfpdkHistoryDao.add(baseQtgrjzfpdkHistory);
        Boolean b2 = qtgrjzfpdkDdpkhHistoryDao.add(baseQtgrjzfpdkDdpkhHistory);
        if(b==true&&b2==true){
            return true;
        }
        return false;
    }

    /**
     * 更新数据  比较前端和数据库的数据。不同的话就把前端的数据复制给数据库的数据
     */
    public boolean updateSingle(BaseQtgrjzfpdkHistory b1,BaseQtgrjzfpdkHistory b2){
        //从session中获取用户对象
        RzdjUserEntity user = (RzdjUserEntity) SecurityUtils.getSubject().getSession().getAttribute("currentUser");
        System.out.println("前端的数据--------->"+b1);
        System.out.println("数据库的数据--------->"+b2);
        int uid = b2.getUid();
        BaseQtgrjzfpdkHistory baseQtgrjzfpdkHistory = (BaseQtgrjzfpdkHistory)TwoObjectUtil.copyToFpxexdNotEmpty(b1,b2);
        System.out.println("更新后的数据--------->"+baseQtgrjzfpdkHistory);
        baseQtgrjzfpdkHistory.setUid(uid);
        System.out.println("更新的UID------->"+uid);
        baseQtgrjzfpdkHistory.setOperationPerson(user.getName());
        baseQtgrjzfpdkHistory.setCheckStatus("未审核");
        baseQtgrjzfpdkHistory.setOperation("更新");
        baseQtgrjzfpdkHistory.setDelStatus("未删除");
        boolean b = qtgrjzfpdkHistoryDao.update(baseQtgrjzfpdkHistory);
        return b;
    }

}
