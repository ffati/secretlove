package com.ff.repository.innerFeeling;

import com.ff.entity.RegisterInnerFeelingEntity;
import com.ff.entity.VicitorInnerFeelingEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @ClassName InnerFeelingDao
 * @Description TODO
 * @Author ff
 * @Date 2020/2/10 15:15
 * @ModifyDate 2020/2/10 15:15
 * @Version 1.0
 */

public interface VicitorInnerFeelingDao {

    @Insert(value = "insert into T_user_vicitorInnerFeeling(FK_ID, User_Name, Clue, Content, Receiver,Background_Imag_Src ) values(#{fkId}, #{userName}, #{clue}, #{content}, #{receiver}, #{backgroundImagSrc})")
    //@Options(useGeneratedKeys=true, keyProperty="id")

    void insertvicitorfeeling(VicitorInnerFeelingEntity vicitorInnerFeelingEntity);




    @Select(value = "select FK_ID,User_Name,Clue,Content,Receiver,Page_Order,Background_Imag_Src from T_user_vicitorInnerFeeling where Receiver=#{receiver}")
       @Results(id="vicitorInnerFeeling" , value = {
            @Result(id = true, column = "ID", property = "id"),
            @Result(column = "FK_ID", property = "fkId"),
            @Result(column = "User_Name", property = "userName"),
            @Result(column = "Clue", property = "clue"),
            @Result(column = "Content", property = "content"),
            @Result(column = "Receiver", property = "receiver"),
            @Result(column = "Effective_Time", property = "effectiveTime"),
            @Result(column = "Page_Order", property = "pageOrder"),
            @Result(column = "Start_Time", property = "startTime"),
            @Result(column = "End_Time", property = "endTime"),
            @Result(column = "Background_Imag_Src", property = "backgroundImagSrc"),
    })
    List<VicitorInnerFeelingEntity> searchVicitorFelling(String receiver);

}
