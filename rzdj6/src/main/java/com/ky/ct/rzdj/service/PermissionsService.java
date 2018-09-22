package com.ky.ct.rzdj.service;

import com.ky.ct.rzdj.dao.PermissionsDao;
import com.ky.ct.rzdj.model.PermissionsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PermissionsService {
    @Autowired
    private PermissionsDao permissionsDao;

    public List<PermissionsEntity> get(Integer page, Integer limit){
        return permissionsDao.findPage(page, limit);
    }

    public List<PermissionsEntity> search(String value, String column){
        Map<String, Object> map = new HashMap<>();
        map.put(column,value);
        List<PermissionsEntity> list = permissionsDao.findByCondition(map);
        return list;
    }

    public boolean del(String value){
        boolean is = true;
        String[] values = value.split(",");
        try {
            for (int i = 1; i < values.length; i++) {
                permissionsDao.deleteById(Integer.valueOf(values[i]));
            }
        }catch (Exception e){
            is = false;
        }
        return is;
    }

    public boolean saveOrUpdate(PermissionsEntity bean){
        boolean is = true;
        try {
            permissionsDao.saveOrUpdate(bean);
        }catch (Exception e){
            is = false;
        }
        return is;
    }


    public long getCount(){
        return (long)permissionsDao.getCount();
    }
}
