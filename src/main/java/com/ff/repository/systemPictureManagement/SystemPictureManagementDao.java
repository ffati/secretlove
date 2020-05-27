package com.ff.repository.systemPictureManagement;

import com.ff.entity.SystemPictureManagementEntity;
import com.ff.mappers.AdministrationSql;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName SystemPictureManagementDao
 * @Description TODO
 * @Author ff
 * @Date 2020/4/17 21:46
 * @ModifyDate 2020/4/17 21:46
 * @Version 1.0
 */

@Component
public interface SystemPictureManagementDao {


    @Insert(value = "insert into t_system_picture_management (File_Name,File_Path,Picture_Function) values(#{fileName},#{filePath},#{pictureFunction})")
    void addSystemPictureManagement(SystemPictureManagementEntity systemPictureManagementEntity);

    @UpdateProvider(type = AdministrationSql.class,method = "updateSystemPictureManagement")
    void updateSystemPictureManagement(SystemPictureManagementEntity systemPictureManagementEntity);

    @Select(value = "select id,File_Name,File_Path,Picture_Function from t_system_picture_management limit #{size} offset #{index}")
    @Results(id="SystemPictureManagement" , value = {
            @Result(id = true, column = "ID", property = "id"),
            @Result(column = "File_Name", property = "fileName"),
            @Result(column = "File_Path", property = "filePath"),
            @Result(column = "Picture_Function", property = "pictureFunction"),

    })
    List<SystemPictureManagementEntity > findSystemPictureManagementForPage(int size, int index);


    @Select(value = "select count(id) from t_system_picture_management")
    int numberOfSystemPictureManagementColumn();


}
