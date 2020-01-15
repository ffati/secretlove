package com.ff.util.registerCheck;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName RegisterCheck
 * @Description TODO
 * @Author ff
 * @Date 2019/12/26 21:45
 * @ModifyDate 2019/12/26 21:45
 * @Version 1.0
 */

/*@Component
public class RegisterCheck {

    @Autowired
    private UserService userService;


    *//**
     * @author: ff
     * @date: 2019/12/26 21:49
     * @param: [phoneNum]
     * @return: java.lang.Boolean
     * true为已存在
     *//*
    public Boolean checkPhoneNum(String phoneNum){

        Boolean resultDuplicate= userService.findDuplicatePhoneNumber(phoneNum);
        if (resultDuplicate){
            return true;
        }
        return false;
    }



    *//**
     * @author: ff
     * @date: 2019/12/26 21:54
     * @param: [name]
     * @return: java.lang.Boolean
     *//*
    public Boolean checkUserName(String name){
        UserEntity userEntity=new UserEntity();
        userEntity.setUsername(name);

        if (null!=userService.findByAnyParameter(userEntity)){
            return true;
        }
        return false;
    }


    *//**
     * @author: ff
     * @date: 2020/1/1 16:30
     * @param:
     * @return:
     *//*
    public  List<RoleEntity> findAllRole(){

        List<RoleEntity> allRoleList=userService.findAllRole();
        return allRoleList;
    }


}*/
