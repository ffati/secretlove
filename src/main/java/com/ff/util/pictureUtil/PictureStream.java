package com.ff.util.pictureUtil;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @ClassName PictureStream
 * @Description TODO
 * @Author ff
 * @Date 2020/1/8 12:40
 * @ModifyDate 2020/1/8 12:40
 * @Version 1.0
 */

@Component
public class PictureStream {



    /**
     * @author: ff
     * @date: 2020/1/8 17:50
     * @param: [httpServletResponse, file]
     * @return: void
     * 页面显示图片
     */
    public static void showPicture(HttpServletResponse httpServletResponse,File file) {

        InputStream inputStream = null;
        BufferedInputStream bufferedInputStream = null;
        OutputStream outputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
        inputStream = new FileInputStream(file);
        bufferedInputStream = new BufferedInputStream(inputStream);
        outputStream = httpServletResponse.getOutputStream();
        bufferedOutputStream = new BufferedOutputStream(outputStream);

        int index = -1;
        while ((index = bufferedInputStream.read()) != -1) {
            bufferedOutputStream.write(index);
        }
        bufferedOutputStream.flush();

    } catch(Exception e) {

        e.printStackTrace();

    }finally {

        try {
            bufferedInputStream.close();
            bufferedOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}



/**
 * @author: ff
 * @date: 2020/1/8 17:50
 * @param: [picturePath, imgName, file]
 * @return: java.lang.Boolean
 * 上传文件
 */
    public static Boolean wrightPicture(String picturePath,String imgName, MultipartFile file) {


        try {

            File firdir=new File(picturePath);
            if (!firdir.exists()){
                firdir.mkdirs();
            }

            File imgFile=new File(picturePath+"/"+imgName);
            if (imgFile.exists()){
                imgFile.delete();
            }

            file.transferTo(imgFile);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }



}
