package com.ff.service.role.roleImpl;

import com.ff.entity.RoleEntity;
import com.ff.repository.role.RoleDao;
import com.ff.service.role.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName RoleServiceImpl
 * @Description TODO
 * @Author ff
 * @Date 2020/2/11 16:09
 * @ModifyDate 2020/2/11 16:09
 * @Version 1.0
 */

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleDao roleDao;

    @Override
    public List<RoleEntity> findAllRole() {
        return roleDao.findAllRole();
    }
}
