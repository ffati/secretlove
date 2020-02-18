package com.ff;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@ServletComponentScan
@EnableCaching
@MapperScan("com.ff.repository")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecretloveApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecretloveApplication.class, args);
    }

}
