package com.ff.util.common;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * @ClassName sensitiveWordDetectionUtil
 * @Description TODO
 * @Author ff
 * @Date 2020/2/20 9:45
 * @ModifyDate 2020/2/20 9:45
 * @Version 1.0
 */

@Component
public class SensitiveWordDetectionUtil {

    private static StringBuilder replaceAll;//初始化
    private static String encoding = "UTF-8";
    private static String replceStr = "*";
    private static int replceSize = 500;
    private static String fileName = "CensorWords.txt";
    private static List<String> arrayList;
    public static Set<String> sensitiveWordSet;//包含的敏感词列表，过滤掉重复项
    public static List<String> sensitiveWordList;//包含的敏感词列表，包括重复项，统计次数

    /**
     * 文件要求路径在src或resource下，默认文件名为CensorWords.txt
     * @param fileName 词库文件名(含后缀)
     */
    public SensitiveWordDetectionUtil(String fileName) {
        this.fileName = fileName;
    }

    /**
     * @param replceStr 敏感词被转换的字符
     * @param replceSize 初始转义容量
     */
    public SensitiveWordDetectionUtil(String replceStr, int replceSize) {
        this.replceStr = fileName;
        this.replceSize = replceSize;
    }

    public SensitiveWordDetectionUtil() {
    }


    /*
     * @author: ff
     * @date: 2020/2/20 10:44
     * @param: [str]需要判断的字符串
     * @return: java.lang.Boolean
     * 检测是否包含敏感词
     */
    public static Boolean containDetection(String str){

        Boolean flage=false;
        for(int i=0;i<arrayList.size();i++){
            flage=str.contains(arrayList.get(i));
            if (flage){
                return flage;
            }
        }
        return flage;
    }


    /**
     * @param str 将要被过滤信息
     * @return 过滤后的信息
     */
    public static String filterInfo(String str) {

        sensitiveWordSet = new HashSet<String>();
        sensitiveWordList= new ArrayList<>();
        StringBuilder buffer = new StringBuilder(str);
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>(arrayList.size());
        String temp;
        for(int x = 0; x < arrayList.size();x++)
        {
            temp = arrayList.get(x);
            int findIndexSize = 0;
            for(int start = -1;(start=buffer.indexOf(temp,findIndexSize)) > -1;)
            {
                //System.out.println("###replace="+temp);
                findIndexSize = start+temp.length();//从已找到的后面开始找
                Integer mapStart = hash.get(start);//起始位置
                if(mapStart == null || (mapStart != null && findIndexSize > mapStart))//满足1个，即可更新map
                {
                    hash.put(start, findIndexSize);
                    //System.out.println("###敏感词："+buffer.substring(start, findIndexSize));
                }
            }
        }
        Collection<Integer> values = hash.keySet();
        for(Integer startIndex : values)
        {
            Integer endIndex = hash.get(startIndex);
            //获取敏感词，并加入列表，用来统计数量
            String sensitive = buffer.substring(startIndex, endIndex);
            //System.out.println("###敏感词："+sensitive);
            if (!sensitive.contains("*")) {//添加敏感词到集合
                sensitiveWordSet.add(sensitive);
                sensitiveWordList.add(sensitive);
            }
            buffer.replace(startIndex, endIndex, replaceAll.substring(0,endIndex-startIndex));
        }
        hash.clear();
        return buffer.toString();
    }
    /**
     *   初始化敏感词库
     */
    public static void InitializationWork() {
        replaceAll = new StringBuilder(replceSize);
        for(int x=0;x < replceSize;x++) {
            replaceAll.append(replceStr);
        }
        //加载词库
        arrayList = new ArrayList<String>();
        InputStreamReader read = null;
        BufferedReader bufferedReader = null;
        try {
            read = new InputStreamReader(SensitiveWordDetectionUtil.class.getClassLoader().getResourceAsStream(fileName),encoding);
            bufferedReader = new BufferedReader(read);
            for(String txt = null;(txt = bufferedReader.readLine()) != null;){
                if(!arrayList.contains(txt))
                    arrayList.add(txt);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                if(null != bufferedReader)
                    bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(null != read)
                    read.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public StringBuilder getReplaceAll() {
        return replaceAll;
    }
    public void setReplaceAll(StringBuilder replaceAll) {
        this.replaceAll = replaceAll;
    }
    public String getReplceStr() {
        return replceStr;
    }
    public void setReplceStr(String replceStr) {
        this.replceStr = replceStr;
    }
    public int getReplceSize() {
        return replceSize;
    }
    public void setReplceSize(int replceSize) {
        this.replceSize = replceSize;
    }
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public List<String> getArrayList() {
        return arrayList;
    }
    public void setArrayList(List<String> arrayList) {
        this.arrayList = arrayList;
    }
    public String getEncoding() {
        return encoding;
    }
    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }


}
