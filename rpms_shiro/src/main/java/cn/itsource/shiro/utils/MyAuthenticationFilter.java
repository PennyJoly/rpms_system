package cn.itsource.shiro.utils;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class MyAuthenticationFilter extends FormAuthenticationFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest  request, ServletResponse response, Object mappedValue) {

        HttpServletRequest httpServletRequest = (HttpServletRequest)request;
        String method = httpServletRequest.getMethod();
        //如果是OPTIONS请求，直接放行
        if ("OPTIONS".equalsIgnoreCase(method)){
            return true;
        }
        //如果不是，照原路执行
        return super.isAccessAllowed(request,response,mappedValue);
    }
}
