package com.yuxiu.edu.shiro;


import com.yuxiu.edu.model.User;
import com.yuxiu.edu.service.UserService;
import com.yuxiu.edu.utils.security.MD5Utils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author yangyun
 * @date 2019-08-08 16:51
 */
public class UserRealm extends AuthorizingRealm {

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权逻辑");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        info.addStringPermission(user.getPassword());
        return info;
    }

    @Autowired
    UserService userService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User user = userService.findUserByUsername(token.getUsername());
        return user == null ? null : new SimpleAuthenticationInfo(user, user.getPassword(), this.getClass().getSimpleName());
    }
}
