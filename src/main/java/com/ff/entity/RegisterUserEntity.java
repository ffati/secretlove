package com.ff.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @ClassName RegisterUserEntity
 * @Description TODO
 * @Author ff
 * @Date 2020/2/10 16:50
 * @ModifyDate 2020/2/10 16:50
 * @Version 1.0
 */


public class RegisterUserEntity {

    /**ID*/
    private Long id;
    /**标识符*/
    private String userId;
    /**用户名*/
    private String userName;
    /**昵称*/
    private String nickName;
    /**手机号码*/
    private String phoneNumber;
    /**用户状态*/
    private String userStatus;
    /**使用次数*/
    private String numberOfUse;
    /**违规次数*/
    private String numberOfInfraction;
    /**密码*/
    private String userPassword;
    /**充值数额*/
    private String transferAmount;
    /*余额*/
    private String balance;
    /**用户类型*/
    private String customerType;

    /**首次使用*/
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date firstUseTime;

    private String sex;

    private String headSculptureAddress;

    private String userCategory;
    /*个人主页背景*/
    private String personalHomepageImage;

    /**
     *无参构造函数
     */
    public RegisterUserEntity(){
        super();
    }

    /**
     * 带主键构造函数
     * @param id
     */
    public RegisterUserEntity(Long id){
        super();
        this.id=id;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取标识符
     * @return
     */
    public String  getUserId(){
        return this.userId;
    }

    /**
     * 设置标识符
     * @param userId
     */
    public void setUserId(String userId){
        this.userId=userId;
    }
    /**
     * 获取用户名
     * @return
     */
    public String getUserName(){
        return this.userName;
    }

    /**
     * 设置用户名
     * @param userName
     */
    public void setUserName(String userName){
        this.userName=(userName == null ? null : userName.trim());
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * 获取手机号码
     * @return
     */
    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    /**
     * 设置手机号码
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber=(phoneNumber == null ? null : phoneNumber.trim());
    }
    /**
     * 获取首次使用时间
     * @return
     */
    public Date getFirstUseTime(){
        return this.firstUseTime;
    }

    /**
     * 设置首次使用时间
     * @param firstUseTime
     */
    public void setFirstUseTime(Date firstUseTime){
        this.firstUseTime=firstUseTime;
    }
    /**
     * 获取用户状态
     * @return
     */
    public String getUserStatus(){
        return this.userStatus;
    }

    /**
     * 设置用户状态
     * @param userStatus
     */
    public void setUserStatus(String userStatus){
        this.userStatus=(userStatus == null ? null : userStatus.trim());
    }
    /**
     * 获取使用次数
     * @return
     */
    public String getNumberOfUse(){
        return this.numberOfUse;
    }

    /**
     * 设置使用次数
     * @param numberOfUse
     */
    public void setNumberOfUse(String numberOfUse){
        this.numberOfUse=(numberOfUse == null ? null : numberOfUse.trim());
    }
    /**
     * 获取违规次数
     * @return
     */
    public String getNumberOfInfraction(){
        return this.numberOfInfraction;
    }

    /**
     * 设置违规次数
     * @param numberOfInfraction
     */
    public void setNumberOfInfraction(String numberOfInfraction){
        this.numberOfInfraction=(numberOfInfraction == null ? null : numberOfInfraction.trim());
    }
    /**
     * 获取密码
     * @return
     */
    public String getUserPassword(){
        return this.userPassword;
    }

    /**
     * 设置密码
     * @param userPassword
     */
    public void setUserPassword(String userPassword){
        this.userPassword=(userPassword == null ? null : userPassword.trim());
    }
    /**
     * 获取充值数额
     * @return
     */
    public String getTransferAmount(){
        return this.transferAmount;
    }

    /**
     * 设置充值数额
     * @param transferAmount
     */
    public void setTransferAmount(String transferAmount){
        this.transferAmount=(transferAmount == null ? null : transferAmount.trim());
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    /**
     * 获取用户类型
     * @return
     */
    public String getCustomerType(){
        return this.customerType;
    }

    /**
     * 设置用户类型
     * @param customerType
     */
    public void setCustomerType(String customerType){
        this.customerType=(customerType == null ? null : customerType.trim());
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHeadSculptureAddress() {
        return headSculptureAddress;
    }

    public void setHeadSculptureAddress(String headSculptureAddress) {
        this.headSculptureAddress = headSculptureAddress;
    }

    public String getUserCategory() {
        return userCategory;
    }

    public void setUserCategory(String userCategory) {
        this.userCategory = userCategory;
    }

    public String getPersonalHomepageImage() {
        return personalHomepageImage;
    }

    public void setPersonalHomepageImage(String personalHomepageImage) {
        this.personalHomepageImage = personalHomepageImage;
    }
}
