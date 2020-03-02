package com.ff.controller.homePage;

import com.ff.entity.RegisterInnerFeelingEntity;
import com.ff.entity.VicitorInnerFeelingEntity;
import com.ff.service.registInnerFeeling.RegistInnerFeelingService;
import com.ff.service.vicitorInnerFeeling.VicitorInnerFeelingService;
import com.ff.util.common.CurrentUser;
import com.ff.vo.CurrentUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

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

    @Autowired
    private CurrentUser currentUserUtil;

    @RequestMapping("/homepage")
    public String home(
            HttpServletRequest request,
            HttpSession httpSession,
            Model model
    ){

/*        //取出当前用户
        Principal principal = request.getUserPrincipal();
        System.out.println(principal.getName());*/

        if (currentUserUtil.currentUserIsAuthenticated()){
            CurrentUserVo currentUserVo=currentUserUtil.currentUser(httpSession);
            model.addAttribute("headSculpture",currentUserVo.getHeadPictureaddress());
        }

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

    /*    @PreAuthorize("isAuthenticated()")
        @Secured("ROLE_ADMIN")*/
    @RequestMapping("/searchConfession")
    public String searchConfession(
            HttpSession httpSession,
            Model model,
            @RequestParam(value = "searchParam")String param
    ){

        if (currentUserUtil.currentUserIsAuthenticated()){
            CurrentUserVo currentUserVo=currentUserUtil.currentUser(httpSession);
            model.addAttribute("headSculpture",currentUserVo.getHeadPictureaddress());
        }
        long vicitorStartTime=System.currentTimeMillis();
        List<VicitorInnerFeelingEntity> vicitorInnerFeelingEntityList= vicitorInnerFeelingService.searchVicitorFelling(param);
        long vicitorEndTime=System.currentTimeMillis();
        System.out.println("游客表执行的时间"+(vicitorEndTime-vicitorStartTime));

        if (null!=vicitorInnerFeelingEntityList && vicitorInnerFeelingEntityList.size()!=0){

            model.addAttribute("showModel",vicitorInnerFeelingEntityList.get(0));
        }else {
            long registerStartTime=System.currentTimeMillis();
            List<RegisterInnerFeelingEntity> registerInnerFeelingEntityList=registInnerFeelingService.searchRegisterFelling(param);
            long registerEndTime=System.currentTimeMillis();
            System.out.println("注册表表执行的时间"+(registerEndTime-registerStartTime));

            if (registerInnerFeelingEntityList.size()==1) {
                if (null != registerInnerFeelingEntityList && registerInnerFeelingEntityList.get(0).getCustomized().equals("0")) {

                    model.addAttribute("showModel", registerInnerFeelingEntityList.get(0));
                    return "confession/confessionPage";
                } else if (null != registerInnerFeelingEntityList && registerInnerFeelingEntityList.get(0).getCustomized().equals("1")) {

                    model.addAttribute("showModel", registerInnerFeelingEntityList.get(0));
                    return "individuation/individuation";
                }
            }else if (registerInnerFeelingEntityList.size()==0){

                return "confession/lonelyPage";
            }
        }

        return "confession/confessionPage";
    }


}
