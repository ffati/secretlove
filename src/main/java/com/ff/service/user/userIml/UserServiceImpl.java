package com.ff.service.user.userIml;

import com.ff.entity.RegisterUserEntity;
import com.ff.repository.user.UserDao;
import com.ff.service.user.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author ff
 * @Date 2020/1/15 18:25
 * @ModifyDate 2020/1/15 18:25
 * @Version 1.0
 */

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    @Transactional(readOnly = true)
    public RegisterUserEntity findByAnyParameter(RegisterUserEntity registerUserEntity) {
        return userDao.findByAnyParam(registerUserEntity);
    }

    @Override
    public Boolean insertRegisterUser(RegisterUserEntity registerUserEntity) {

        Boolean flage=null;
        try {
            userDao.insertRegisterUser(registerUserEntity);
            flage=true;
        }catch (Exception e){
            e.printStackTrace();
            flage=false;
        }
        return flage;
    }


    @Override
    public Integer findMaxID() {
        return userDao.findMaxID();
    }
}
