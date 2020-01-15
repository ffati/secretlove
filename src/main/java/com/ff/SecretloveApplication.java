package com.ff;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@ServletComponentScan
@EnableCaching
@MapperScan("com.ff.repository")
public class SecretloveApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecretloveApplication.class, args);
    }

}
