package com.ff.service.role;

import com.ff.entity.RoleEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName RoleService
 * @Description TODO
 * @Author ff
 * @Date 2020/2/11 16:08
 * @ModifyDate 2020/2/11 16:08
 * @Version 1.0
 */

@Service
public interface RoleService {

    List<RoleEntity> findAllRole();

}
