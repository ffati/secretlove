package com.ff.controller.security;

import com.ff.vo.Message;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName SecurityController
 * @Description TODO
 * @Author ff
 * @Date 2020/2/11 16:51
 * @ModifyDate 2020/2/11 16:51
 * @Version 1.0
 */

@Controller
@RequestMapping("/security")
public class SecurityController {

    @RequestMapping("/accessDenied")
    public String accessDenied(){
        return "publicContent/accessDenied";
    }


    @RequestMapping("/loginError")
    @ResponseBody
    public Message loginError(HttpServletRequest httpServletRequest){

        AuthenticationException authenticationException = (AuthenticationException) httpServletRequest.getSession().getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
        Message message=new Message();

        message.setStatusCode("477");
        if (authenticationException instanceof UsernameNotFoundException || authenticationException instanceof BadCredentialsException) {
            message.setInformation("用户名或密码错误");
        } else if (authenticationException instanceof DisabledException) {
            message.setInformation("用户已被禁用");
        } else if (authenticationException instanceof LockedException) {
            message.setInformation("账户被锁定");
        } else if (authenticationException instanceof AccountExpiredException) {
            message.setInformation("账户过期");
        } else if (authenticationException instanceof CredentialsExpiredException) {
            message.setInformation("证书过期");
        } else {
            message.setInformation("登录失败");
        }

        return message;

    }


}
