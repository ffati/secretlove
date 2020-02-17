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

    public static String IMG_USERIMAGEFOLDERPATH;

    public static String  IMG_HEADSCULPTURE="headImg";

    public static String  IMG_PERSONALHOMEPAGENACKGROUND="personalbgImg";

    static{

        String filePath= null;
        //File filedir=null;
        File userPicturedir=null;
        //String headSculpturePath=null;
        String UserPicturePath=null;
        try {
            filePath = new File("").getCanonicalPath();
            System.out.println(filePath);
            filePath=filePath.substring(0,filePath.lastIndexOf("\\"));
            //headSculpturePath=filePath+"\\SecretLoveImg\\UserImage";
            UserPicturePath=filePath+"/SecretLoveImg/UserImage";
            //filedir=new File(headSculpturePath);
            userPicturedir=new File(UserPicturePath);

            /*if (!filedir.exists()){
                filedir.mkdirs();
            }*/
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
     * 路径
     */

    public static String serverPath(){

        String filePath= null;

        try {
            filePath = new File("").getCanonicalPath();
            System.out.println(filePath);
            filePath=filePath.substring(0, filePath.lastIndexOf("\\"));

        } catch (IOException e) {

        }
        return filePath;
    }


/*
 * @author: ff
 * @date: 2020/2/16 15:45
 * @param: [type, userId, fileName]
 * @return: java.lang.String
 * 总路径
 */
    public static String anyPath(String userId,String type){

        StringBuffer filePath= new StringBuffer();
        System.out.println(StaticUtil.serverPath()+StaticUtil.IMG_USERIMAGEFOLDERPATH);
        filePath.append(StaticUtil.serverPath()).append(StaticUtil.IMG_USERIMAGEFOLDERPATH).append(userId).append("/").append(type);

        return filePath.toString();
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


    public String getImgUserimagefolderpath() {
        return IMG_USERIMAGEFOLDERPATH;
    }

    @Value("${UserImagePath}")
    public void setImgUserimagefolderpath(String imgUserimagefolderpath) {
        IMG_USERIMAGEFOLDERPATH = imgUserimagefolderpath;
    }
}
