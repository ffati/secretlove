package com.ff.util.common;

import com.ff.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName CheckUtil
 * @Description TODO
 * @Author ff
 * @Date 2020/2/28 20:07
 * @ModifyDate 2020/2/28 20:07
 * @Version 1.0
 */

@Component
public class CheckUtil {

    @Autowired
    private UserService userService;

    /*
     * @author: ff
     * @date: 2020/2/28 20:19
     * @param: [phoneNumber]
     * @return: java.lang.Boolean
     * 手机查重true：已注册
     */
    public Boolean checkPhoneNumber(String phoneNumber){

        return userService.checkPhoneNumber(phoneNumber);
    }


}
