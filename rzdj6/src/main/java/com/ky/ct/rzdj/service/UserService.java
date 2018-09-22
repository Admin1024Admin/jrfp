package com.ky.ct.rzdj.service;

import com.ky.ct.rzdj.dao.UserDao;
import com.ky.ct.rzdj.model.RzdjUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public void guolv(RzdjUserEntity bean){
//        bean.setUid();
        if(bean.getLoginName() != null)
            bean.setLoginName(bean.getLoginName().replaceAll("'","\\'").replaceAll("\"","\\\""));
//        bean.setPwd(bean.getPwd().replaceAll("'","\\'").replaceAll("\"","\\\""));
        if(bean.getName() != null)
            bean.setName(bean.getName().replaceAll("'","\\'").replaceAll("\"","\\\""));
        if(bean.getType() != null)
            bean.setType(bean.getType().replaceAll("'","\\'").replaceAll("\"","\\\""));
//        bean.setRole();
        if(bean.getMobile() != null)
            bean.setMobile(bean.getMobile().replaceAll("'","\\'").replaceAll("\"","\\\""));
        if(bean.getWeiXinOpenId() != null)
            bean.setWeiXinOpenId(bean.getWeiXinOpenId().replaceAll("'","\\'").replaceAll("\"","\\\""));
//        bean.setValid();
        if(bean.getNote() != null)
            bean.setNote(bean.getNote().replaceAll("'","\\'").replaceAll("\"","\\\""));
    }

    public boolean saveOrUpdate(RzdjUserEntity bean){
        boolean is = true;
        if (bean.getPwd() == null||bean.getPwd().equals("")){
            guolv(bean);
            String sql = "update rzdj_user set LoginName='"+bean.getLoginName().replaceAll("'","\\'")+"'";
//            System.out.println("-----------------------------"+(bean.getPwd() == null ? "null" : bean.getPwd()+"."));

            sql += ",Name='" + bean.getName() +"'";
            sql += ",Type='" + bean.getType() +"'";
            sql += ",Role=" + bean.getRole();
            sql += ",Mobile='" + bean.getMobile() +"'";
            sql += ",WeiXinOpenID='" + bean.getWeiXinOpenId() +"'";
            sql += ",Valid=" + bean.getValid();
            sql += ",Note='" + bean.getNote() +"'";
            sql += " where uid=" + bean.getUid()+";";
            try {
                userDao.exec(sql);
            } catch (Exception e) {
                is = false;
            }
        }else {
            bean.setPwd(ShiroRealm.md5(bean.getPwd()));
            System.out.println(bean);
            try {
                userDao.saveOrUpdate(bean);
            } catch (Exception e) {
                is = false;
            }
        }
        return is;
    }

    public boolean delUser(String value){
        boolean is = true;
        String[] values = value.split(",");
        try {
            for (int i = 1; i < values.length; i++) {
                userDao.deleteById(Integer.valueOf(values[i]));
            }
        }catch (Exception e){
            is = false;
        }
        return is;
    }

    public List<RzdjUserEntity> getUser(Integer page, Integer limit){
        List<RzdjUserEntity> list = userDao.findPage(page, limit);
        setPwdNull(list);
        return list;
    }

    private void setPwdNull(List<RzdjUserEntity> list){
        for (RzdjUserEntity bean : list) {
            bean.setPwd(null);
        }
    }

    public List<RzdjUserEntity> searchUser(String value, String column){
        Map<String, Object> map = new HashMap<>();
        map.put(column,value);
        List<RzdjUserEntity> list = userDao.findByCondition(map);
        setPwdNull(list);
        return list;
    }

    public long getCount(){
        return (long)userDao.getCount();
    }

}
