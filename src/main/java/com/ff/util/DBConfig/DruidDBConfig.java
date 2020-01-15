package com.ff.util.DBConfig;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @ClassName DruidDBConfig
 * @Description TODO
 * @Author ff
 * @Date 2020/1/5 15:26
 * @ModifyDate 2020/1/5 15:26
 * @Version 1.0
 */


@Configuration
@Primary
public class DruidDBConfig {

    @Bean(initMethod = "init",destroyMethod = "close")
    @ConfigurationProperties("spring.datasource") // 该注解可以自动注入对象的属性(对应配置文件spring.datasource下的属性)
    public DruidDataSource druidDataSource() {
        return new DruidDataSource();
    }

}
