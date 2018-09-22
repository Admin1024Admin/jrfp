package com.ky.ct.rzdj.service;

import com.ky.ct.rzdj.dao.PermissionsDao;
import com.ky.ct.rzdj.dao.RoleDao;
import com.ky.ct.rzdj.dao.RolePermissionsDao;
import com.ky.ct.rzdj.dao.UserDao;
import com.ky.ct.rzdj.model.PermissionsEntity;
import com.ky.ct.rzdj.model.RoleEntity;
import com.ky.ct.rzdj.model.RolePermissionsEntity;
import com.ky.ct.rzdj.model.RzdjUserEntity;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShiroRealm extends AuthorizingRealm{
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private PermissionsDao permissionsDao;
    @Autowired
    private RolePermissionsDao rolePermissionsDao;
    //角色权限和对应权限添加
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取登录用户名
        String name = (String) principalCollection.getPrimaryPrincipal();
        //添加角色和权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        RzdjUserEntity userEntity = userDao.findByNo("loginName",name);
        RoleEntity roleEntity = roleDao.findBySql("select * from role where rid="+userEntity.getRole());
        //添加角色
        simpleAuthorizationInfo.addRole(roleEntity.getRname());
        //添加权限
        List<RolePermissionsEntity> permissionsEntitys = rolePermissionsDao.findListBySql("select * from role_permissions_table where rid="+roleEntity.getRid());
       for(RolePermissionsEntity r:permissionsEntitys){
           PermissionsEntity permissionsEntity =  permissionsDao.findBySql("select * from permissions where pid="+r.getPid());
           simpleAuthorizationInfo.addStringPermission(permissionsEntity.getPurl());
       }
        return simpleAuthorizationInfo;
    }

    //用户认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken atoken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) atoken;
        String username = token.getUsername();
        char[] password = token.getPassword();
        RzdjUserEntity userEntity = userDao.findByNo("loginName",username);
        System.out.println("user-->"+userEntity);
        if (userEntity == null) {
            throw new UnknownAccountException("用户不存在");
        }//这里验证authenticationToken和simpleAuthenticationInfo的信息

        //将角色id保存到session 后期录入的时候查询到单位
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        request.getSession().setAttribute("currentUser",userEntity);
        SecurityUtils.getSubject().getSession().setAttribute("currentUser",userEntity);
        String realmName = getName();
        //MD5盐值加密 使用SimpleAuthenticationInfo四个参数的构造函数
        ByteSource credentialsSalt = ByteSource.Util.bytes("123afhdsfhj");
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(userEntity.getLoginName(),userEntity.getPwd(),credentialsSalt,realmName);
        return simpleAuthenticationInfo;
    }

    public static String md5(String msg){
        ByteSource credentialsSalt = ByteSource.Util.bytes("123afhdsfhj");
        Object result =new SimpleHash("MD5", msg, credentialsSalt, 1024);
        System.out.println(msg+"MD5加密后的结果为"+result.toString());
        return result.toString();
    }
//    public static void main(String[] args){
//        ByteSource credentialsSalt = ByteSource.Util.bytes("123afhdsfhj");
//        Object result =new SimpleHash("MD5", "123456", credentialsSalt, 1024);
//        System.out.println("123456"+"MD5加密后的结果为"+result.toString());
//    }
}
