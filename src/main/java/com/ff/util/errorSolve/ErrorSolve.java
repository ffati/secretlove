package com.ff.util.errorSolve;

import com.ff.util.common.CurrentUser;
import com.ff.vo.CurrentUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName ErrorSolve
 * @Description TODO
 * @Author ff
 * @Date 2020/1/1 20:45
 * @ModifyDate 2020/1/1 20:45
 * @Version 1.0
 * 全局异常处理
 */


@Controller
public class ErrorSolve implements ErrorController {

    @Autowired
    private CurrentUser currentUserUtil;


    @RequestMapping(value="/error")
    public String handleError(
            HttpServletRequest request,
            Model model
    ){

        if (currentUserUtil.currentUserIsAuthenticated()){
        CurrentUserVo currentUserVo=currentUserUtil.currentUser(request.getSession());
        model.addAttribute("headSculpture",currentUserVo.getHeadPictureaddress());
    }

    Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if(statusCode == 404||statusCode==500){
        model.addAttribute("statusCode",statusCode);
        return "/error/unexpected";
    }else{
        return "/error/error";
    }
}


    @Override
    public String getErrorPath() {
        return "/error/error";
    }
}

