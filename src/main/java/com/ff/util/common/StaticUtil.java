package com.ff.util.common;

import com.alibaba.fastjson.JSON;
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

    static{

        String filePath= null;
        File filedir=null;
        String fileDirPath=null;

        try {
            filePath = new File("").getCanonicalPath();
            System.out.println(filePath);
            filePath=filePath.substring(0,filePath.lastIndexOf("\\"));
            fileDirPath=filePath+"\\shoppingMallImg\\img\\headSculpture";
            filedir=new File(fileDirPath);

            if (!filedir.exists()){
                filedir.mkdirs();
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


}
