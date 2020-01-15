package com.ff.service.user;

import com.ff.entity.UserEntity;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author ff
 * @Date 2020/1/15 18:25
 * @ModifyDate 2020/1/15 18:25
 * @Version 1.0
 */

@Service
public interface UserService {

   UserEntity findByAnyParameter(UserEntity userEntity);

}
