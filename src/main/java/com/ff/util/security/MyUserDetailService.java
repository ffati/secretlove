package com.ff.util.security;


import com.ff.entity.UserEntity;
import com.ff.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MyUserDetailService
 * @Description TODO
 * @Author ff
 * @Date 2019/12/26 18:47
 * @ModifyDate 2019/12/26 18:47
 * @Version 1.0
 */

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserService userService;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        UserEntity userEntity=new UserEntity();
        userEntity.setUsername(userName);
        UserEntity backUserEntity=new UserEntity();
        backUserEntity=userService.findByAnyParameter(userEntity);
        List<GrantedAuthority> roalList=new ArrayList<>();
        roalList.add(new SimpleGrantedAuthority(backUserEntity.getUsercategory()));

        return new User(backUserEntity.getUsername(),backUserEntity.getUserpassword(),roalList);
    }
}
