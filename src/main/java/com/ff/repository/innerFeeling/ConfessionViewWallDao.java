package com.ff.repository.innerFeeling;

import com.ff.entity.ConfessionViewWallEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @ClassName ConfessionViewWallDao
 * @Description TODO
 * @Author ff
 * @Date 2020/2/17 13:15
 * @ModifyDate 2020/2/17 13:15
 * @Version 1.0
 */

public interface ConfessionViewWallDao {


    @Insert(value = "insert into T_User_ConfessionViewWall(User_Name,User_Id,Content,Cule,Receiver,Background_Img_Src,Registration_Status) values(#{userName},#{userId},#{content},#{clue},#{receiver},#{backgroundImagSrc},#{registrationStatus})")
    void  insertOne(ConfessionViewWallEntity confessionViewWallEntity);

    @Delete(value = "DELETE FROM t_user_confessionviewwall where id=(select min(id) from(SELECT id from t_user_confessionviewwall) as midTable)")
    void deleteOneEarliest();

    @Select(value = "select ID,Content,Receiver,Background_Img_Src,Join_Time from T_User_ConfessionViewWall limit #{size} offset #{index}")
    @Results(id="ConfessionViewWallparam" , value = {
            @Result(id = true, column = "ID", property = "id"),
            @Result(column = "Content", property = "content"),
            @Result(column = "Receiver", property = "receiver"),
            @Result(column = "Background_Img_Src", property = "backgroundImagSrc"),
            @Result(column = "Join_Time", property = "joinTime"),
    })
    List<ConfessionViewWallEntity> findForPage(Integer index,Integer size);

    @Select(value = "select count(ID) from T_User_ConfessionViewWall")
    Integer countAll();

}
