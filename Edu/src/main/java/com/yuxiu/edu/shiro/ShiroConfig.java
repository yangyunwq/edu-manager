package com.yuxiu.edu.shiro;


import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author yangyun
 * @date 2019-08-08 16:46
 */
@Configuration
public class ShiroConfig {

    @Bean("shiroFilterFactoryBean")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String, String> map = new LinkedHashMap<>();
        map.put("/assets/**", "anon");
        map.put("/user/getCode", "anon");
        map.put("/user/login", "anon");
        map.put("/user/main", "anon");
        map.put("/**", "authc");
        map.put("/add", "perms[user:add]");
        shiroFilterFactoryBean.setLoginUrl("/user/login");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }

    @Bean("securityManager")
    public DefaultWebSecurityManager getdefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    @Bean("userRealm")
    public UserRealm getRealm() {
        return new UserRealm();
    }
}
