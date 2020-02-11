package com.ff.util.security;


import com.ff.entity.RegisterUserEntity;
import com.ff.entity.RoleEntity;
import com.ff.entity.UserEntity;
import com.ff.service.role.RoleService;
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

    @Autowired
    private RoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        RegisterUserEntity userEntity=new RegisterUserEntity();
        userEntity.setUserName(userName);
        RegisterUserEntity backUserEntity=new RegisterUserEntity();
        backUserEntity=userService.findByAnyParameter(userEntity);
        List<GrantedAuthority> roalList=new ArrayList<>();

        List<RoleEntity> allRoal=roleService.findAllRole();
        for (int i=0;i<allRoal.size();i++){
            roalList.add(new SimpleGrantedAuthority(allRoal.get(i).getRoleCode()));
        }

        return new User(backUserEntity.getUserName(),backUserEntity.getUserPassword(),roalList);
    }
}
