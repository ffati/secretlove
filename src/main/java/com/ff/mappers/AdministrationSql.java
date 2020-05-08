package com.ff.mappers;

import com.ff.entity.GlobalParameterEntity;
import com.ff.entity.SystemPictureManagementEntity;
import org.apache.ibatis.jdbc.SQL;

/**
 * @ClassName GlobalParameterSql
 * @Description TODO
 * @Author ff
 * @Date 2020/4/17 18:03
 * @ModifyDate 2020/4/17 18:03
 * @Version 1.0
 */


public class AdministrationSql {

    public String updateGlobalParameter(GlobalParameterEntity globalParameterEntity){

        String sql=new SQL(){{
            UPDATE("t_global_parameter");

            if (null!=globalParameterEntity.getParameterName())
                SET("Parameter_Name=#{parameterName}");
            if (null!=globalParameterEntity.getParameterValue())
                SET("Parameter_Value=#{parameterValue}");
            if (null!=globalParameterEntity.getDefaultValue())
                SET("Default_Value=#{defaultValue}");
            if (null!=globalParameterEntity.getCustomOrNot())
                SET("Custom_Or_Not=#{customOrNot}");
            if (null!=globalParameterEntity.getFileName())
                SET("File_Name=#{fileName}");
            if (null!=globalParameterEntity.getParameterFunction())
                SET("Parameter_Function=#{parameterFunction}");

            WHERE("id=#{id}");


        }}.toString();

        System.out.println(sql);
        return sql;
    }



    public String updateSystemPictureManagement(SystemPictureManagementEntity systemPictureManagementEntity){

        String sql=new SQL(){{
            UPDATE("t_global_parameter");

            if (null!=systemPictureManagementEntity.getFileName())
                SET("File_Name=#{fileName}");
            if (null!=systemPictureManagementEntity.getFilePath())
                SET("File_Path=#{filePath}");
            if (null!=systemPictureManagementEntity.getPictureFunction())
                SET("Picture_Function=#{pictureFunction}");

            WHERE("id=#{id}");


        }}.toString();

        System.out.println(sql);
        return sql;
    }

}
