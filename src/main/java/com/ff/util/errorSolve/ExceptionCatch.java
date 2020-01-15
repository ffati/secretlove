package com.ff.util.errorSolve;


import com.ff.vo.Message;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName ExceptionCatch
 * @Description TODO
 * @Author ff
 * @Date 2020/1/2 20:58
 * @ModifyDate 2020/1/2 20:58
 * @Version 1.0
 */

@ControllerAdvice
public class ExceptionCatch {


/*
    @ExceptionHandler(value = AccessDeniedException.class)
    public String  AccessDeniedExceptionHandler(AccessDeniedException exception,Model model) throws Exception {
        Message message=new Message();
        message.setStatusCode("406");
        message.setInformation("您没有权限!");
        model.addAttribute("Message",message);
        return "error";
    }
*/


/**
 * @author: ff
 * @date: 2020/1/3 21:17
 * @param: [httpServletRequest, e]
 * @return: org.springframework.web.servlet.ModelAndView
 * 自定义mvc异常处理
 */
    @ExceptionHandler(Exception.class)
    public ModelAndView exception(HttpServletRequest httpServletRequest,Exception e) {
        System.out.println(e);
        ModelAndView modelAndView=new ModelAndView();
        Message message=new Message();
        message.setStatusCode("201");
        message.setInformation("发生错误！请稍后再试!");

        modelAndView.addObject("Message",message);
        modelAndView.setViewName("error");
        return modelAndView;
    }


}
