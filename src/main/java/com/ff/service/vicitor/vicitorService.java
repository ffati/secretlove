package com.ff.service.vicitor;

import com.ff.entity.RegisterUserEntity;
import com.ff.entity.VicitorInnerFeelingEntity;
import org.springframework.stereotype.Service;

/**
 * @ClassName vicitorService
 * @Description TODO
 * @Author ff
 * @Date 2020/2/10 18:46
 * @ModifyDate 2020/2/10 18:46
 * @Version 1.0
 */
@Service
public interface vicitorService {

    void insertOneVicitorFeeling(VicitorInnerFeelingEntity vicitorInnerFeelingEntity);

}
