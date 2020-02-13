package com.ff.util.common;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

/**
 * @ClassName StaticUtil
 * @Description TODO
 * @Author ff
 * @Date 2020/1/8 17:33
 * @ModifyDate 2020/1/8 17:33
 * @Version 1.0
 */

@Component
public class StaticUtil {


    private static String IMG_HEADSCULPTUREFOLDERPATH;

    private static String IMG_USERPICTUREPATH;

    static{

        String filePath= null;
        File filedir=null;
        File userPicturedir=null;
        String headSculpturePath=null;
        String UserPicturePath=null;
        try {
            filePath = new File("").getCanonicalPath();
            System.out.println(filePath);
            filePath=filePath.substring(0,filePath.lastIndexOf("\\"));
            headSculpturePath=filePath+"\\SecretLoveImg\\Image\\headSculpture";
            UserPicturePath=filePath+"\\SecretLoveImg\\Image\\UserPicture";
            filedir=new File(headSculpturePath);
            userPicturedir=new File(UserPicturePath);

            if (!filedir.exists()){
                filedir.mkdirs();
            }
            if (!userPicturedir.exists()){
                userPicturedir.mkdirs();
            }

        } catch (IOException e) {

        }
    }

    /**
     * @author: ff
     * @date:
     * @param: []
     * @return: java.lang.String
     * 头像路径
     */

    public static String pictureDirPath(){

        String filePath= null;
        String fileDirPath=null;

        try {
            filePath = new File("").getCanonicalPath();
            System.out.println(filePath);
            filePath=filePath.substring(0,filePath.lastIndexOf("\\"));
            fileDirPath=filePath+"\\shoppingMallImg\\img\\headSculpture";

        } catch (IOException e) {

        }
        return fileDirPath;
    }


    /**
     * @author: ff
     * @date: 2020/1/10 16:35
     * @param: [pojoParm]
     * @return: java.lang.String
     * 任意类型转json
     */
    public static <T> String convertedIntoJsonString(T pojoParm){

        if (null==pojoParm){
            return null;
        }
        /*Class <?> pojoType=pojoParm.getClass();*/
        return JSON.toJSONString(pojoParm);

    }


    public static String getImgHeadsculpturefolderpath() {
        return IMG_HEADSCULPTUREFOLDERPATH;
    }
     @Value("${HeadSculpture}")
    public static void setImgHeadsculpturefolderpath(String imgHeadsculpturefolderpath) {
        IMG_HEADSCULPTUREFOLDERPATH = imgHeadsculpturefolderpath;
    }

    public static String getImgUserpicturepath() {
        return IMG_USERPICTUREPATH;
    }
    @Value("${UserPicturePath}")
    public static void setImgUserpicturepath(String imgUserpicturepath) {
        IMG_USERPICTUREPATH = imgUserpicturepath;
    }
}
