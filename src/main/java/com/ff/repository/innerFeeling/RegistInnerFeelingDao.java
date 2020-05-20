package com.ff.repository.innerFeeling;

import com.ff.entity.RegisterInnerFeelingEntity;
import com.ff.mappers.RegistInnerFeelingSql;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @ClassName RegistInnerFeelingDao
 * @Description TODO
 * @Author ff
 * @Date 2020/2/14 10:12
 * @ModifyDate 2020/2/14 10:12
 * @Version 1.0
 */

public interface RegistInnerFeelingDao {

    @Insert(value = "insert into T_user_registerInnerFeeling(FK_ID, User_ID, User_Name, Clue, Content,Background_Imag_Src, Receiver,Customized,Start_Time,End_Time,Special_Effects_List,Page_Order,Music_Path,Roll_Img_Type,Cyclic_Display_ImgList,Effective_Time,Drop_Effect_Type) values(#{fkId}, #{userId},#{userName}, #{clue}, #{content},#{backgroundImagSrc}, #{receiver},#{customized},#{startTime},#{endTime},#{specialEffectsList},#{pageOrder},#{musicPath},#{rollImgType},#{cyclicDisplayImgList},#{effectiveTime},#{dropEffectType})")
    void insertRegisterfeeling(RegisterInnerFeelingEntity registerInnerFeelingEntity);


    @Select(value = "select ID,FK_ID,User_ID,User_Name,Clue,Content,Effective_Time,Page_Order,Background_Imag_Src,Special_Effects_List,Customized,Cyclic_Display_ImgList,Music_Path,Roll_Img_Type,Roll_Img_Type from T_user_registerInnerFeeling where Receiver=#{receiver}")
    @Results(id="InnerFeeling" , value = {
            @Result(id = true, column = "ID", property = "id"),
            @Result(column = "FK_ID", property = "fkId"),
            @Result(column = "User_ID", property = "userId"),
            @Result(column = "User_Name", property = "userName"),
            @Result(column = "Clue", property = "clue"),
            @Result(column = "Content", property = "content"),
            @Result(column = "Receiver", property = "receiver"),
            @Result(column = "Effective_Time", property = "effectiveTime"),
            @Result(column = "Page_Order", property = "pageOrder"),
            @Result(column = "Start_Time", property = "startTime"),
            @Result(column = "End_Time", property = "endTime"),
            @Result(column = "Background_Imag_Src", property = "backgroundImagSrc"),
            @Result(column = "Special_Effects_List", property = "specialEffectsList"),
            @Result(column = "Customized", property = "customized"),
            @Result(column = "Cyclic_Display_ImgList", property = "cyclicDisplayImgList"),
            @Result(column = "Music_Path", property = "musicPath"),
            @Result(column = "Roll_Img_Type", property = "rollImgType"),
            @Result(column = "Roll_Img_Type", property = "dropEffectType"),

    })
    List<RegisterInnerFeelingEntity> searchRegisterFelling(String receiver);

    @SelectProvider(type= RegistInnerFeelingSql.class,method="selectPageByanyParam")
    @ResultMap(value = "InnerFeeling")
    List<RegisterInnerFeelingEntity> findPageByAnyParam(int size,int index,RegisterInnerFeelingEntity registerInnerFeelingEntity);


    @Select(value = "SELECT MAX(Page_Order) FROM `T_user_registerInnerFeeling` WHERE User_ID=#{id}")
    String findMaxPageOrder(String id);

    @Select(value = "SELECT count(id) FROM `T_user_registerInnerFeeling` WHERE User_ID=#{userId}")
    int countNumberByUserId(String  userId);
}
