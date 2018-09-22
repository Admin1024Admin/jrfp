package com.ky.ct.rzdj;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.ky.ct.rzdj.service.ShiroRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    private static final Logger log = LoggerFactory.getLogger(ShiroFilterFactoryBean.class);
    //将自己的验证方式加入容器
//    @Bean
//    public ShiroRealm shiroRealm(){
//        return new ShiroRealm();
//    }

    @Bean
    public SecurityManager securityManager(ShiroRealm authRealm,CookieRememberMeManager cookieRememberMeManager) {
        log.info("securityManager()");
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 设置realm.
        securityManager.setRealm(authRealm);
//        // 设置rememberMe管理器
//        securityManager.setRememberMeManager(cookieRememberMeManager);
        return securityManager;
    }

    /**
     * realm
     *
     * @return
     */
    @Bean(name = "authRealm")
    public ShiroRealm myAuthRealm(
            @Qualifier("hashedCredentialsMatcher") HashedCredentialsMatcher matcher,
            @Qualifier("ehCacheManager") EhCacheManager  ehCacheManager) {
        log.info("myShiroRealm()");
        ShiroRealm myAuthorizingRealm = new ShiroRealm();
        // 设置密码凭证匹配器
        myAuthorizingRealm.setCredentialsMatcher(matcher); // myShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        // 设置缓存管理器
        myAuthorizingRealm.setCacheManager(ehCacheManager);
        return myAuthorizingRealm;
    }
//    //权限管理，配置主要是Realm的管理认证
//    @Bean
//    public SecurityManager securityManager(ShiroRealm shiroRealm,CacheManager cacheManager, SessionManager sessionManager) {
//        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
//        securityManager.setSessionManager(sessionManager);
//        securityManager.setRealm(shiroRealm);
//        securityManager.setCacheManager(cacheManager);
//        return securityManager;
//    }

    /**
     * 缓存管理器
     * @return
     */
    @Bean
    public EhCacheManager ehCacheManager() {
        EhCacheManager cacheManager = new EhCacheManager();
        cacheManager.setCacheManagerConfigFile("classpath:shiro-ehcache.xml");
        return cacheManager;
    }

    /**
     * cookie对象;
     *
     * @return
     */
    @Bean
    public SimpleCookie rememberMeCookie() {
        log.info("rememberMeCookie()");
        // 这个参数是cookie的名称，对应前端的checkbox 的name = rememberMe
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        // <!-- 记住我cookie生效时间30天（259200） ,单位秒;-->
        simpleCookie.setMaxAge(259200);
        return simpleCookie;
    }

    /**
     * 记住我管理器 cookie管理对象;
     *
     * @return
     */
    @Bean(name = "cookieRememberMeManager")
    public CookieRememberMeManager rememberMeManager() {
        System.out.println("rememberMeManager()");
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMeCookie());
        return cookieRememberMeManager;
    }

    /**
     * 密码匹配凭证管理器
     *
     * @return
     */
    @Bean(name = "hashedCredentialsMatcher")
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        log.info("hashedCredentialsMatcher()");
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("MD5");// 散列算法:这里使用MD5算法;
        hashedCredentialsMatcher.setHashIterations(1024);// 散列的次数，比如散列两次，相当于
        // md5(md5(""));
        return hashedCredentialsMatcher;
    }
    /**
     * 开启shiro aop注解支持. 使用代理方式;所以需要开启代码支持; Controller才能使用@RequiresPermissions
     *
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor sourceAdvisor(SecurityManager securityManager) {
        log.info("authorizationAttributeSourceAdvisor()");
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    //Filter工厂，设置对应的过滤条件和跳转条件
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 必须设置 SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String,String> map = new HashMap<String, String>();
        //登出
        map.put("/logout","logout");
        map.put("/", "anon");//对所有用户认证
        map.put("/login", "anon");
        map.put("/fpxexd/baseMessage","roles[admin]");
        map.put("/**","authc");
        map.put("/images/**","anon");
        //登录
        shiroFilterFactoryBean.setLoginUrl("/");
        //首页
        shiroFilterFactoryBean.setSuccessUrl("/");
        shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorizedUrl");
        //错误页面，认证不通过跳转
        shiroFilterFactoryBean.setUnauthorizedUrl("/error");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        // 未授权界面;
        shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorized");
        return shiroFilterFactoryBean;
    }

    //加入注解的使用，不加入这个注解不生效
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }

    @Bean
    public CacheManager cacheManager(){
        return new EhCacheManager();
    }


    @Bean
    public SessionDAO sessionDAO(){
        return new EnterpriseCacheSessionDAO();
    }

    @Bean
    public SessionManager sessionManager(SessionDAO sessionDAO){
        DefaultWebSessionManager manager = new DefaultWebSessionManager();
        manager.setSessionDAO(sessionDAO);
        manager.setGlobalSessionTimeout(10000);
        manager.setSessionValidationInterval(10000);
        return manager;
    }
    @Bean
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }
}
