package com.ff.controller.user;

import com.ff.entity.RegisterUserEntity;
import com.ff.service.user.UserService;
import com.ff.util.common.CheckUtil;
import com.ff.util.common.RandomNumberUtil;
import com.ff.vo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
@RequestMapping("/user")
public class UserManagementController {

    @Autowired
    private UserService userService;

    @Autowired
    private RandomNumberUtil randomNumberUtil;

    @Autowired
    private CheckUtil checkUtil;



    @RequestMapping("/registerPage")
    public String allCommodity(){

        return "loginAndRegister/register";
    }


    /*
     * @author: ff
     * @date: 2020/2/28 19:49
     * @param: [httpServletRequest, identifyingcode, registerUserEntity]
     * @return: com.ff.vo.Message
     * 用户注册
     */
    @ResponseBody
    @RequestMapping("/registerUser")
    public Message registeruUser(
            HttpServletRequest httpServletRequest,
            @RequestParam(value = "identifyingcode",required = false) String identifyingcode,
            RegisterUserEntity registerUserEntity
    ){

        Message message=new Message();

        if (checkUtil.checkPhoneNumber(registerUserEntity.getPhoneNumber())){

            message.setInformation("手机号码已注册!");
            message.setStatusCode("403");

            return message;
        }

        registerUserEntity.setUserId(randomNumberUtil.userIdentifier(registerUserEntity.getSex()));
        registerUserEntity.setCustomerType("ROLE_USER");
        registerUserEntity.setUserStatus("1");
        registerUserEntity.setUserName(registerUserEntity.getPhoneNumber());

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


/*
 * @author: ff
 * @date: 2020/2/28 19:50
 * @param: [userId, nickName]
 * @return: com.ff.vo.Message
 * 资料修改
 */
    @ResponseBody
    @PreAuthorize("isAuthenticated()")
    @RequestMapping("/modifyData")
    public Message modifyData(
            @RequestParam(value = "userId")String userId,
            @RequestParam(value = "userName")String userName,
            @RequestParam(value = "nickName")String nickName

    ){
        Message message=new Message();
        RegisterUserEntity registerUserEntity=new RegisterUserEntity();
        registerUserEntity.setUserId(userId);
        registerUserEntity.setNickName(nickName);
        registerUserEntity.setUserName(userName);
        Boolean flage=userService.updateRegisterUser(registerUserEntity);

        if (flage){
            message.setStatusCode("200");
            message.setInformation("更改成功!");

        }else {
            message.setInformation("更改失败!");
            message.setStatusCode("403");
        }

        return message;

    }



}
