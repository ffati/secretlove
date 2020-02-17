package com.ff.mappers;

import com.ff.entity.RegisterInnerFeelingEntity;
import org.apache.ibatis.jdbc.SQL;

/**
 * @ClassName RegistInnerFeelingSql
 * @Description TODO
 * @Author ff
 * @Date 2020/2/15 11:15
 * @ModifyDate 2020/2/15 11:15
 * @Version 1.0
 */


public class RegistInnerFeelingSql {

    public String selectAllByanyParam(RegisterInnerFeelingEntity registerInnerFeelingEntity){
        String sql=new SQL(){{
            
            SELECT("*");
            FROM("T_user_registerInnerFeeling");

            if (null!=registerInnerFeelingEntity.getUserId()){
                WHERE("User_ID="+registerInnerFeelingEntity.getUserId());
            }
            if (null!=registerInnerFeelingEntity.getUserName()){
                WHERE("User_Name='"+registerInnerFeelingEntity.getUserName()+"'");
            }
            if (null!=registerInnerFeelingEntity.getCustomized()){
                WHERE("Customized>"+registerInnerFeelingEntity.getCustomized());
            }


        }}.toString();
        System.out.println(sql);
        return sql;
    }

}
