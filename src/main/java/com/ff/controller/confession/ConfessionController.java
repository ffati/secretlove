package com.ff.controller.confession;

import com.ff.entity.ConfessionViewWallEntity;
import com.ff.entity.RegisterInnerFeelingEntity;
import com.ff.entity.VicitorInnerFeelingEntity;
import com.ff.service.confessionViewWall.ConfessionViewWallService;
import com.ff.service.registInnerFeeling.RegistInnerFeelingService;
import com.ff.service.vicitorInnerFeeling.VicitorInnerFeelingService;
import com.ff.util.common.CurrentUser;
import com.ff.util.common.StaticUtil;
import com.ff.util.pictureUtil.PictureStream;
import com.ff.vo.CurrentUserVo;
import com.ff.vo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

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
public class ConfessionController {

    @Autowired
    private VicitorInnerFeelingService vicitorInnerFeelingService;

    @Autowired
    private RegistInnerFeelingService registInnerFeelingService;

    @Autowired
    private CurrentUser currentUserUtil;

    @Autowired
    private ConfessionViewWallService confessionViewWallService;

/*
 * @author: ff
 * @date: 2020/2/17 13:03
 * @param: [httpServletRequest, httpSession, model]
 * @return: java.lang.String
 * 展示墙
 */
    @RequestMapping("/wall")
    public String allCommodity(
            Model model,
            HttpSession httpSession
    ){

        if (currentUserUtil.currentUserIsAuthenticated()){
            CurrentUserVo currentUserVo=currentUserUtil.currentUser(httpSession);
            model.addAttribute("headSculpture",currentUserVo.getHeadPictureaddress());
        }

        return "confession/confessionWall";
    }

/*
 * @author: ff
 * @date: 2020/2/17 18:43
 * @param: [page]
 * @return: java.util.List<com.ff.entity.ConfessionViewWallEntity>
 * 流加载照片墙
 */
    @ResponseBody
    @RequestMapping("findForPage")
    public  List<ConfessionViewWallEntity> findForPage(
            @RequestParam(value = "page",defaultValue = "1")Integer page

    ){
        page=page-1;
        List<ConfessionViewWallEntity> confessionViewWallEntitiesList= confessionViewWallService.findForPage(page*16,16);

        return confessionViewWallEntitiesList;
    }

/*
 * @author: ff
 * @date: 2020/2/17 20:07
 * @param: []
 * @return: java.lang.String
 * 展示总页数
 */
    @ResponseBody
    @RequestMapping("/totalPage")
    public String totalPage(){

        Integer totalNumber=confessionViewWallService.countAll();

        double totalPage=0.0;

        if (totalNumber<17&&totalNumber>0){
            totalPage=1.0;
        }else {
            totalPage=Math.ceil(totalNumber/16);

        }

        return String.valueOf(totalPage);
    }

/*
 * @author: ff
 * @date: 2020/2/17 13:03
 * @param: [httpSession, model]
 * @return: java.lang.String
 * 提交页面
 *
 */
    @RequestMapping("/toconfession")
    public String  toconfession(
            HttpSession httpSession,
            Model model
            ){

        if (currentUserUtil.currentUserIsAuthenticated()){
            CurrentUserVo currentUserVo=currentUserUtil.currentUser(httpSession);
            model.addAttribute("headSculpture",currentUserVo.getHeadPictureaddress());
        }

        return "confession/toconfession";
    }


    /*
     * @author: ff
     * @date: 2020/2/11 13:12
     * @param: [httpServletRequest, file]
     * @return: com.ff.vo.Message
     * 用户图片上传
     */
    @RequestMapping("/uploadPicture")
    @ResponseBody
    public Message uploadPicture(
            HttpServletRequest httpServletRequest,
            @RequestParam(value = "file",required = true) MultipartFile file,
            @RequestParam(value = "userid") String userid,
            @RequestParam(value = "type") String type
    ){

        Message message=new Message();
        CurrentUserVo currentUserVo=currentUserUtil.currentUser(httpServletRequest.getSession());

        int pointIndex=file.getOriginalFilename().lastIndexOf(".");
        int nameLength=file.getOriginalFilename().length();
        String fileName=currentUserVo.getUserid().toString()+file.getOriginalFilename().substring(pointIndex,nameLength);

        Boolean decision=PictureStream.wrightPicture(StaticUtil.anyPath(userid,type),fileName,file);

        if (!decision){
            message.setInformation("上传失败");
            message.setStatusCode("403");
            return message;
        }else {
            message.setIndividuationMessage(fileName);
            message.setInformation("上传成功");
            message.setStatusCode("200");
        }

        return message;
    }




/*
 * @author: ff
 * @date: 2020/2/17 13:05
 * @param: [httpServletRequest, httpSession, registerInnerFeelingEntity, vicitorInnerFeelingEntity]
 * @return: com.ff.vo.Message
 *
 * 保存话语
 */
    @ResponseBody
    @RequestMapping("/insertOneFeeling")
    public Message  insertOneVicitorFeeling(
            HttpServletRequest httpServletRequest,
            HttpSession httpSession,
            RegisterInnerFeelingEntity registerInnerFeelingEntity,
            VicitorInnerFeelingEntity vicitorInnerFeelingEntity
    ){

        Message message=new Message();
        Boolean flage=currentUserUtil.currentUserIsAuthenticated();
        if (flage) {
            CurrentUserVo currentUserVo=currentUserUtil.currentUser(httpSession);

            registerInnerFeelingEntity.setUserId(currentUserVo.getUserid());
            registerInnerFeelingEntity.setUserName(currentUserVo.getUsername());
            registerInnerFeelingEntity.setCustomized("0");
            registerInnerFeelingEntity.setPhoneNumber(currentUserVo.getPhonenumber());
            registInnerFeelingService.insertOneRegistFeeling(registerInnerFeelingEntity);
        } else {
            vicitorInnerFeelingService.insertOneVicitorFeeling(vicitorInnerFeelingEntity);
        }

        message.setInformation("保存成功！");
        message.setStatusCode("200");

        return message;
    }



}
