package com.ff.controller.individuation;

import com.alibaba.fastjson.JSONObject;
import com.ff.controller.confession.ConfessionController;
import com.ff.entity.ConfessionViewWallEntity;
import com.ff.entity.RegisterInnerFeelingEntity;
import com.ff.service.confessionViewWall.ConfessionViewWallService;
import com.ff.service.registInnerFeeling.RegistInnerFeelingService;
import com.ff.util.common.CurrentUser;
import com.ff.util.common.SensitiveWordDetectionUtil;
import com.ff.util.common.StaticUtil;
import com.ff.vo.CurrentUserVo;
import com.ff.vo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName IndividuationController
 * @Description TODO
 * @Author ff
 * @Date 2020/1/31 11:11
 * @ModifyDate 2020/1/31 11:11
 * @Version 1.0
 */

@Controller
@RequestMapping("/individuation")
public class IndividuationController {

    @Autowired
    private CurrentUser currentUserUtil;

    @Autowired
    private RegistInnerFeelingService registInnerFeelingService;

    @Autowired
    private ConfessionViewWallService confessionViewWallService;

    @Autowired
    private ConfessionController confessionController;
    /*
     * @author: ff
     * @date: 2020/2/26 17:00
     * @param: [httpSession, model]
     * @return: java.lang.String
     * 定制页面
     */
    @PreAuthorize("isAuthenticated()")
    @RequestMapping("/individuationPage")
    public String allCommodity(
            HttpSession httpSession,
            Model model
    ){

        if (currentUserUtil.currentUserIsAuthenticated()){
            CurrentUserVo currentUserVo=currentUserUtil.currentUser(httpSession);
            model.addAttribute("headSculpture",currentUserVo.getHeadPictureaddress());
        }

        return "individuation/toIndividuation";
    }



    /*
     * @author: ff
     * @date: 2020/2/26 18:59
     * @param: [httpServletRequest, approachAnimationSwitch, backgroundEffectSwitch, dropEffectSwitch, musicSwitch, registerInnerFeelingEntity]
     * @return: com.ff.vo.Message
     * 保存定制
     */
    @ResponseBody
    @PreAuthorize("isAuthenticated()")
    @RequestMapping("/saveIndividuation")
    public Message saveIndividuation(
        HttpServletRequest httpServletRequest,
        @RequestParam(value = "approachAnimationSwitch",required = false,defaultValue = "off")String approachAnimationSwitch,
        @RequestParam(value = "backgroundEffectSwitch",required = false,defaultValue = "off")String backgroundEffectSwitch,
        @RequestParam(value = "dropEffectSwitch",required = false,defaultValue = "off")String dropEffectSwitch,
        @RequestParam(value = "musicSwitch",required = false,defaultValue = "off")String musicSwitch,
        @RequestParam(value = "dropEffect",required = false,defaultValue = "off")String dropEffect,
        RegisterInnerFeelingEntity registerInnerFeelingEntity
    ){

        Message message=new Message();

        registerInnerFeelingEntity.setContent(SensitiveWordDetectionUtil.filterInfo(registerInnerFeelingEntity.getContent()));
        registerInnerFeelingEntity.setClue(SensitiveWordDetectionUtil.filterInfo(registerInnerFeelingEntity.getClue()));


        /*特效列表*/
        Map<String ,String > effect=new HashMap<String ,String>();
        effect.put("approachAnimationSwitch",approachAnimationSwitch);
        effect.put("musicSwitch",musicSwitch);
        effect.put("backgroundEffectSwitch",backgroundEffectSwitch);
        effect.put("dropEffectSwitch",dropEffectSwitch);


        String userid= currentUserUtil.currentUser(httpServletRequest.getSession()).getUserid();


        /*查询第几次使用*/
        String maxpageorder=registInnerFeelingService.findMaxPageOrder(userid);
        /*处理特殊情况*/
        if (null==maxpageorder||maxpageorder.equals("")){
            maxpageorder="1";
        }else {
            maxpageorder=String.valueOf(Integer.valueOf(maxpageorder)+1);
        }

        /*取出一张作为正常模式背景*/
        if (!registerInnerFeelingEntity.getCyclicDisplayImgList().equals("")) {
            JSONObject jsonObject = JSONObject.parseObject(registerInnerFeelingEntity.getCyclicDisplayImgList());
            Map<String, Object> imgMap = (Map<String, Object>) jsonObject;
            registerInnerFeelingEntity.setBackgroundImagSrc(imgMap.get(0).toString());
        }else {

            registerInnerFeelingEntity.setBackgroundImagSrc("");
        }
        registerInnerFeelingEntity.setSpecialEffectsList(StaticUtil.convertedIntoJsonString(effect));
        registerInnerFeelingEntity.setCustomized("1");
        registerInnerFeelingEntity.setPageOrder(maxpageorder);
        registerInnerFeelingEntity.setUserId(userid);
        Boolean flage=registInnerFeelingService.insertOneRegistFeeling(registerInnerFeelingEntity);


        if (flage){

            if (confessionViewWallService.countAll()>160){
                confessionViewWallService.deleteOneEarliest();
            }

            Integer totalpage=Integer.valueOf(confessionController.totalPage())-1;
            /*保存到展示墙*/
            ConfessionViewWallEntity confessionViewWallEntity=new ConfessionViewWallEntity();
            confessionViewWallEntity.setRegistrationStatus("1");
            confessionViewWallEntity.setContent(registerInnerFeelingEntity.getContent());
            confessionViewWallEntity.setClue(registerInnerFeelingEntity.getClue());
            confessionViewWallEntity.setReceiver(registerInnerFeelingEntity.getReceiver());
            confessionViewWallEntity.setBackgroundImagSrc(registerInnerFeelingEntity.getBackgroundImagSrc());
            confessionViewWallService.insertOne(totalpage,confessionViewWallEntity);

            message.setInformation("上传成功");
            message.setStatusCode("200");
        }else {

            message.setInformation("上传失败");
            message.setStatusCode("403");
        }


        return message;
    }




    @RequestMapping("/showLovePage")
    public String showLovePage(

    ){

        return "individuation/individuation";
    }


}
