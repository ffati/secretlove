package com.ff.util.fileUtil;


import com.ff.util.common.StaticUtil;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.File;

/**
 * @ClassName pictureStream
 * @Description TODO
 * @Author ff
 * @Date 2020/1/7 16:54
 * @ModifyDate 2020/1/7 16:54
 * @Version 1.0
 */

@Component
public class ShowPictureUtil {



    /**
     * @author: ff
     * @date: 2020/1/8 12:51
     * @param: [httpServletResponse, pictureName]
     * @return: void
     * 显示头像
     */
    public void pictureStream(HttpServletResponse httpServletResponse,String imgpath){

        File file=null;
        System.out.println(System.getProperty("user.dir"));

        try {
            if (null==imgpath||imgpath.equals("")||imgpath.length()<12){
                file=ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX+StaticUtil.IMG_DEFAULTIMGPATH);
            }else {
                file=new File(StaticUtil.serverPath()+imgpath);
            }
            FileStream.readFile(httpServletResponse,file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


/*
 * @author: ff
 * @date: 2020/2/18 15:46
 * @param: [httpServletResponse, imgname]
 * @return: void
 * 无需登录显示InnerFelling表白图片
 */
    public void showInnerFellingPicture(HttpServletResponse httpServletResponse,String imgname){

        File file=null;


        try {
            if (null==imgname||imgname.equals("")||imgname.length()<12){
                file=ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX+StaticUtil.IMG_DEFAULTLODINGIMAGE);
            }else {

                StringBuffer stringBuffer=new StringBuffer(StaticUtil.serverPath());

                if (imgname.startsWith("v")) {

                    file = new File(stringBuffer.append(StaticUtil.PATH_VISITORINNERFELLINGIMAGE).append(imgname.substring(1, 7)).append("/").append(imgname).toString());
                } else {

                    file = new File(stringBuffer.append(StaticUtil.PATH_REGISTERINNERFELLINGIMAGE).append(imgname.substring(0, 12)).append("/").append(imgname).toString());
                }
            }
            FileStream.readFile(httpServletResponse,file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
