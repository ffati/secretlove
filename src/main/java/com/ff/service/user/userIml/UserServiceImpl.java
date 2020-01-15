package com.ff.service.user.userIml;

import com.ff.entity.UserEntity;
import com.ff.service.user.UserService;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author ff
 * @Date 2020/1/15 18:25
 * @ModifyDate 2020/1/15 18:25
 * @Version 1.0
 */

@Service
public class UserServiceImpl implements UserService {

    @Override
    public UserEntity findByAnyParameter(UserEntity userEntity) {
        return null;
    }
}
