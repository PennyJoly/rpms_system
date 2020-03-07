package cn.itsource.rpms.web.controller;

import cn.itsource.basic.util.AjaxResult;
import cn.itsource.rpms.common.domain.User;
import cn.itsource.rpms.service.IUserService;
import cn.itsource.shiro.utils.UserContext;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 登录相关controller
 */
@Controller
@CrossOrigin
public class LoginController {

    @Autowired
    private IUserService userService;

    @RequestMapping(method = RequestMethod.POST,value = "/login")
    @ResponseBody
    public AjaxResult login(@RequestBody User user){
        //获取当前登录用户
        Subject subject = SecurityUtils.getSubject();
        try {
            if (!subject.isAuthenticated()){
                UsernamePasswordToken token = new UsernamePasswordToken(user.getName(),user.getPassword());
                //验证身份
                subject.login(token);
            }
            //将用户保存到session中
            UserContext.setUser((User) subject.getPrincipal());

            //获取当前用户
            User user1 = UserContext.getUser();
            user1.setPassword(null);

            Map map = new HashMap();
            //封装map
            map.put("user",user1);
            map.put("token",subject.getSession().getId());

            AjaxResult ajaxResult = new AjaxResult();
            ajaxResult.setMsg("登陆成功");
            ajaxResult.setSuccess(true);
            ajaxResult.setResultObject(map);
            //设置前台获取格式为：{msg:msg,success:'xxx',setResultObject:{user:'user1',token:'xxxx'}}
            return ajaxResult;
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            return new AjaxResult("用户名不存在！");
        } catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            return new AjaxResult("密码错误！");
        }catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult("网络异常！");
        }
    }

}
