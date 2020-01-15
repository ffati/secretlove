package com.ff.util.aop;



import com.ff.util.common.UUIDUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;


/**
 * @author: ff
 * @date: 2020/1/15 18:23
 * @param:
 * @return:
 */
@Aspect
@Component
public class LogAspect {

    @Autowired
    private UUIDUtil uuidUtil;

    private String uuidGeneratorString;

    private Logger logger =  LogManager.getLogger(LogAspect.class);
    //@Pointcut("@annotation(com.example.studyvue.util.annotation.Logging)")
    @Pointcut("execution(public * com.ff.service..*.*(..))")
    //包及其子包下的所有方法，service.*(..)单包下所有方法
    public void webLog() {

    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        System.out.println("----------------------------------切面织入测试----------------------------------");
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        uuidGeneratorString=uuidUtil.uuidGenerator();
        MDC.put("traceId",uuidGeneratorString);

        // 记录下请求内容
        logger.info("---------------request----------------");
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        Enumeration<String> enu = request.getParameterNames();
        while (enu.hasMoreElements()) {
            String name = (String) enu.nextElement();
            logger.info("name:" + name + " - value:" + request.getParameter(name));
        }
    }
    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        MDC.put("traceId",uuidGeneratorString);
        logger.info("---------------response----------------");
        // 处理完请求，返回内容
        logger.info("RESPONSE : " + ret);
    }


}
