package com.ff.controller.homePage;

import com.ff.entity.RegisterInnerFeelingEntity;
import com.ff.entity.VicitorInnerFeelingEntity;
import com.ff.service.registInnerFeeling.RegistInnerFeelingService;
import com.ff.service.vicitorInnerFeeling.VicitorInnerFeelingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * @ClassName HomePageController
 * @Description TODO
 * @Author ff
 * @Date 2020/1/31 19:06
 * @ModifyDate 2020/1/31 19:06
 * @Version 1.0
 */

@Controller
@RequestMapping("/home")
public class HomePageController {

    @Autowired
    private VicitorInnerFeelingService vicitorInnerFeelingService;

    @Resource
    private RegistInnerFeelingService registInnerFeelingService;

    @RequestMapping("/homepage")
    public String home(){

        return "index";
    }

    @RequestMapping("/insidePage")
    public String allCommodity(){

        return "homePage/insideHomePage";
    }

/*
 * @author: ff
 * @date: 2020/2/14 12:30
 * @param: [model, param]
 * @return: java.lang.String
 * 主页搜索
 */
    @RequestMapping("/searchConfession")
    public String searchConfession(
            Model model,
            @RequestParam(value = "searchParam")String param
    ){

        VicitorInnerFeelingEntity vicitorInnerFeelingEntity= vicitorInnerFeelingService.searchVicitorFelling(param);
        if (null!=vicitorInnerFeelingEntity){
            model.addAttribute("showModel",vicitorInnerFeelingEntity);
        }else {
            RegisterInnerFeelingEntity registerInnerFeelingEntity=registInnerFeelingService.searchRegisterFelling(param);
            if (null!=registerInnerFeelingEntity){
                model.addAttribute("showModel",registerInnerFeelingEntity);
            }else {
                return "confession/lonelyPage";
            }
        }
        return "confession/confessionPage";
    }

}
