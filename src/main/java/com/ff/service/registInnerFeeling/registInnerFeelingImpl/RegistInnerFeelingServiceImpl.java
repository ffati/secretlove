package com.ff.service.registInnerFeeling.registInnerFeelingImpl;

import com.ff.entity.RegisterInnerFeelingEntity;
import com.ff.repository.innerFeeling.RegistInnerFeelingDao;
import com.ff.service.registInnerFeeling.RegistInnerFeelingService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.List;

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
    public Boolean insertOneRegistFeeling(RegisterInnerFeelingEntity registerInnerFeelingEntity) {

        Boolean flage=true;
        try {
            registInnerFeelingDao.insertRegisterfeeling(registerInnerFeelingEntity);
        }catch (Exception e){
            flage=false;
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }finally {
            return flage;
        }

    }

    @Override
    public List<RegisterInnerFeelingEntity> searchRegisterFelling(String param) {
        return registInnerFeelingDao.searchRegisterFelling(param);
    }

    @Override
    public List<RegisterInnerFeelingEntity> findPageByAnyParam(int size,int index,RegisterInnerFeelingEntity registerInnerFeelingEntity) {
        return registInnerFeelingDao.findPageByAnyParam(size, index,registerInnerFeelingEntity);
    }


    @Override
    public String findMaxPageOrder(String id) {
        return registInnerFeelingDao.findMaxPageOrder(id);
    }

    @Override
    public int countNumberByUserId(String  userId) {
        return registInnerFeelingDao.countNumberByUserId(userId);
    }
}
