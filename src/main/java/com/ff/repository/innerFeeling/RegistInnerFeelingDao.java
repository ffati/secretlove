package com.ff.repository.innerFeeling;

import com.ff.entity.RegisterInnerFeelingEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * @ClassName RegistInnerFeelingDao
 * @Description TODO
 * @Author ff
 * @Date 2020/2/14 10:12
 * @ModifyDate 2020/2/14 10:12
 * @Version 1.0
 */

public interface RegistInnerFeelingDao {

    @Insert(value = "insert into T_user_registerInnerFeeling(FK_ID, User_Name, Clue, Content,Background_Imag_Src, Receiver,Customized,Start_Time,End_Time,Special_Effects_List) values(#{fkId}, #{userName}, #{clue}, #{content},#{backgroundImagSrc}, #{receiver},#{Customized},#{startTime},#{endTime},#{specialEffectsList})")
    void insertRegisterfeeling(RegisterInnerFeelingEntity registerInnerFeelingEntity);


    @Select(value = "select * from T_user_registerInnerFeeling where Receiver=#{receiver}")
    RegisterInnerFeelingEntity searchRegisterFelling(String receiver);

}
