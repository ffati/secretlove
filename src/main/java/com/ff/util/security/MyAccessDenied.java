package com.ff.util.security;


import com.ff.util.errorSolve.ExceptionCatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName MyAccessDenied
 * @Description TODO
 * @Author ff
 * @Date 2020/1/3 20:08
 * @ModifyDate 2020/1/3 20:08
 * @Version 1.0
 * 自定义Security权限拦截
 */

@Controller
public class MyAccessDenied implements AccessDeniedHandler {

    @Autowired
    private ExceptionCatch exceptionCatch;


    @Override
    public void handle(HttpServletRequest httpServletRequest,
                       HttpServletResponse httpServletResponse,
                       AccessDeniedException e)
            throws IOException, ServletException {

/*
        PrintWriter printWriter = httpServletResponse.getWriter();
        printWriter.print("");
        printWriter.flush();
        printWriter.close();
*/
        //exceptionCatch.exception(httpServletRequest,e);

    }
}
