package com.ff.service.registInnerFeeling.registInnerFeelingimpl;

import com.ff.entity.RegisterInnerFeelingEntity;
import com.ff.repository.innerFeeling.RegistInnerFeelingDao;
import com.ff.service.registInnerFeeling.RegistInnerFeelingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @ClassName RegistInnerFeelingServiceImpl
 * @Description TODO
 * @Author ff
 * @Date 2020/2/14 10:19
 * @ModifyDate 2020/2/14 10:19
 * @Version 1.0
 */

@Service
@Transactional
public class RegistInnerFeelingServiceImpl implements RegistInnerFeelingService {

    @Resource
    private RegistInnerFeelingDao registInnerFeelingDao;


    @Override
    public void insertOneRegistFeeling(RegisterInnerFeelingEntity registerInnerFeelingEntity) {
        registInnerFeelingDao.insertRegisterfeeling(registerInnerFeelingEntity);
    }

    @Override
    public RegisterInnerFeelingEntity searchRegisterFelling(String param) {
        return registInnerFeelingDao.searchRegisterFelling(param);
    }
}
