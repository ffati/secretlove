package com.ff.controller.confession;

import com.ff.entity.VicitorInnerFeelingEntity;
import com.ff.service.vicitorInnerFeeling.VicitorInnerFeelingService;
import com.ff.util.common.CurrentUser;
import com.ff.util.common.StaticUtil;
import com.ff.util.pictureUtil.PictureStream;
import com.ff.vo.CurrentUserVo;
import com.ff.vo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

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
    private CurrentUser currentUserUtil;

    @RequestMapping("/wall")
    public String allCommodity(
            HttpServletRequest httpServletRequest
    ){
        return "confession/confessionWall";
    }

    @RequestMapping("/confession")
    public String  confession(){

        return "confession/confessionPage";
    }

    @RequestMapping("/toconfession")
    public String  toconfession(){

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
            @RequestParam(value = "file",required = true) MultipartFile file
    ){

        Message message=new Message();
        CurrentUserVo currentUserVo=currentUserUtil.currentUser(httpServletRequest.getSession());

        int pointIndex=file.getOriginalFilename().lastIndexOf(".");
        int nameLength=file.getOriginalFilename().length();
        String fileName=currentUserVo.getUserid().toString()+file.getOriginalFilename().substring(pointIndex,nameLength);

        Boolean decision=PictureStream.wrightPicture(StaticUtil.getImgUserpicturepath(),fileName,file);

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


    @ResponseBody
    @RequestMapping("/insertOneVicitorFeeling")
    public Message  insertOneVicitorFeeling(
            HttpServletRequest httpServletRequest,
            VicitorInnerFeelingEntity vicitorInnerFeelingEntity
    ){
        Message message=new Message();
        vicitorInnerFeelingService.insertOneVicitorFeeling(vicitorInnerFeelingEntity);

        message.setInformation("保存成功！");
        message.setStatusCode("200");

        return message;
    }



}
