package com.ff.mappers;

import com.ff.entity.RegisterUserEntity;
import org.apache.ibatis.jdbc.SQL;

/**
 * @ClassName UserSql
 * @Description TODO
 * @Author ff
 * @Date 2020/2/11 13:51
 * @ModifyDate 2020/2/11 13:51
 * @Version 1.0
 */


public class UserSql {

    public String findByAnyParam(RegisterUserEntity registerUserEntity){

/*        if (registerUserEntity.getUserName()==null&&registerUserEntity.getUserId()==null&&registerUserEntity.getNickName()==null&&registerUserEntity.getPhoneNumber()==null&&registerUserEntity.getFirstUseTime()==null&&registerUserEntity.getUserStatus()==null)
        {
            return "select id from t_user_registeruser where (select min(id) from t_user_registeruser)";

        }*/

        String sqlst= new SQL(){{

            SELECT(" User_ID,Nick_Name,User_Name,Phone_number,First_Use_time,User_Status,Number_Of_Use,Number_Of_Infraction,Transfer_Amount,Balance,Customer_Type,Sex,HeadSculpture_Address,Personal_Homepage_Image ");
            FROM("t_user_registeruser");

            if (null!=registerUserEntity.getUserName()){
                WHERE("User_Name="+registerUserEntity.getUserName());
            }
            if (null!=registerUserEntity.getUserId()){
                WHERE("User_ID="+registerUserEntity.getUserId());
            }
            if (null!=registerUserEntity.getNickName()){
                WHERE("User_Nick_Name='"+registerUserEntity.getNickName()+"'");
            }
            if (null!=registerUserEntity.getPhoneNumber()){
                WHERE("Phone_number="+registerUserEntity.getPhoneNumber());
            }
            if (null!=registerUserEntity.getFirstUseTime()){
                WHERE("First_Use_time="+registerUserEntity.getFirstUseTime());
            }
            if (null!=registerUserEntity.getUserStatus()){
                WHERE("User_Status="+registerUserEntity.getUserStatus());
            }
            if (null!=registerUserEntity.getCustomerType()){
                WHERE("Customer_Type="+registerUserEntity.getCustomerType());
            }

        }}.toString();
        System.out.println(sqlst);
        return sqlst;
    };


public String updateRegisterUser(RegisterUserEntity registerUserEntity){

    return new SQL(){{

        UPDATE("t_user_registeruser");
        if (null!=registerUserEntity.getUserPassword()){
            SET("User_Password=#{userPassword}");

        }
        if (null!=registerUserEntity.getNickName()){
            SET("Nick_Name=#{nickName}");

        }
/*        if (null!=registerUserEntity.getPhoneNumber()){
            SET("Phone_number=#{phoneNumber}");

        }*/
        if (null!=registerUserEntity.getUserStatus()){
            SET("User_Status=#{userStatus}");

        }
        if (null!=registerUserEntity.getTransferAmount()){
            SET("Transfer_Amount=#{transferAmount}");

        }

        if (null!=registerUserEntity.getHeadSculptureAddress()){
            SET("HeadSculpture_Address=#{headSculptureAddress}");

        }
        if (null!=registerUserEntity.getPersonalHomepageImage()){
            SET("Personal_Homepage_Image=#{personalHomepageImage}");

        }


        WHERE("User_ID=#{userId}");

    }}.toString();
}


}
