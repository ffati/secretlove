package com.ff.repository.user;

import com.ff.entity.RegisterUserEntity;
import com.ff.mappers.UserSql;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName UserDao
 * @Description TODO
 * @Author ff
 * @Date 2020/2/11 13:18
 * @ModifyDate 2020/2/11 13:18
 * @Version 1.0
 */

@Component
public interface UserDao {

    @SelectProvider(type = UserSql.class, method = "findByAnyParam")
    //@Options(useGeneratedKeys=true, keyProperty="ID")
    @Results(id = "userparam", value = {
            @Result(id = true, column = "ID", property = "id"),
            @Result(column = "User_ID", property = "userId"),
            @Result(column = "Nick_Name", property = "nickName"),
            @Result(column = "User_Name", property = "userName"),
            @Result(column = "Phone_number", property = "phoneNumber"),
            @Result(column = "First_Use_time", property = "firstUseTime"),
            @Result(column = "User_Status", property = "userStatus"),
            @Result(column = "Number_Of_Use", property = "numberOfUse"),
            @Result(column = "Number_Of_Infraction", property = "numberOfInfraction"),
            @Result(column = "User_Password", property = "userPassword"),
            @Result(column = "Transfer_Amount", property = "transferAmount"),
            @Result(column = "Balance", property = "balance"),
            @Result(column = "Customer_Type", property = "customerType"),
            @Result(column = "Sex", property = "sex"),
            @Result(column = "HeadSculpture_Address", property = "headSculptureAddress"),
            @Result(column = "Personal_Homepage_Image", property = "personalHomepageImage"),
    })
    RegisterUserEntity findByAnyParam(RegisterUserEntity registerUserEntity);

    @Insert(value = "insert into T_user_registerUser(User_ID,User_Name,Nick_Name,Phone_number,User_Status,User_Password,Customer_Type,Sex) values(#{userId},#{userName},#{nickName},#{phoneNumber},#{userStatus},#{userPassword},#{customerType},#{sex})")
        //@Options(useGeneratedKeys=true, keyProperty="id")
    void insertRegisterUser(RegisterUserEntity registerUserEntity);

    @UpdateProvider(type = UserSql.class, method = "updateRegisterUser")
    void updateRegisterUser(RegisterUserEntity registerUserEntity);

    @Select(value = "select max(ID) from T_user_registerUser")
    Integer findMaxID();

    @Select(value = "select * from T_user_registerUser where User_Name=#{userName}")
    @ResultMap(value = "userparam")
    RegisterUserEntity findRegisterUserByUsername(String userName);

    @Select(value = "select ID from T_user_registerUser where Phone_number=#{phoneNumber}")
    Integer checkPhoneNumber(String phoneNumber);

    @Update(value = "update T_user_registerUser set Number_Of_Infraction=Number_Of_Infraction+1 where ID=#{numberOfInfraction}")
    void addInfraction(String id);

    @Select(value = "select * from T_user_registerUser limit #{size} offset #{index}")
    @ResultMap(value = "userparam")
    List<RegisterUserEntity> findUserByPage(int size, int index);

    @Select(value = "select count(id) from T_user_registerUser")
    int countUserNumber();
}
