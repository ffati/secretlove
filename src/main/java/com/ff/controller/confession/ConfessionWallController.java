package com.ff.controller.confession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName ConfessionWallController
 * @Description TODO
 * @Author ff
 * @Date 2020/1/31 10:59
 * @ModifyDate 2020/1/31 10:59
 * @Version 1.0
 */

@Controller
@RequestMapping("/confession")
public class ConfessionWallController {

    @RequestMapping("/wall")
    public String allCommodity(){

        return "confession/confessionWall";
    }

}
