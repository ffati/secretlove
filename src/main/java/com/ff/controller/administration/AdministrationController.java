package com.ff.controller.administration;

import com.ff.entity.GlobalParameterEntity;
import com.ff.entity.RegisterUserEntity;
import com.ff.entity.SystemPictureManagementEntity;
import com.ff.service.administration.AdministrationService;
import com.ff.service.user.UserService;
import com.ff.vo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName AdministrationController
 * @Description TODO
 * @Author ff
 * @Date 2020/4/17 17:44
 * @ModifyDate 2020/4/17 17:44
 * @Version 1.0
 */

@Controller
@RequestMapping("/administration")
public class AdministrationController {

    @Autowired
    private AdministrationService administrationService;

    @Autowired
    private UserService userService;

    /*
     * @author: ff
     * @date: 2020/4/17 20:37
     * @param: [httpServletRequest]
     * @return: java.lang.String
     * 返回管理全局参数管理页面
     */

    //@PreAuthorize("isAuthenticated()")
    @RequestMapping("/administrationPage")
    public String administrationPage(
            HttpServletRequest httpServletRequest
    ) {

        return "administration/administrationHomePage";

    }


    @RequestMapping("/globalParameterManagementPage")
    public String globalParameterManagementPage(
            HttpServletRequest httpServletRequest
    ) {

        return "administration/globalParameterManagementPage";

    }


    @RequestMapping("/manageConfessionWallPage")
    public String manageConfessionWallPage(
            HttpServletRequest httpServletRequest
    ) {

        return "administration/manageConfessionWallPage";

    }

    @RequestMapping("/systemPictureManagementPage")
    public String systemPictureManagementPage(
            HttpServletRequest httpServletRequest
    ) {

        return "administration/systemPictureManagementPage";

    }

    @RequestMapping("/userManagementPage")
    public String userManagementPage(
            HttpServletRequest httpServletRequest
    ) {

        return "administration/userManagementPage";

    }


    /*
     * @author: ff
     * @date: 2020/4/17 20:37
     * @param: [model, globalParameterEntity, httpServletRequest]
     * @return: com.ff.vo.Message
     * 插入全局参数
     */
    @ResponseBody
    @RequestMapping("/addOneGlobalParameter")
    public Message addOneGlobalParameter(
            Model model,
            GlobalParameterEntity globalParameterEntity,
            HttpServletRequest httpServletRequest
    ) {


        Message message = new Message();

        try {
/*            int totalNumber = administrationService.numberOfGlobalParameterColumn();
            Double ceilTotalNumber = Math.ceil(totalNumber / 15.0);*/

            administrationService.addOneGlobalParameter(/*ceilTotalNumber.intValue(),*/ globalParameterEntity);

        } catch (Exception e) {
            e.printStackTrace();
            message.setStatusCode("500");
            message.setInformation("保存失败！");
            return message;
        }
        message.setStatusCode("200");
        message.setInformation("保存成功！");
        return message;

    }


    /*
     * @author: ff
     * @date: 2020/4/19 13:36
     * @param: [globalParameterEntity]
     * @return: com.ff.vo.Message
     * 更新参数
     */
    @ResponseBody
    @RequestMapping("/updateGlobalParameter")
    public Message  updateGlobalParameter(
            GlobalParameterEntity globalParameterEntity
    ) {

        Message message=new Message();

        try {
            administrationService.updateParameterByParamterName(globalParameterEntity);
        } catch (Exception e) {
            e.printStackTrace();

            message.setStatusCode("500");
            message.setInformation("更新失败！");
            return message;
        }
        message.setStatusCode("200");
        message.setInformation("更新成功！");
        return message;
    }



    /*
     * @author: ff
     * @date: 2020/4/17 20:36
     * @param: [httpServletRequest, size, page]
     * @return: java.util.List<com.ff.entity.GlobalParameterEntity>
     * 全局参数分页查询
     */
    @ResponseBody
    @RequestMapping("/findGlobalParameterForPage")
    public Map<String ,Object> findGlobalParameterForPage(
            HttpServletRequest httpServletRequest,
            @RequestParam(value = "size", defaultValue = "15") int size,
            @RequestParam(value = "page", defaultValue = "1") int page
    ) {

        Map<String ,Object> resultMap=new HashMap<String ,Object>();
        Double ceilTotalNumber=Math.ceil(administrationService.numberOfGlobalParameterColumn() / 15.0);
        if (page>ceilTotalNumber.intValue())
            page=ceilTotalNumber.intValue();

        List<GlobalParameterEntity> globalParameterEntityList = administrationService.findGlobalParameterForPage(page, size, (page - 1) * size);


        resultMap.put("code","200");
        resultMap.put("msg","成功！");
        resultMap.put("count",administrationService.numberOfGlobalParameterColumn());
        resultMap.put("data",globalParameterEntityList);

        return resultMap;
    }


    /*
     * @author: ff
     * @date: 2020/4/17 20:44
     * @param: []
     * @return: int
     * 全局参数总页数
     */
    @ResponseBody
    @RequestMapping("/GlobalParameterTotalPage")
    public int  totalPage() {

        Double ceilTotalNumber=Math.ceil(administrationService.numberOfGlobalParameterColumn() / 15.0);

        return ceilTotalNumber.intValue();
    }


