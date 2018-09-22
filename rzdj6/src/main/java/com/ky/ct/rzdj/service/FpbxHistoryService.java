package com.ky.ct.rzdj.service;

import com.ky.ct.rzdj.dao.FpbxHistoryDao;
import com.ky.ct.rzdj.model.BaseFpbHistory;
import com.ky.ct.rzdj.model.BaseQtgrjzfpdkDdpkhHistory;
import com.ky.ct.rzdj.model.BaseQtgrjzfpdkHistory;
import com.ky.ct.rzdj.model.RzdjUserEntity;
import com.ky.ct.rzdj.util.TwoObjectUtil;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FpbxHistoryService {
    @Autowired
    private FpbxHistoryDao fpbxHistoryDao;
    /**
     * 保存一条新纪录
     */
    public boolean savaSingle(BaseFpbHistory baseFpbHistory){
        //从session中获取用户对象
        RzdjUserEntity user = (RzdjUserEntity) SecurityUtils.getSubject().getSession().getAttribute("currentUser");
        //设置默认的操作
        baseFpbHistory.setOperationPerson(user.getName());
        baseFpbHistory.setCheckStatus("未审核");
        baseFpbHistory.setOperation("新增");
        baseFpbHistory.setDelStatus("未删除");
        baseFpbHistory.setShuJuWeiHuDanWei(user.getType());
        Boolean b = fpbxHistoryDao.add(baseFpbHistory);
        if(b==true){
            return true;
        }
        return false;
    }

    /**
     * 更新数据  比较前端和数据库的数据。不同的话就把前端的数据复制给数据库的数据
     */
    public boolean updateSingle(BaseFpbHistory b1, BaseFpbHistory b2){
        //从session中获取用户对象
        RzdjUserEntity user = (RzdjUserEntity) SecurityUtils.getSubject().getSession().getAttribute("currentUser");
        System.out.println("前端的数据--------->"+b1);
        System.out.println("数据库的数据--------->"+b2);
        int id = b2.getId();
        BaseFpbHistory fpbHistory = (BaseFpbHistory) TwoObjectUtil.copyToFpxexdNotEmpty(b1,b2);
        System.out.println("更新后的数据--------->"+fpbHistory);
        fpbHistory.setId(id);
        System.out.println("更新的UID------->"+id);
        fpbHistory.setOperationPerson(user.getName());
        fpbHistory.setCheckStatus("未审核");
        fpbHistory.setOperation("更新");
        fpbHistory.setDelStatus("未删除");
        boolean b = fpbxHistoryDao.update(fpbHistory);
        return b;
    }

    /**
     * 据贷款合同编号和贷款机构和投放日期和偿还贷款时间是否存在该用户
     */
    public BaseFpbHistory findByCardId(String id){
        Map<String,Object> whereMap = new HashMap<>();
        whereMap.put("cardId",id);
        List<BaseFpbHistory> list = fpbxHistoryDao.findByCondition(whereMap);
        if(list!=null&&list.size()>0){
            return list.get(0);
        }
        return null;
    }
}
