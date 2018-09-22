package com.ky.ct.rzdj.service;

import java.util.LinkedHashMap;

public class FilterChainDefinitionMapBuilder {
    public static LinkedHashMap<String,String> buildFilterChainDefinitionMap(){
        LinkedHashMap<String,String> hashMap = new LinkedHashMap<>();
//        配置哪些页面需要受保护.
//        以及访问这些页面需要的权限.
//        anon 可以被匿名访问
//        authc 必须认证(即登录)后才可能访问的页面.
//        logout 登出.
//        roles 角色过滤器
        hashMap.put("/index.jsp","anon");
        hashMap.put("/unauthorized.jsp","anon");
        hashMap.put("/userlist.jsp","authc,roles[root]");
        hashMap.put("/user","authc,roles[root]");
        hashMap.put("/login","anon");
        hashMap.put("/zhuce","anon");
        hashMap.put("/logout","logout");
        hashMap.put("/message.jsp","authc");
        return hashMap;
    }
}
