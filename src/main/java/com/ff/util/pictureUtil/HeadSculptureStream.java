package com.ff.util.pictureUtil;


import com.ff.util.common.StaticUtil;
import org.springframework.beans.factory.annotation.Value;
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
public class HeadSculptureStream {

    private static String IMG_DEFAULTIMGPATH;



    /**
     * @author: ff
     * @date: 2020/1/8 12:51
     * @param: [httpServletResponse, pictureName]
     * @return: void
     */
    public void pictureStream(HttpServletResponse httpServletResponse, String pictureName){

        File file=null;
        System.out.println(System.getProperty("user.dir"));

        try {
            if (null==pictureName||pictureName==""){
                file=ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX+IMG_DEFAULTIMGPATH);
            }else {
                file=new File(StaticUtil.pictureDirPath()+"\\"+pictureName);
            }
            PictureStream.showPicture(httpServletResponse,file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public  String getImgDefaultimgpath() {
        return IMG_DEFAULTIMGPATH;
    }

    @Value("${defaultHeadSculpture}")
    public  void setImgDefaultimgpath(String imgDefaultimgpath) {
        IMG_DEFAULTIMGPATH = imgDefaultimgpath;
    }
}