    /*========SystemPictureManagement系统图片管理========*/


    /*
     * @author: ff
     * @date: 2020/4/17 22:04
     * @param: [systemPictureManagementEntity, httpServletRequest]
     * @return: com.ff.vo.Message
     *
     */
    @ResponseBody
    @RequestMapping("/addSystemPictureManagement")
    public Message addSystemPictureManagement(
            SystemPictureManagementEntity systemPictureManagementEntity,
            HttpServletRequest httpServletRequest
    ) {


        Message message = new Message();

        try {
/*
            int totalNumber = administrationService.numberOfGlobalParameterColumn();
            Double ceilTotalNumber = Math.ceil(totalNumber / 15.0);
*/

            administrationService.addSystemPictureManagement(/*ceilTotalNumber.intValue(),*/ systemPictureManagementEntity);

        } catch (Exception e) {
            e.printStackTrace();
            message.setStatusCode("500");
            message.setInformation("保存失败！");
            return message;
        }
        message.setStatusCode("200");
        message.setInformation("保存成功！");
        return message;

    }


    /*
     * @author: ff
     * @date: 2020/4/19 13:37
     * @param: [systemPictureManagementEntity]
     * @return: com.ff.vo.Message
     * 更新图片管理
     */
    @ResponseBody
    @RequestMapping("/updateSystemPictureManagement")
    public Message  updateSystemPictureManagement(
            SystemPictureManagementEntity systemPictureManagementEntity
    ) {

        Message message=new Message();

        try {
            administrationService.updateSystemPictureManagement(systemPictureManagementEntity);
        } catch (Exception e) {
            e.printStackTrace();

            message.setStatusCode("500");
            message.setInformation("更新失败！");
            return message;
        }
        message.setStatusCode("200");
        message.setInformation("更新成功！");
        return message;
    }



    /*
     * @author: ff
     * @date: 2020/4/17 22:04
     * @param: [httpServletRequest, size, page]
     * @return: java.util.List<com.ff.entity.SystemPictureManagementEntity>
     * 分页查询系统图片参数
     */
    @ResponseBody
    @RequestMapping("/findSystemPictureManagementForPage")
    public Map<String ,Object> findSystemPictureManagementForPage(
            HttpServletRequest httpServletRequest,
            @RequestParam(value = "size", defaultValue = "15") int size,
            @RequestParam(value = "page", defaultValue = "1") int page
    ) {

        Map<String ,Object> resultMap=new HashMap<String ,Object>();
        Double ceilTotalNumber=Math.ceil(administrationService.numberOfGlobalParameterColumn() / 15.0);
        if (page>ceilTotalNumber.intValue())
            page=ceilTotalNumber.intValue();

        List<SystemPictureManagementEntity> systemPictureManagementEntityList = administrationService.findSystemPictureManagementForPage(page, size, (page - 1) * size);


        resultMap.put("code","200");
        resultMap.put("msg","成功！");
        resultMap.put("count",administrationService.numberOfSystemPictureManagementColumn());
        resultMap.put("data",systemPictureManagementEntityList);
        return resultMap;
    }


    /*
     * @author: ff
     * @date: 2020/4/17 22:04
     * @param: []
     * @return: int
     * 系统图片参数总页数
     */
    @ResponseBody
    @RequestMapping("/numberOfSystemPictureManagementColumn")
    public int  numberOfSystemPictureManagementColumn() {

        Double ceilTotalNumber=Math.ceil(administrationService.numberOfSystemPictureManagementColumn() / 15.0);

        return ceilTotalNumber.intValue();
    }


                            /*========用户管理========*/




    /*
     * @author: ff
     * @date: 2020/4/19 13:40
     * @param: [httpServletRequest, size, page]
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     * 分页查询用户
     */
    @ResponseBody
    @RequestMapping("/findUserByPage")
    public Map<String ,Object> findUserByPage(
            HttpServletRequest httpServletRequest,
            @RequestParam(value = "size", defaultValue = "15") int size,
            @RequestParam(value = "page", defaultValue = "1") int page
    ) {

        Map<String ,Object> resultMap=new HashMap<String ,Object>();

        Double ceilTotalNumber=Math.ceil(userService.countUserNumber() / 15.0);
        if (page>ceilTotalNumber.intValue())
            page=ceilTotalNumber.intValue();

        List<RegisterUserEntity> registerUserEntityList = userService.findUserByPage( size, (page - 1) * size);


        resultMap.put("code","200");
        resultMap.put("msg","成功！");
        resultMap.put("count",userService.countUserNumber());
        resultMap.put("data",registerUserEntityList);
        return resultMap;
    }


    /*
     * @author: ff
     * @date: 2020/4/19 13:44
     * @param: [registerUserEntity]
     * @return: com.ff.vo.Message
     * 更新用户
     */
    @ResponseBody
    @RequestMapping("/updateUser")
    public Message  updateUser(
            RegisterUserEntity registerUserEntity
    ) {

        Message message = new Message();

        Boolean flage = userService.updateRegisterUser(registerUserEntity);

        if (!flage) {

            message.setStatusCode("500");
            message.setInformation("更新失败！");
            return message;
        }

        message.setStatusCode("200");
        message.setInformation("更新成功！");
        return message;
    }

}
