package com.ff.service.vicitorInnerFeeling;

import com.ff.entity.VicitorInnerFeelingEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName vicitorService
 * @Description TODO
 * @Author ff
 * @Date 2020/2/10 18:46
 * @ModifyDate 2020/2/10 18:46
 * @Version 1.0
 */
@Service
public interface VicitorInnerFeelingService {

    Boolean insertOneVicitorFeeling(VicitorInnerFeelingEntity vicitorInnerFeelingEntity);

    List<VicitorInnerFeelingEntity> searchVicitorFelling(String receiver);
}
