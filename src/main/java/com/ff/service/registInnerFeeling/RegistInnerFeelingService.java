package com.ff.service.registInnerFeeling;

import com.ff.entity.RegisterInnerFeelingEntity;
import org.springframework.stereotype.Service;

/**
 * @ClassName RegistInnerFeelingService
 * @Description TODO
 * @Author ff
 * @Date 2020/2/14 10:18
 * @ModifyDate 2020/2/14 10:18
 * @Version 1.0
 */

@Service
public interface RegistInnerFeelingService {

    void insertOneRegistFeeling(RegisterInnerFeelingEntity registerInnerFeelingEntity);

    RegisterInnerFeelingEntity searchRegisterFelling(String param);

}
