package com.ff.repository.innerFeeling;

import com.ff.entity.VicitorInnerFeelingEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

/**
 * @ClassName InnerFeelingDao
 * @Description TODO
 * @Author ff
 * @Date 2020/2/10 15:15
 * @ModifyDate 2020/2/10 15:15
 * @Version 1.0
 */

public interface InnerFeelingDao {

    @Insert(value = {"insert into T_user_vicitorInnerFeeling(FK_UserID, User_Name, Clue, Content, Receiver, Effective_Time, Page_Order, Start_Time, End_Time, Background_Imag_Src) values(#{fkUserid}, #{userName}, #{clue}, #{content}, #{receiver}, #{effectiveTime}, #{pageOrder}, #{startTime}, #{endTime}, #{backgroundImagSrc})"})
    @Options(useGeneratedKeys=true, keyProperty="ID")
    void insertfeeling(VicitorInnerFeelingEntity vicitorInnerFeelingEntity);

}
