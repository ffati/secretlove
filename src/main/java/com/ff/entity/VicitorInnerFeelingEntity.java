package com.ff.entity;

import java.util.Date;

/**
 * @ClassName VicitorInnerFeelingEntity
 * @Description TODO
 * @Author ff
 * @Date 2020/2/10 16:49
 * @ModifyDate 2020/2/10 16:49
 * @Version 1.0
 */

/*      ID
        FK_UserID
        User_Name
        Clue
        Content
        Receiver
        Effective_Time
        Page_Order
        Start_Time
        End_Time
        Background_Imag_Src*/

public class VicitorInnerFeelingEntity {


    /**暂无信息*/
    private Long id;
    /**外键*/
    private String  fkId;
    /**用户名*/
    private String userName;
    /**线索*/
    private String clue;
    /**内容*/
    private String content;
    /**倾诉对象*/
    private String receiver;
    /**顺序*/
    private String pageOrder;
    /**背景图片*/
    private String backgroundImagSrc;
    /**有效时间*/
    private Date effectiveTime;

    private Date startTime;

    private Date endTime;
    /**
     *无参构造函数
     */
    public VicitorInnerFeelingEntity(){
        super();
    }

    /**
     * 带主键构造函数
     * @param id
     */
    public VicitorInnerFeelingEntity(Long id){
        super();
        this.id=id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFkId() {
        return fkId;
    }

    public void setFkId(String fkId) {
        this.fkId = fkId;
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

}
