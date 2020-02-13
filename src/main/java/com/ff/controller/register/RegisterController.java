package com.ff.controller.register;

import com.ff.entity.RegisterUserEntity;
import com.ff.service.user.UserService;
import com.ff.util.common.RandomNumberUtil;
import com.ff.vo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName RegisterController
 * @Description TODO
 * @Author ff
 * @Date 2020/1/31 11:17
 * @ModifyDate 2020/1/31 11:17
 * @Version 1.0
 */

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private UserService userService;

    @Autowired
    private RandomNumberUtil randomNumberUtil;


    @RequestMapping("/registerPage")
    public String allCommodity(){

        return "loginAndRegister/register";
    }


    @ResponseBody
    @RequestMapping("/registerUser")
    public Message registeruUser(
            HttpServletRequest httpServletRequest,
            @RequestParam(value = "identifyingcode",required = false) String identifyingcode,
            RegisterUserEntity registerUserEntity){

        Message message=new Message();
        registerUserEntity.setUserId(randomNumberUtil.userIdentifier(registerUserEntity.getSex()));
        registerUserEntity.setCustomerType("ROLE_USER");
        registerUserEntity.setUserStatus("1");

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String bcryprPassword=passwordEncoder.encode(registerUserEntity.getUserPassword());
        registerUserEntity.setUserPassword(bcryprPassword);

        Boolean flage=userService.insertRegisterUser(registerUserEntity);

        if (flage){
            message.setStatusCode("200");
            message.setInformation("注册成功!");

        }else {
            message.setInformation("注册失败!");
            message.setStatusCode("403");
        }


        return message;
    }
}
