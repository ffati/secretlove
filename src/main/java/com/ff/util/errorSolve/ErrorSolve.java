package com.ff.util.errorSolve;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;

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

    @Override
    public String getErrorPath() {
        return "/error";
    }
}

