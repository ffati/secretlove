package com.ff.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName LoginAndRegisterController
 * @Description TODO
 * @Author ff
 * @Date 2020/1/31 11:15
 * @ModifyDate 2020/1/31 11:15
 * @Version 1.0
 */

@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping("/loginPage")
    public String allCommodity(){

        return "loginAndRegister/login";
    }


}
