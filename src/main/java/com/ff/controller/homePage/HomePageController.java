package com.ff.controller.homePage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName HomePageController
 * @Description TODO
 * @Author ff
 * @Date 2020/1/31 19:06
 * @ModifyDate 2020/1/31 19:06
 * @Version 1.0
 */

@Controller
@RequestMapping("/homePage")
public class HomePageController {

    @RequestMapping("/insidePage")
    public String allCommodity(){

        return "homePage/insideHomePage";
    }

}
