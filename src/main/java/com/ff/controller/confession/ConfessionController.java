package com.ff.controller.confession;

import com.ff.entity.ConfessionViewWallEntity;
import com.ff.entity.RegisterInnerFeelingEntity;
import com.ff.entity.VicitorInnerFeelingEntity;
import com.ff.service.confessionViewWall.ConfessionViewWallService;
import com.ff.service.registInnerFeeling.RegistInnerFeelingService;
import com.ff.service.user.UserService;
import com.ff.service.vicitorInnerFeeling.VicitorInnerFeelingService;
import com.ff.util.common.CurrentUser;
import com.ff.util.common.HttpUtil;
import com.ff.util.common.SensitiveWordDetectionUtil;
import com.ff.util.common.StaticUtil;
import com.ff.util.fileUtil.FileStream;
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
import java.text.SimpleDateFormat;
import java.util.Date;
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

    @Autowired
    private UserService userService;


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

        double totalPage=Math.ceil(totalNumber/16.0);

        if (totalPage>10.0){

            totalPage=10;
        }

        String stringTotalpage=String.valueOf(totalPage);

        return stringTotalpage.substring(0,stringTotalpage.indexOf("."));
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
            @RequestParam(value = "id",required = false,defaultValue = "0")String indexnumber,
            @RequestParam(value = "background",required = true) MultipartFile file
    ){
        Message message=new Message();


        String filetype=StaticUtil.fileType(file);
        if ("unSupport".equals(filetype)){

            message.setInformation("unSupport");
            message.setStatusCode("403");
            return message;
        }


            Boolean flage=currentUserUtil.currentUserIsAuthenticated();

            int pointIndex=0;
            int nameLength=0;
            String fileName=null;
            String path=null;
            Boolean decision =false;
            SimpleDateFormat fileNameSimpleDateFormat =null;
            pointIndex = file.getOriginalFilename().lastIndexOf(".");
            nameLength = file.getOriginalFilename().length();

            if (flage) {
                /*查询第几次使用*/
                String maxpageorder=registInnerFeelingService.findMaxPageOrder(currentUserUtil.currentUser(httpServletRequest.getSession()).getUserid());
                /*处理特殊情况*/
                if (null==maxpageorder||maxpageorder.equals("")){
                    maxpageorder="1";
                }else {
                    maxpageorder=String.valueOf(Integer.valueOf(maxpageorder)+1);
                }
                /*生成文件名*/
                fileNameSimpleDateFormat = new SimpleDateFormat("YYYYMMdd");
                CurrentUserVo currentUserVo = currentUserUtil.currentUser(httpServletRequest.getSession());
                fileName =new StringBuffer( currentUserVo.getUserid().toString()).append(fileNameSimpleDateFormat.format(new Date())).append(maxpageorder).append(indexnumber).append( file.getOriginalFilename().substring(pointIndex, nameLength)).toString();
                path = StaticUtil.vicitorPictureUtil(currentUserVo.getUserid(), 1);
            } else {
                /*非注册用户上传图片*/
                fileNameSimpleDateFormat = new SimpleDateFormat("YYYYMMddHH");
                String ipString = HttpUtil.getIp(httpServletRequest);
                path = StaticUtil.vicitorPictureUtil("", 2);
                fileName = new StringBuffer("v").append(fileNameSimpleDateFormat.format(new Date())).append(ipString.replace(":", "")).append(file.getOriginalFilename().substring(pointIndex, nameLength)).toString();
            }


             decision = FileStream.wrightFile(path, fileName, file);


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
        Integer totalPage=Integer.valueOf(totalPage())-1;

        if (flage) {

            registerInnerFeelingEntity.setContent(SensitiveWordDetectionUtil.filterInfo(registerInnerFeelingEntity.getContent()));
            registerInnerFeelingEntity.setClue(SensitiveWordDetectionUtil.filterInfo(registerInnerFeelingEntity.getClue()));

            CurrentUserVo currentUserVo=currentUserUtil.currentUser(httpSession);
            registerInnerFeelingEntity.setUserId(currentUserVo.getUserid());
            registerInnerFeelingEntity.setUserName(currentUserVo.getUsername());
            registerInnerFeelingEntity.setCustomized("0");
            registerInnerFeelingEntity.setPhoneNumber(currentUserVo.getPhonenumber());
            flage=registInnerFeelingService.insertOneRegistFeeling(registerInnerFeelingEntity);

            if (flage){

                if (confessionViewWallService.countAll()>160){
                    confessionViewWallService.deleteOneEarliest();
                }

                ConfessionViewWallEntity confessionViewWallEntity=new ConfessionViewWallEntity();
                confessionViewWallEntity.setRegistrationStatus("1");
                confessionViewWallEntity.setClue(registerInnerFeelingEntity.getClue());
                confessionViewWallEntity.setContent(registerInnerFeelingEntity.getContent());
                confessionViewWallEntity.setReceiver(registerInnerFeelingEntity.getReceiver());
                confessionViewWallEntity.setBackgroundImagSrc(registerInnerFeelingEntity.getBackgroundImagSrc());
                confessionViewWallService.insertOne(totalPage*16,confessionViewWallEntity);
            }
        } else {

            vicitorInnerFeelingEntity.setContent(SensitiveWordDetectionUtil.filterInfo(vicitorInnerFeelingEntity.getContent()));
            vicitorInnerFeelingEntity.setClue(SensitiveWordDetectionUtil.filterInfo(vicitorInnerFeelingEntity.getClue()));

            flage=vicitorInnerFeelingService.insertOneVicitorFeeling(vicitorInnerFeelingEntity);

            if (flage){

                if (confessionViewWallService.countAll()>160){

                    confessionViewWallService.deleteOneEarliest();
                }

                ConfessionViewWallEntity confessionViewWallEntity=new ConfessionViewWallEntity();
                confessionViewWallEntity.setRegistrationStatus("0");
                confessionViewWallEntity.setClue(vicitorInnerFeelingEntity.getClue());
                confessionViewWallEntity.setContent(vicitorInnerFeelingEntity.getContent());
                confessionViewWallEntity.setReceiver(vicitorInnerFeelingEntity.getReceiver());
                confessionViewWallEntity.setBackgroundImagSrc(vicitorInnerFeelingEntity.getBackgroundImagSrc());
                confessionViewWallService.insertOne(totalPage*16,confessionViewWallEntity);
            }

        }

        if (!flage){
            message.setInformation("保存失败！");
            message.setStatusCode("500");
            return message;
        }

        message.setInformation("保存成功！");
        message.setStatusCode("200");

        return message;
    }



}
