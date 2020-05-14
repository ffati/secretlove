package com.ff.repository.globalParameter;

import com.ff.entity.GlobalParameterEntity;
import com.ff.mappers.AdministrationSql;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName GlobalParameterDao
 * @Description TODO
 * @Author ff
 * @Date 2020/4/17 17:52
 * @ModifyDate 2020/4/17 17:52
 * @Version 1.0
 */

@Component
public interface GlobalParameterDao {

    @Insert(value = "insert into t_global_parameter (Parameter_Name,Parameter_Value,Default_Value,Custom_Or_Not,File_Name,Parameter_Function) values(#{parameterName},#{parameterValue},#{defaultValue},#{customOrNot},#{fileName},#{parameterFunction})")
    void addOneGlobalParameter(GlobalParameterEntity globalParameterEntity);

    @UpdateProvider(type = AdministrationSql.class,method = "updateGlobalParameter")
    void updateParameterByParamterName(GlobalParameterEntity globalParameterEntity);

    @Select(value = "select id,Parameter_Name,Parameter_Value,Default_Value,Custom_Or_Not,File_Name,Parameter_Function from t_global_parameter limit #{size} offset #{index}")
    @Results(id="GlobalParameterMap" , value = {
            @Result(id = true, column = "ID", property = "id"),
            @Result(column = "Parameter_Name", property = "parameterName"),
            @Result(column = "Parameter_Value", property = "parameterValue"),
            @Result(column = "Default_Value", property = "defaultValue"),
            @Result(column = "Custom_Or_Not", property = "customOrNot"),
            @Result(column = "File_Name", property = "fileName"),
            @Result(column = "Parameter_Function", property = "parameterFunction"),

    })
    List<GlobalParameterEntity > findForPage(int size,int index);


    @Select(value = "select count(id) from t_global_parameter")
    int numberOfColumn();

}
