package com.ff.entity;

import java.util.Date;


public class UserEntity {

    /**用户id*/

    private Long userid;
    /**用户名*/
    private String username;
    /**手机号码*/
    private String phonenumber;
    /**用户类别*/
    private String usercategory;
    /**性别*/
    private String sex;
    /**用户级别*/
    private String userlevel;
    /**头像地址*/
    private String pictureaddress;
    /**最后登录ip*/
    private String lastloginip;
    /**用户密码*/
    private String userpassword;
    /**真实姓名*/
    private String truename;
    /**身份号码*/
    private String identityid;
    /**注册时间*/
    private Date registrationTime;
    /**最后登陆时间*/
    private Date lastlogintime;
    /**账号状态*/
    private char accountStatus;


    /**
     * 获取用户id
     * @return
     */
    public Long getUserid(){
        return this.userid;
    }

    /**
     * 设置用户id
     * @param userid
     */
    public void setUserid(Long userid){
        this.userid=userid;
    }
    /**
     * 获取用户名
     * @return
     */
    public String getUsername(){
        return this.username;
    }

    /**
     * 设置用户名
     * @param username
     */
    public void setUsername(String username){
        this.username=(username == null ? null : username.trim());
    }
    /**
     * 获取手机号码
     * @return
     */
    public String getPhonenumber(){
        return this.phonenumber;
    }

    /**
     * 设置手机号码
     * @param phonenumber
     */
    public void setPhonenumber(String phonenumber){
        this.phonenumber=(phonenumber == null ? null : phonenumber.trim());
    }
    /**
     * 获取用户类别
     * @return
     */
    public String getUsercategory(){
        return this.usercategory;
    }

    /**
     * 设置用户类别
     * @param usercategory
     */
    public void setUsercategory(String usercategory){
        this.usercategory=(usercategory == null ? null : usercategory.trim());
    }
    /**
     * 获取性别
     * @return
     */
    public String getSex(){
        return this.sex;
    }

    /**
     * 设置性别
     * @param sex
     */
    public void setSex(String sex){
        this.sex=(sex == null ? null : sex.trim());
    }

    /**
     * 获取用户级别
     * @return
     */
    public String getUserlevel(){
        return this.userlevel;
    }

    /**
     * 设置用户级别
     * @param userlevel
     */
    public void setUserlevel(String userlevel){
        this.userlevel=(userlevel == null ? null : userlevel.trim());
    }
    /**
     * 获取头像地址
     * @return
     */
    public String getPictureaddress(){
        return this.pictureaddress;
    }

    /**
     * 设置头像地址
     * @param pictureaddress
     */
    public void setPictureaddress(String pictureaddress){
        this.pictureaddress=(pictureaddress == null ? null : pictureaddress.trim());
    }
    /**
     * 获取最后登录时间
     * @return
     */

    /**
     * 获取用户密码
     * @return
     */
    public String getUserpassword(){
        return this.userpassword;
    }

    /**
     * 设置用户密码
     * @param userpassword
     */
    public void setUserpassword(String userpassword){
        this.userpassword=(userpassword == null ? null : userpassword.trim());
    }
    /**
     * 获取真实姓名
     * @return
     */
    public String getTruename(){
        return this.truename;
    }

    /**
     * 设置真实姓名
     * @param truename
     */
    public void setTruename(String truename){
        this.truename=(truename == null ? null : truename.trim());
    }
    /**
     * 获取身份号码
     * @return
     */
    public String getIdentityid(){
        return this.identityid;
    }

    /**
     * 设置身份号码
     * @param identityid
     */
    public void setIdentityid(String identityid){
        this.identityid=(identityid == null ? null : identityid.trim());
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

    public String getLastloginip() {
        return lastloginip;
    }

    public void setLastloginip(String lastloginip) {
        this.lastloginip = (lastloginip == null ? null : lastloginip.trim());
    }

    public char getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(char accountStatus) {
        this.accountStatus = accountStatus;
    }

}
