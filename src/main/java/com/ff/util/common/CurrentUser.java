package com.ff.util.common;


import com.ff.entity.RegisterUserEntity;
import com.ff.service.user.UserService;
import com.ff.vo.CurrentUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

/**
 * @ClassName CurrentUser
 * @Description TODO
 * @Author ff
 * @Date 2020/1/6 20:38
 * @ModifyDate 2020/1/6 20:38
 * @Version 1.0
 */

@Component
public class CurrentUser {

    @Autowired
    private UserService userService;


public CurrentUserVo currentUser(HttpSession session){

    CurrentUserVo currentUserVon=new CurrentUserVo();
    RegisterUserEntity registerUserEntity=new RegisterUserEntity();

    SecurityContextImpl securityContext = (SecurityContextImpl) session.getAttribute("SPRING_SECURITY_CONTEXT");
    registerUserEntity.setUserName(((UserDetails)securityContext.getAuthentication().getPrincipal()).getUsername());
    registerUserEntity=userService.findByAnyParameter(registerUserEntity);

    currentUserVon.setUserid(registerUserEntity.getUserId());
    currentUserVon.setNickName(registerUserEntity.getNickName());
    currentUserVon.setSex(registerUserEntity.getSex());
    currentUserVon.setPhonenumber(registerUserEntity.getPhoneNumber());
    currentUserVon.setRegistrationTime(registerUserEntity.getFirstUseTime());
    currentUserVon.setUsercategory(registerUserEntity.getUserCategory());
    currentUserVon.setHeadPictureaddress(registerUserEntity.getHeadSculptureAddress());
    currentUserVon.setPersonalHomepageImage(registerUserEntity.getPersonalHomepageImage());
    return currentUserVon;

}

public Boolean currentUserIsAuthenticated(){


    Boolean flage=null;

    if (!SecurityContextHolder.getContext().getAuthentication().getName().equals("anonymousUser")) {
        flage=true;
    } else {
        flage=false;
    }

    return flage;
}


}
