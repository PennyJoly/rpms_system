package cn.itsource.shiro.realm;

import cn.itsource.basic.util.MD5Util;
import cn.itsource.rpms.common.domain.User;
import cn.itsource.rpms.service.IUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class AuthenRealm extends AuthorizingRealm {

    @Autowired
    private IUserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String principal = (String)token.getPrincipal();
        //查询当前用户
        User user = userService.findByUserName(principal);
        if(user==null){
            //用户不存在
            return null;
        }
        ByteSource salt = ByteSource.Util.bytes(MD5Util.SALT);
        return new SimpleAuthenticationInfo(user,user.getPassword(),salt,getName());
    }
}
