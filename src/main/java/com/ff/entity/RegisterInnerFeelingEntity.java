package com.ff.entity;

import java.util.Date;

/**
 * @ClassName RegisterInnerFeelingEntity
 * @Description TODO
 * @Author ff
 * @Date 2020/2/10 16:49
 * @ModifyDate 2020/2/10 16:49
 * @Version 1.0
 */


public class RegisterInnerFeelingEntity {


    /**暂无信息*/
    private Long id;
    /**外键*/
    private Long fkId;
    /**账号id*/
    private String userId;
    /**用户名*/
    private String userName;
    /**手机号码*/
    private String phoneNumber;
    /**线索*/
    private String clue;
    /**内容*/
    private String content;
    /**背景图片*/
    private String backgroundImagSrc;
    /**倾诉对象*/
    private String receiver;
    /**是否定制*/
    private String customized;
    /**顺序*/
    private String pageOrder;
    /**特效列表*/
    private String specialEffectsList;

    private Date startTime;

    private Date endTime;

    private Date effectiveTime;
    /**
     *无参构造函数
     */
    public RegisterInnerFeelingEntity(){
        super();
    }

    /**
     * 带主键构造函数
     * @param id
     */
    public RegisterInnerFeelingEntity(Long id){
        super();
        this.id=id;
    }

    /**
     * 获取暂无信息
     * @return
     */
    public Long getId(){
        return this.id;
    }

    /**
     * 设置暂无信息
     * @param id
     */
    public void setId(Long id){
        this.id=id;
    }
    /**
     * 获取外键
     * @return
     */
    public Long getFkId(){
        return this.fkId;
    }

    /**
     * 设置外键
     * @param fkUserId
     */
    public void setFkId(Long fkUserId){
        this.fkId=fkUserId;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取线索
     * @return
     */
    public String getClue(){
        return this.clue;
    }

    /**
     * 设置线索
     * @param clue
     */
    public void setClue(String clue){
        this.clue=(clue == null ? null : clue.trim());
    }
    /**
     * 获取内容
     * @return
     */
    public String getContent(){
        return this.content;
    }

    /**
     * 设置内容
     * @param content
     */
    public void setContent(String content){
        this.content=(content == null ? null : content.trim());
    }
    /**
     * 获取背景图片
     * @return
     */
    public String getBackgroundImagSrc(){
        return this.backgroundImagSrc;
    }

    /**
     * 设置背景图片
     * @param backgroundImagSrc
     */
    public void setBackgroundImagSrc(String backgroundImagSrc){
        this.backgroundImagSrc=(backgroundImagSrc == null ? null : backgroundImagSrc.trim());
    }
    /**
     * 获取倾诉对象
     * @return
     */
    public String getReceiver(){
        return this.receiver;
    }

    /**
     * 设置倾诉对象
     * @param receiver
     */
    public void setReceiver(String receiver){
        this.receiver=(receiver == null ? null : receiver.trim());
    }
    /**
     * 获取是否定制
     * @return
     */
    public String getCustomized(){
        return this.customized;
    }

    /**
     * 设置是否定制
     * @param customized
     */
    public void setCustomized(String customized){
        this.customized=(customized == null ? null : customized.trim());
    }
    /**
     * 获取有效时间
     * @return
     */
    public Date getEffectiveTime(){
        return this.effectiveTime;
    }

    /**
     * 设置有效时间
     * @param effectiveTime
     */
    public void setEffectiveTime(Date effectiveTime){
        this.effectiveTime=effectiveTime;
    }
    /**
     * 获取顺序
     * @return
     */
    public String getPageOrder(){
        return this.pageOrder;
    }

    /**
     * 设置顺序
     * @param pageOrder
     */
    public void setPageOrder(String pageOrder){
        this.pageOrder=(pageOrder == null ? null : pageOrder.trim());
    }
    /**
     * 获取定制起始时间
     * @return
     */
    public Date getStartTime(){
        return this.startTime;
    }

    /**
     * 设置定制起始时间
     * @param startTime
     */
    public void setStartTime(Date startTime){
        this.startTime=startTime;
    }
    /**
     * 获取结束时间
     * @return
     */
    public Date getEndTime(){
        return this.endTime;
    }

    /**
     * 设置结束时间
     * @param endTime
     */
    public void setEndTime(Date endTime){
        this.endTime=endTime;
    }
    /**
     * 获取特效列表
     * @return
     */
    public String getSpecialEffectsList(){
        return this.specialEffectsList;
    }

    /**
     * 设置特效列表
     * @param specialEffectsList
     */
    public void setSpecialEffectsList(String specialEffectsList){
        this.specialEffectsList=(specialEffectsList == null ? null : specialEffectsList.trim());
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

