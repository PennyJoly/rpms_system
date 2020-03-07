package cn.itsource.shiro.utils;

import cn.itsource.rpms.common.domain.User;
import org.apache.shiro.SecurityUtils;

public class UserContext {
    public static final String User_IN_SESSION = "user_in_session";

    public static void setUser(User user){
        SecurityUtils.getSubject().getSession().setAttribute(User_IN_SESSION,user);
    }

    public static User getUser(){
        return (User)SecurityUtils.getSubject().getSession().getAttribute(User_IN_SESSION);
    }
}
