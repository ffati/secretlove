package com.ff.util.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName ConfigeBeen
 * @Description TODO
 * @Author ff
 * @Date 2020/4/14 13:06
 * @ModifyDate 2020/4/14 13:06
 * @Version 1.0
 */


@Configuration
public class ConfigeBeen {

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
