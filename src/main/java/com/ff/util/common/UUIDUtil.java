package com.ff.util.common;

import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @ClassName UUIDUtil
 * @Description UUID生成
 * @Author ff
 * @Date 2020/1/6 16:51
 * @ModifyDate 2020/1/6 16:51
 * @Version 1.0
 */

@Component
public class UUIDUtil {

    public String uuidGenerator(){

        UUID uuid=UUID.randomUUID();
        return uuid.toString();
    }

}
