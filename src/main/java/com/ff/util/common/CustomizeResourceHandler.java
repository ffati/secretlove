package com.ff.util.common;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName CustomizeResourceHandler
 * @Description 自定义配置静态资源映射，虚拟路径，视图访问
 * @Author ff
 * @Date 2020/4/16 18:56
 * @ModifyDate 2020/4/16 18:56
 * @Version 1.0
 */

@Configuration
@Order(2)
public class CustomizeResourceHandler implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        System.out.println("WebMvcConfigurationSupport项目路径========="+StaticUtil.serverPath());
        String path="file:"+StaticUtil.serverPath()+"\\SecretLoveImg\\";
        System.out.println("静态资源路径========="+path);
        registry.addResourceHandler("/fileService/**").addResourceLocations(path);
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index.html");
    }

}
