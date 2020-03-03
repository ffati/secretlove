package com.ff.controller.personalHomepage;

import com.ff.entity.RegisterInnerFeelingEntity;
import com.ff.entity.RegisterUserEntity;
import com.ff.service.registInnerFeeling.RegistInnerFeelingService;
import com.ff.service.user.UserService;
import com.ff.util.common.CurrentUser;
import com.ff.util.common.StaticUtil;
import com.ff.util.fileUtil.FileStream;
import com.ff.vo.CurrentUserVo;
import com.ff.vo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @ClassName PersonalHomepageController
 * @Description TODO
 * @Author ff
 * @Date 2020/2/14 15:08
 * @ModifyDate 2020/2/14 15:08
 * @Version 1.0
 */

@Controller
@RequestMapping("/personal")
public class PersonalHomepageController {

    @Autowired
    private UserService userService;

    @Autowired
    private CurrentUser currentUser;

    @Autowired
    private RegistInnerFeelingService registInnerFeelingService;



    @PreAuthorize("isAuthenticated()")
    @RequestMapping("/homePage")
    public String personalHomepage(
            HttpSession httpSession,
            Model model
    ){

        CurrentUserVo currentUserVo=currentUser.currentUser(httpSession);

        RegisterInnerFeelingEntity registerInnerFeelingEntity=new RegisterInnerFeelingEntity();
        registerInnerFeelingEntity.setUserName(currentUserVo.getUsername());
        registerInnerFeelingEntity.setUserId(currentUserVo.getUserid());
        List<RegisterInnerFeelingEntity> registerInnerFeelingList=registInnerFeelingService.findAllByAnyParam(registerInnerFeelingEntity);


        model.addAttribute("currentUserVo",currentUserVo);
        model.addAttribute("registerInnerFeelingList",registerInnerFeelingList);
        return "/personalHomepage/personalHomepage";
    }


/*
 * @author: ff
 * @date: 2020/2/16 11:40
 * @param: [model, userid]
 * @return: java.lang.String
 * 修改个人资料页面
 */
    @PreAuthorize("isAuthenticated()")
    @RequestMapping("/editPersonaDataPage")
    public String  editPersonaDataPage(
            Model model,
            @RequestParam(value = "userName") String userName
    ){

        RegisterUserEntity registerUserEntity=new RegisterUserEntity();
        registerUserEntity.setUserName(userName);
        registerUserEntity=userService.findByAnyParameter(registerUserEntity);

        model.addAttribute("userName",userName);
        model.addAttribute("userId",registerUserEntity.getUserId());
        model.addAttribute("nickName",registerUserEntity.getNickName());
        model.addAttribute("headSculptureAddress",registerUserEntity.getHeadSculptureAddress());
        model.addAttribute("personalHomepageImage",registerUserEntity.getPersonalHomepageImage());

        return "/personalHomepage/editPersonaDataPage";

    }


    /*
     * @author: ff
     * @date: 2020/2/16 19:23
     * @param: [file, userid, type]
     * @return: com.ff.vo.Message
     * 用户更改头像和背景图片
     */
    @ResponseBody
    @PreAuthorize("isAuthenticated()")
    @RequestMapping("/uploadPicture")
    public Message  uploadPicture(
            @RequestParam(value = "file",required = true) MultipartFile file,
            @RequestParam(value = "userId") String userid,
            @RequestParam(value = "userName") String userName,
            @RequestParam(value = "type") String type
    ){

        Message  message=new Message();

        String filetype=StaticUtil.fileType(file);
        if ("unSupport".equals(filetype)){

            message.setInformation("unSupport");
            message.setStatusCode("403");
            return message;
        }


        int pointIndex=file.getOriginalFilename().lastIndexOf(".");
        int nameLength=file.getOriginalFilename().length();
        /*根据类型上传*/
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYYMMddHHmmss");
        String serverPath=StaticUtil.anyPath(userid,type);
        String fileName=userid+simpleDateFormat.format(new Date())+file.getOriginalFilename().substring(pointIndex,nameLength);
        Boolean decision= FileStream.wrightFile(serverPath,fileName,file);

        /*保存名称在库中*/
        if (decision){
            StringBuffer filePath= new StringBuffer();
            filePath.append(StaticUtil.PATH_USERIMAGEFOLDER).append(userid).append("/").append(type).append("/").append(fileName);
            RegisterUserEntity registerUserEntity=new RegisterUserEntity();
            registerUserEntity.setUserId(userid);
            registerUserEntity.setUserName(userName);
            if (type.equals(StaticUtil.IMG_HEADSCULPTURE)){

                registerUserEntity.setHeadSculptureAddress(filePath.toString());
                decision=userService.updateRegisterUser(registerUserEntity);

            }else if(type.equals(StaticUtil.IMG_PERSONALHOMEPAGEBACKGROUND)){

                registerUserEntity.setPersonalHomepageImage(filePath.toString());
                decision=userService.updateRegisterUser(registerUserEntity);

            }


            if (decision) {
                message.setIndividuationMessage(filePath.toString());
                message.setInformation("更新成功");
                message.setStatusCode("200");
            }else {
                message.setInformation("更新失败");
                message.setStatusCode("403");

            }
        }else {
            message.setInformation("更新失败");
            message.setStatusCode("403");

        }

        return message;
    }





}
