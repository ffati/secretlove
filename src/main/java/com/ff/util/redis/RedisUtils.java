package com.ff.util.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @ClassName RedisUtils
 * @Description TODO
 * @Author ff
 * @Date 2020/1/10 13:25
 * @ModifyDate 2020/1/10 13:25
 * @Version 1.0
 */



@Component
public class RedisUtils {


    @Autowired
    private RedisTemplate<String, Object> redisTemplate;



    public Object get(final String key) {
        return redisTemplate.opsForValue().get(key);
    }




    public boolean set(final String key, String value) {
        boolean result = false;
        try {
            redisTemplate.opsForValue().set(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


}

