package com.ff.util.fileUtil;

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
public class FileStream {


    /**
     * @author: ff
     * @date: 2020/1/8 17:50
     * @param: [httpServletResponse, file]
     * @return: void
     * 读取文件
     */
    public static void readFile(HttpServletResponse httpServletResponse, File file) {


        //httpServletResponse.setContentType("audio/mpeg");
        //httpServletResponse.addHeader("Accept-Ranges", "bytes");
        httpServletResponse.addHeader("Cache-Control", "max-age=3600");

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

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            try {

                if (null!=bufferedInputStream)
                    bufferedInputStream.close();
                if (null!=inputStream)
                    inputStream.close();
                if (null!=bufferedOutputStream)
                    bufferedOutputStream.close();
                if (null!=inputStream)
                    inputStream.close();

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
    public static Boolean wrightFile(String picturePath, String imgName, MultipartFile file) {


        try {

            File firdir = new File(picturePath);
            if (!firdir.exists()) {
                firdir.mkdirs();
            }

            File imgFile = new File(picturePath + "/" + imgName);
            if (imgFile.exists()) {
                imgFile.delete();
            }

            file.transferTo(imgFile);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    /*
     * @author: ff
     * @date: 2020/4/17 15:16
     * @param: [sourceFile, targetPath]
     * @return: void
     * 复制单个文件到目标文件夹下
     */
    public static void copyFile(File sourceFile, String targetPath) {

        InputStream inputStream = null;
        BufferedInputStream bufferedInputStream = null;
        OutputStream outputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        StringBuffer targeFileName = new StringBuffer(targetPath);
        File targetFile=new File(targeFileName.append(sourceFile.getName()).toString());

        if (targetFile.exists())
            return;

        try {
            inputStream = new FileInputStream(sourceFile);
            bufferedInputStream = new BufferedInputStream(inputStream);
            outputStream = new FileOutputStream(targetFile);
            bufferedOutputStream = new BufferedOutputStream(outputStream);

            int index = -1;
            while ((index = bufferedInputStream.read()) != -1) {
                bufferedOutputStream.write(index);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null!=bufferedOutputStream)
                    bufferedOutputStream.close();
                if (null!=inputStream)
                    inputStream.close();
                if (null!=bufferedInputStream)
                    bufferedInputStream.close();
                if (null!=inputStream)
                    inputStream.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*
     * @author: ff
     * @date: 2020/4/17 15:23
     * @param: [sourcePath, targetPath]
     * @return: void
     * 复制文件夹下所有文件到目标文件夹
     */
    public static void copyFiles(String sourcePath, String targetPath) {

        InputStream inputStream = null;
        BufferedInputStream bufferedInputStream = null;
        OutputStream outputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        try {

            File sourceFile = new File(sourcePath);
            File targeFile = new File(targetPath);


            if (sourceFile.isFile()) {

                FileStream.copyFile(sourceFile, targetPath);

            } else if (sourceFile.isDirectory()) {

                File[] sourceFiles = sourceFile.listFiles();

                if (sourceFiles.length != 0) {

                    for (File originFile : sourceFiles
                    ) {

                        FileStream.copyFile(originFile, targetPath);
                    }

                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {

                if (null!=bufferedInputStream)
                bufferedInputStream.close();
                if (null!=inputStream)
                inputStream.close();
                if (null!=bufferedOutputStream)
                bufferedOutputStream.close();
                if (null!=inputStream)
                inputStream.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}
