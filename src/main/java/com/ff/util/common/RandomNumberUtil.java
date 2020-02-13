package com.ff.util.common;

import com.ff.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @ClassName UUIDUtil
 * @Description ID生成
 * @Author ff
 * @Date 2020/1/6 16:51
 * @ModifyDate 2020/1/6 16:51
 * @Version 1.0
 */

@Component
public class RandomNumberUtil {

    @Autowired
    private UserService userService;


    public String uuidGenerator(){

        UUID uuid=UUID.randomUUID();
        return uuid.toString();
    }

    /*
     * @author: ff
     * @date: 2020/2/12 17:02
     * @param: [sex]
     * @return: java.lang.String
     * id标识符
     * 格式：yyyyMMdd 0/1 001
     */
    public String userIdentifier(String sex){

        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMdd");
        StringBuffer identityIdString=new StringBuffer(simpleDateFormat.format(new Date()));
        identityIdString=identityIdString.append(sex);
        Integer maxIDInteger=userService.findMaxID();
        if (null==maxIDInteger){
            maxIDInteger=1;
        }
        String maxID=Integer.valueOf(maxIDInteger+1).toString();

        if(maxID.length()==1){
            identityIdString.append("00").append(maxID);
        }else if (maxID.length()==2){
            identityIdString.append("0").append(maxID);
        }else {
            identityIdString.append(maxID);
        }

        return identityIdString.toString();
    }


}
