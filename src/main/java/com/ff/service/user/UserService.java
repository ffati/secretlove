package com.ff.service.user;

import com.ff.entity.RegisterUserEntity;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

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

   @Cacheable(cacheNames = "RegisterUser",key = "#registerUserEntity.userName")
   RegisterUserEntity findByAnyParameter(RegisterUserEntity registerUserEntity);

   Boolean insertRegisterUser(RegisterUserEntity registerUserEntity);

   @CacheEvict(cacheNames = "RegisterUser",key = "#registerUserEntity.userName")
   Boolean updateRegisterUser(RegisterUserEntity registerUserEntity);

   Integer findMaxID();

   RegisterUserEntity findRegisterUserByUsername(String username);

   Boolean checkPhoneNumber(String phoneNumber);

   void addInfraction(String id);

   List<RegisterUserEntity> findUserByPage(int size,int index);

   int countUserNumber();
}
