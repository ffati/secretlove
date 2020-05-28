package com.ff.service.registInnerFeeling;

import com.ff.entity.RegisterInnerFeelingEntity;
import org.springframework.stereotype.Service;

import java.util.List;

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

    Boolean insertOneRegistFeeling(RegisterInnerFeelingEntity registerInnerFeelingEntity);

    List<RegisterInnerFeelingEntity> searchRegisterFelling(String param);

    List<RegisterInnerFeelingEntity> findPageByAnyParam(int size,int index,RegisterInnerFeelingEntity registerInnerFeelingEntity);

    String findMaxPageOrder(String id);

    int countNumberByUserId(String id);
}
