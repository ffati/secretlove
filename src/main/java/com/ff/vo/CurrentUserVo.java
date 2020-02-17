package com.ff.vo;

import java.util.Date;

/**
 * @ClassName CurrentUserVo
 * @Description TODO
 * @Author ff
 * @Date 2020/1/6 20:41
 * @ModifyDate 2020/1/6 20:41
 * @Version 1.0
 */


public class CurrentUserVo {

    private Long id;

    private String userid;
    /**用户名*/
    private String username;

    private String nickName;

    /**手机号码*/
    private String phonenumber;
    /**用户类别*/
    private String usercategory;
    /**性别*/
    private String sex;
    /**用户级别*/
    private String userlevel;
    /**最后登录ip*/
    private String lastloginip;

    /**注册时间*/
    private Date registrationTime;
    /**最后登陆时间*/
    private Date lastlogintime;
    /**账号状态*/
    private char accountStatus;
    /*头像地址*/
    private String headPictureaddress;
    /*个人主页背景*/
    private String personalHomepageImage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getUsercategory() {
        return usercategory;
    }

    public void setUsercategory(String usercategory) {
        this.usercategory = usercategory;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUserlevel() {
        return userlevel;
    }

    public void setUserlevel(String userlevel) {
        this.userlevel = userlevel;
    }

    public String getLastloginip() {
        return lastloginip;
    }

    public void setLastloginip(String lastloginip) {
        this.lastloginip = lastloginip;
    }

    public Date getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(Date registrationTime) {
        this.registrationTime = registrationTime;
    }

    public Date getLastlogintime() {
        return lastlogintime;
    }

    public void setLastlogintime(Date lastlogintime) {
        this.lastlogintime = lastlogintime;
    }

    public char getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(char accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getHeadPictureaddress() {
        return headPictureaddress;
    }

    public void setHeadPictureaddress(String headPictureaddress) {
        this.headPictureaddress = headPictureaddress;
    }

    public String getPersonalHomepageImage() {
        return personalHomepageImage;
    }

    public void setPersonalHomepageImage(String personalHomepageImage) {
        this.personalHomepageImage = personalHomepageImage;
    }
}
