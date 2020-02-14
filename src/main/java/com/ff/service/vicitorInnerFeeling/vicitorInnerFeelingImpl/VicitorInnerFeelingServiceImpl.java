package com.ff.service.vicitorInnerFeeling.vicitorInnerFeelingImpl;

import com.ff.entity.VicitorInnerFeelingEntity;
import com.ff.repository.innerFeeling.VicitorInnerFeelingDao;
import com.ff.service.vicitorInnerFeeling.VicitorInnerFeelingService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @ClassName vicitorServiceImpl
 * @Description TODO
 * @Author ff
 * @Date 2020/2/10 18:48
 * @ModifyDate 2020/2/10 18:48
 * @Version 1.0
 */

@Service
@Transactional
public class VicitorInnerFeelingServiceImpl implements VicitorInnerFeelingService {

    @Resource
    private VicitorInnerFeelingDao vicitorInnerFeelingDao;

    @Override
    public void insertOneVicitorFeeling(VicitorInnerFeelingEntity vicitorInnerFeelingEntity) {

        vicitorInnerFeelingDao.insertvicitorfeeling(vicitorInnerFeelingEntity);

    }

    @Override
    public VicitorInnerFeelingEntity searchVicitorFelling(String receiver) {

        return vicitorInnerFeelingDao.searchVicitorFelling(receiver);

    }
}
