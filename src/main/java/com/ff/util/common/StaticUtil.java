package com.ff.util.common;

import com.alibaba.fastjson.JSON;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.HttpHeaders;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaType;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.*;

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

    public static String PATH_SYSTEMMENUIMAGEPATH;

    public static String PATH_SYSTEICONUIMAGEPATH;

    public static String PATH_SYSTERANDOMUIMAGEPATH;

    public static String  RESOURCELOCATIONS;

    public static String  IMG_HEADSCULPTURE;

    public static String  IMG_PERSONALHOMEPAGEBACKGROUND;

    public static String  IMG_INNERFELLINGEBACKGROUND;

    public static String IMG_DEFAULTIMGPATH;

    public static String IMG_DEFAULTLODINGIMAGE;

    static{
        SensitiveWordDetectionUtil.InitializationWork();


        String filePath= null;
        File userPicturedir=null;
        String UserPicturePath=null;
        Properties properties = new Properties();
        InputStreamReader inputStreamReader=null;

        try {

            inputStreamReader=new InputStreamReader(StaticUtil.class.getResourceAsStream("/application.properties"));
            properties.load(inputStreamReader);

            RESOURCELOCATIONS=properties.getProperty("resourceLocations");
            PATH_USERIMAGEFOLDER=properties.getProperty("userImagePath");
            PATH_VISITORINNERFELLINGIMAGE=properties.getProperty("visitorInnerfellingImagePath");
            PATH_REGISTERINNERFELLINGIMAGE=properties.getProperty("registerInnerFellingImagePath");
            PATH_SYSTEMMENUIMAGEPATH=properties.getProperty("systemMenuImagePath");
            PATH_SYSTEICONUIMAGEPATH=properties.getProperty("systemIconImagePath");
            PATH_SYSTERANDOMUIMAGEPATH=properties.getProperty("systemRandomImagePath");

            List<String >pathList=new ArrayList<String >();
            StringBuffer filePathString=new StringBuffer();

            filePath = new File("").getCanonicalPath();
            System.out.println("static初始化获取"+filePath);
            filePath=filePath.substring(0,filePath.lastIndexOf("\\"));

            pathList.add(filePathString.append(filePath).append(RESOURCELOCATIONS).append(PATH_REGISTERINNERFELLINGIMAGE).toString());
            filePathString.setLength(0);
            pathList.add(filePathString.append(filePath).append(RESOURCELOCATIONS).append(PATH_USERIMAGEFOLDER).toString());
            filePathString.setLength(0);
            pathList.add(filePathString.append(filePath).append(RESOURCELOCATIONS).append(PATH_VISITORINNERFELLINGIMAGE).toString());
            filePathString.setLength(0);
            pathList.add(filePathString.append(filePath).append(RESOURCELOCATIONS).append(PATH_SYSTEICONUIMAGEPATH).toString());
            filePathString.setLength(0);
            pathList.add(filePathString.append(filePath).append(RESOURCELOCATIONS).append(PATH_SYSTEMMENUIMAGEPATH).toString());
            filePathString.setLength(0);
            pathList.add(filePathString.append(filePath).append(RESOURCELOCATIONS).append(PATH_SYSTERANDOMUIMAGEPATH).toString());
            filePathString.setLength(0);

            for (String path:pathList
                 ) {

                UserPicturePath = path;
                userPicturedir = new File(UserPicturePath);

                if (!userPicturedir.exists()) {
                    userPicturedir.mkdirs();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {

            if (null!=inputStreamReader){

                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

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
            System.out.println("serverPath================="+filePath);
            filePath=filePath.substring(0, filePath.lastIndexOf("\\"));

        } catch (IOException e) {

        }
        return filePath;
    }


    /*
     * @author: ff
     * @date: 2020/4/17 15:34
     * @param: [sourceName]--static/img
     * @return: java.lang.String
     * 获取静态资源路径
     */
    public static String staticSourcePath(@NotNull String sourceName){

        return ClassUtils.getDefaultClassLoader().getResource(sourceName).getPath();

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


    /*
     * @author: ff
     * @date: 2020/4/14 14:29
     * @param: [jsonObjectString, keyName]
     * @return: java.lang.String
     * 根据节点名获取值
     */
    public static String getJsonObjectValueByKeyName(String jsonObjectString,String keyName){

        return JSON.parseObject(jsonObjectString).get(keyName).toString();

    }

    /*
     * @author: ff
     * @date: 2020/2/26 14:16
     * @param: [file]
     * @return: java.lang.String
     * 判断文件类型
     */

    public static String fileType(MultipartFile file){

        InputStream inputStream= null;
        try {
            inputStream = file.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        AutoDetectParser parser = new AutoDetectParser();
        parser.setParsers(new HashMap<MediaType, Parser>());

        Metadata metadata = new Metadata();

        try {
            parser.parse(inputStream, new DefaultHandler(), metadata, new ParseContext());
            inputStream.close();
        } catch (TikaException | SAXException | IOException e) {
            e.printStackTrace();
        }

        String filetype=metadata.get(HttpHeaders.CONTENT_TYPE);
        System.out.println(filetype);
        for (FileType fileType : FileType.values()) {
            if (filetype.equals(fileType.value)) {
                return fileType.toString();
            }
        }


        return "unSupport";

    }


    public  String getRESOURCELOCATIONS() {
        return RESOURCELOCATIONS;
    }

    @Value("${resourceLocations}")
    public void setRESOURCELOCATIONS(String RESOURCELOCATIONS) {
        StaticUtil.RESOURCELOCATIONS = RESOURCELOCATIONS;
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

    public String getPathSystemmenuimagepath() {
        return PATH_SYSTEMMENUIMAGEPATH;
    }

    @Value("${systemMenuImagePath}")
    public void setPathSystemmenuimagepath(String pathSystemmenuimagepath) {
        PATH_SYSTEMMENUIMAGEPATH = pathSystemmenuimagepath;
    }

    public String getPathSysteiconuimagepath() {
        return PATH_SYSTEICONUIMAGEPATH;
    }

    @Value("${systemIconImagePath}")
    public void setPathSysteiconuimagepath(String pathSysteiconuimagepath) {
        PATH_SYSTEICONUIMAGEPATH = pathSysteiconuimagepath;
    }

    public String getPathSysterandomuimagepath() {
        return PATH_SYSTERANDOMUIMAGEPATH;
    }

    @Value("${systemRandomImagePath}")
    public void setPathSysterandomuimagepath(String pathSysterandomuimagepath) {
        PATH_SYSTERANDOMUIMAGEPATH = pathSysterandomuimagepath;
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
