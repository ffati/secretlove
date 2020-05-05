package com.ff.controller.administration;

import com.ff.util.common.StaticUtil;
import com.ff.util.fileUtil.FileStream;
import com.ff.vo.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName SystemInitializationController
 * @Description TODO
 * @Author ff
 * @Date 2020/4/17 15:26
 * @ModifyDate 2020/4/17 15:26
 * @Version 1.0
 */

@Controller
@RequestMapping("/SystemInitialization")
public class SystemInitializationController {

    @Value("${systemIconStaticSourcePath}")
    private String systemIconStaticSourcePath;

    @Value("${systemMenuStaticSourcePath}")
    private String systemMenuStaticSourcePath;

    @Value("${systemRandomImageStaticSourcePath}")
    private String systemRandomImageStaticSourcePath;


    /*
     * @author: ff
     * @date: 2020/4/17 17:43
     * @param: []
     * @return: com.ff.vo.Message
     * 项目初始化操作
     */
    @ResponseBody
    @RequestMapping("/initialize")
    public Message initialize() {

        Message message = new Message();
        StringBuffer staticPath = new StringBuffer();
        StringBuffer filePath=new StringBuffer();
        StringBuffer copyFilesToTarget=new StringBuffer();
        List<String >pathList=new ArrayList<String >();
        Map<String ,String >pathMap=new HashMap<>();

        pathList.add(systemIconStaticSourcePath);
        pathList.add(systemMenuStaticSourcePath);
        pathList.add(systemRandomImageStaticSourcePath);

        pathMap.put(systemIconStaticSourcePath,StaticUtil.PATH_SYSTEICONUIMAGEPATH);
        pathMap.put(systemMenuStaticSourcePath,StaticUtil.PATH_SYSTEMMENUIMAGEPATH);
        pathMap.put(systemRandomImageStaticSourcePath,StaticUtil.PATH_SYSTERANDOMUIMAGEPATH);


        try {
            for (String pathString:pathList
                 ) {

                filePath=filePath.append(StaticUtil.staticSourcePath(staticPath.append(pathString).toString()));
                System.out.println("filePath======="+filePath);
                FileStream.copyFiles(filePath.toString(),copyFilesToTarget.append(StaticUtil.serverPath()).append(StaticUtil.RESOURCELOCATIONS).append(pathMap.get(pathString)).toString());

                staticPath.setLength(0);
                filePath.setLength(0);
                copyFilesToTarget.setLength(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            message.setInformation("初始化失败！");
            message.setStatusCode("500");
            return message;
        }

        message.setInformation("初始化成功！");
        message.setStatusCode("200");
        return message;
    }

}
