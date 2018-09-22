package com.ky.ct.rzdj.service;

import com.ky.ct.rzdj.dao.PermissionsDao;
import com.ky.ct.rzdj.dao.RoleDao;
import com.ky.ct.rzdj.dao.RolePermissionsDao;
import com.ky.ct.rzdj.model.BaseFpxexd;
import com.ky.ct.rzdj.model.PermissionsEntity;
import com.ky.ct.rzdj.model.RoleEntity;
import com.ky.ct.rzdj.model.RolePermissionsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoleService {
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private PermissionsDao permissionsDao;
    @Autowired
    RolePermissionsDao rolePermissionsDao;
    /**
     *  分页查询扶贫小额信贷
     */
    public Map<String,Object> findRolePage(int page, int limit){
        List<RoleEntity> roleEntities = roleDao.findPage(page,limit);
        Map<String,Object> map = new HashMap<>();
        map.put("data",roleEntities);
        return map;
    }

    /**
     * 获取数据的总条数
     */
    public long getCount(){
        long count  =(long) roleDao.getCount();
        return count;
    }
    /**
     * 获取所有权限
     */
    public List<PermissionsEntity> getAllPermisssinos(){
         return  permissionsDao.findAll();
    }
    /**
     * 分配权限
     */
    public Boolean addRolePermissions(Map<String,Object> paramMap){
        int rid =Integer.valueOf(paramMap.get("rid")+"");
        paramMap.remove("rid");
        boolean b = false;
        for(String key:paramMap.keySet()){
            RolePermissionsEntity rolePermissionsEntity = rolePermissionsDao.findBySql("select * from role_permissions_table where rid="+rid+" and pid="+Integer.valueOf(paramMap.get(key)+""));
            if(rolePermissionsEntity!=null){
                continue;
            }else{
                RolePermissionsEntity rpe = new RolePermissionsEntity();
                rpe.setRid(rid);
                rpe.setPid(Integer.valueOf(paramMap.get(key)+""));
                b = rolePermissionsDao.add(rpe);
            }
        }
        return b;
    }
    
    public List<RoleEntity> getRole(){
        return roleDao.findAll();
    }


    public List<RoleEntity> get(Integer page, Integer limit){
        return roleDao.findPage(page, limit);
    }

    public List<RoleEntity> search(String value, String column){
        Map<String, Object> map = new HashMap<>();
        map.put(column,value);
        List<RoleEntity> list = roleDao.findByCondition(map);
        return list;
    }

    public boolean del(String value){
        boolean is = true;
        String[] values = value.split(",");
        try {
            for (int i = 1; i < values.length; i++) {
                roleDao.deleteById(Integer.valueOf(values[i]));
            }
        }catch (Exception e){
            is = false;
        }
        return is;
    }

    public String saveOrUpdate(RoleEntity bean){
        boolean is = true;
        try {
            roleDao.saveOrUpdate(bean);
        }catch (Exception e){
            is = false;
        }
        return bean.getRid()+"";
    }

    public List<PermissionsEntity> getAll(){
        return permissionsDao.findAll();
    }

    public List<RolePermissionsEntity> getPer(Integer rid){
        Map<String, Object> map = new HashMap<>();
        map.put("rid",rid);
        return rolePermissionsDao.findByCondition(map);
    }

    public boolean addOrUpdatePer(Integer rid, String pid){
        boolean is = true;
        try {
            rolePermissionsDao.exec("delete from role_permissions_table where rid=" + rid);
            String[] pids = pid.split(",");
            for (int i = 1; i < pids.length; i++) {
                rolePermissionsDao.saveOrUpdate(new RolePermissionsEntity(Integer.valueOf(pids[i]), rid));
            }
        }catch (Exception e){
            is = false;
        }
        return is;
    }
}
