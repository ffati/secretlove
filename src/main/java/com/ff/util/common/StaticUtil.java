package com.ff.util.common;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    public static String PATH_USERIMAGEFOLDER;

    public static String PATH_VISITORINNERFELLINGIMAGE;

    public static String PATH_REGISTERINNERFELLINGIMAGE;

    public static String  IMG_HEADSCULPTURE;

    public static String  IMG_PERSONALHOMEPAGEBACKGROUND;

    public static String  IMG_INNERFELLINGEBACKGROUND;

    public static String IMG_DEFAULTIMGPATH;

    public static String IMG_DEFAULTLODINGIMAGE;

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
 * 用户私人图片路径
 */
    public static String anyPath(String userId,String type){

        StringBuffer filePath= new StringBuffer();
        System.out.println(StaticUtil.serverPath()+StaticUtil.PATH_USERIMAGEFOLDER);
        filePath.append(StaticUtil.serverPath()).append(StaticUtil.PATH_USERIMAGEFOLDER).append(userId).append("/").append(type);

        return filePath.toString();
    }

/*
 * @author: ff
 * @date: 2020/2/18 13:18
 * @param: [userId, type]
 * @return: java.lang.String
 * 无需权限的路径
 */
    public static String vicitorPictureUtil(String userId,int type){

        StringBuffer filePath= new StringBuffer();

        if (type==1){
            filePath.append(StaticUtil.serverPath()).append(StaticUtil.PATH_REGISTERINNERFELLINGIMAGE).append(userId).append("/");
        }else {
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("YYYYMM");
            filePath.append(StaticUtil.serverPath()).append(StaticUtil.PATH_VISITORINNERFELLINGIMAGE).append(simpleDateFormat.format(new Date())).append("/");
        }

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


    public String getPathUserimagefolder() {
        return PATH_USERIMAGEFOLDER;
    }

    @Value("${userImagePath}")
    public void setPathUserimagefolder(String pathUserimagefolder) {
        PATH_USERIMAGEFOLDER = pathUserimagefolder;
    }

    public String getPathVisitorinnerfellingimage() {
        return PATH_VISITORINNERFELLINGIMAGE;
    }

    @Value("${visitorInnerfellingImagePath}")
    public void setPathVisitorinnerfellingimage(String pathVisitorinnerfellingimage) {
        PATH_VISITORINNERFELLINGIMAGE = pathVisitorinnerfellingimage;
    }


    public String getPathRegisterinnerfellingimage() {
        return PATH_REGISTERINNERFELLINGIMAGE;
    }

    @Value("${registerInnerFellingImagePath}")
    public void setPathRegisterinnerfellingimage(String pathRegisterinnerfellingimage) {
        PATH_REGISTERINNERFELLINGIMAGE = pathRegisterinnerfellingimage;
    }

    public String getImgHeadsculpture() {
        return IMG_HEADSCULPTURE;
    }

    @Value("${headImg}")
    public void setImgHeadsculpture(String imgHeadsculpture) {
        IMG_HEADSCULPTURE = imgHeadsculpture;
    }

    public String getImgPersonalhomepagebackground() {
        return IMG_PERSONALHOMEPAGEBACKGROUND;
    }

    @Value("${personalbgImg}")
    public void setImgPersonalhomepagebackground(String imgPersonalhomepagebackground) {
        IMG_PERSONALHOMEPAGEBACKGROUND = imgPersonalhomepagebackground;
    }

    public String getImgInnerfellingebackground() {
        return IMG_INNERFELLINGEBACKGROUND;
    }

    @Value("${innerFellingbgImg}")
    public void setImgInnerfellingebackground(String imgInnerfellingebackground) {
        IMG_INNERFELLINGEBACKGROUND = imgInnerfellingebackground;
    }

    public  String getImgDefaultimgpath() {
        return IMG_DEFAULTIMGPATH;
    }

    @Value("${defaultHeadSculpture}")
    public  void setImgDefaultimgpath(String imgDefaultimgpath) {
        IMG_DEFAULTIMGPATH = imgDefaultimgpath;
    }

    public String getImgDefaultlodingimage() {
        return IMG_DEFAULTLODINGIMAGE;
    }
    @Value("${defaultlodingImage}")
    public void setImgDefaultlodingimage(String imgDefaultlodingimage) {
        IMG_DEFAULTLODINGIMAGE = imgDefaultlodingimage;
    }

}
