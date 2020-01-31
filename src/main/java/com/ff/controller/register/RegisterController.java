package com.ff.controller.register;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("/registerPage")
    public String allCommodity(){

        return "loginAndRegister/register";
    }


}
