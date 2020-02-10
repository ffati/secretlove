package com.ff.service.vicitor.vicitorImpl;

import com.ff.entity.VicitorInnerFeelingEntity;
import com.ff.repository.innerFeeling.InnerFeelingDao;
import com.ff.service.vicitor.vicitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class vicitorServiceImpl implements vicitorService {

    @Resource
    private InnerFeelingDao innerFeelingDao;

    @Override
    public void insertOneVicitorFeeling(VicitorInnerFeelingEntity vicitorInnerFeelingEntity) {



    }
}
