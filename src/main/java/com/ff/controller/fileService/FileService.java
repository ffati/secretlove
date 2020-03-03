package com.ff.controller.fileService;

import com.ff.util.fileUtil.MediaFileUtil;
import com.ff.util.fileUtil.ShowPictureUtil;
import com.ff.vo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName PictureServer
 * @Description TODO
 * @Author ff
 * @Date 2020/2/16 20:01
 * @ModifyDate 2020/2/16 20:01
 * @Version 1.0
 */

@Controller
@RequestMapping("/fileService")
public class FileService {

    @Autowired
    private ShowPictureUtil showPictureUtil;

    @Autowired
    private MediaFileUtil mediaFileUtil;

/*
 * @author: ff
 * @date: 2020/2/16 20:47
 * @param: [httpServletResponse, imgpath]
 * @return: void
 * 显示图片
 */

    @PreAuthorize("isAuthenticated()")
    @RequestMapping("/showHeadSculpture")
    public void showHeadSculpture(
            HttpServletResponse httpServletResponse,
            @RequestParam(value = "imgpath",required = true) String imgpath
    ){

        showPictureUtil.pictureStream(httpServletResponse,imgpath);
    }



    @RequestMapping("/vicitorConfessionPictureUtil")
    public void vicitorPictureUtil(
            HttpServletResponse httpServletResponse,
            @RequestParam(value = "pictureName",required = true) String pictureName
    ){

        showPictureUtil.showInnerFellingPicture(httpServletResponse,pictureName);
    }

    @ResponseBody
    @PreAuthorize("isAuthenticated()")
    @RequestMapping("/uploadMediaFileUtil")
    public Message mediaFileUtil(
            HttpServletRequest httpServletRequest,
            @RequestParam(value = "mediaFile",required = true) MultipartFile file,
            @RequestParam(value = "index",required = false,defaultValue = "0")String indexnumber

    ){

        Message message=new Message();

        String flage=mediaFileUtil.uploadFile(httpServletRequest,file,indexnumber);


        if ("error".equals(flage)){
            message.setInformation("上传失败");
            message.setStatusCode("403");

        }else {

            message.setIndividuationMessage(flage);
            message.setInformation("上传成功");
            message.setStatusCode("200");
        }

        return message;
    }


    @RequestMapping("/downLoadFile")
    public void downLoadFile(
            HttpServletResponse httpServletResponse,
            @RequestParam(value = "filepath",required = true) String filepath
    ){

        mediaFileUtil.downLoad(httpServletResponse,filepath);
    }


}
