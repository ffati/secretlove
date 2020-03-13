package com.ff.util.fileUtil;

import com.ff.service.registInnerFeeling.RegistInnerFeelingService;
import com.ff.util.common.CurrentUser;
import com.ff.util.common.StaticUtil;
import com.ff.vo.CurrentUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName fileUtil
 * @Description TODO
 * @Author ff
 * @Date 2020/2/26 10:17
 * @ModifyDate 2020/2/26 10:17
 * @Version 1.0
 */

@Component
public class MediaFileUtil {

    @Autowired
    private CurrentUser currentUserUtil;

    @Autowired
    private FileStream fileStream;

    @Autowired
    private RegistInnerFeelingService registInnerFeelingService;

    public String uploadFile(HttpServletRequest httpServletRequest, MultipartFile file, String indexnumber){


        int fileType=0;
        if (StaticUtil.fileType(file).startsWith("AUDIO")){

            fileType=1;
        }else if (StaticUtil.fileType(file).startsWith("VIDEO")){

            fileType=2;
        }else {

            return "error";
        }


        int pointIndex=0;
        int nameLength=0;
        String fileName=null;
        String path=null;
        SimpleDateFormat fileNameSimpleDateFormat =null;
        Boolean flage=true;

        pointIndex = file.getOriginalFilename().lastIndexOf(".");
        nameLength = file.getOriginalFilename().length();

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

        if (fileType==1){

            fileName =new StringBuffer("Music").append(currentUserVo.getUserid().toString()).append(fileNameSimpleDateFormat.format(new Date())).append(maxpageorder).append(indexnumber).append( file.getOriginalFilename().substring(pointIndex, nameLength)).toString();
        }else {

            fileName =new StringBuffer("Video").append(currentUserVo.getUserid().toString()).append(fileNameSimpleDateFormat.format(new Date())).append(maxpageorder).append(indexnumber).append( file.getOriginalFilename().substring(pointIndex, nameLength)).toString();
        }

        path = StaticUtil.vicitorPictureUtil(currentUserVo.getUserid(), 1);

        flage=fileStream.wrightFile(path,fileName,file);


        return new StringBuffer(StaticUtil.PATH_REGISTERINNERFELLINGIMAGE).append(currentUserVo.getUserid()).append("/").append(fileName).toString();
    }


/*
 * @author: ff
 * @date: 2020/2/26 16:15
 * @param: [httpServletResponse, path]
 * @return: void
 * 下载文件
 */
    public void downLoad(HttpServletResponse httpServletResponse,String path){

        StringBuffer stringBuffer=new StringBuffer(StaticUtil.serverPath());
        stringBuffer.append(path);

        File file=new File(stringBuffer.toString());

        fileStream.readFile(httpServletResponse,file);


    }

}
