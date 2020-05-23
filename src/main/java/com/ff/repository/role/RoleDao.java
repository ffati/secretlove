package com.ff.repository.role;

import com.ff.entity.RoleEntity;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName RoleDao
 * @Description TODO
 * @Author ff
 * @Date 2020/2/11 16:11
 * @ModifyDate 2020/2/11 16:11
 * @Version 1.0
 */


public interface RoleDao {

    @Select(value = "select * from t_user_role")
    List<RoleEntity> findAllRole();

}
