package com.ff.entity;

import java.util.Date;

/**
 * @ClassName VicitorEntity
 * @Description TODO
 * @Author ff
 * @Date 2020/2/10 16:50
 * @ModifyDate 2020/2/10 16:50
 * @Version 1.0
 */


public class VicitorEntity {

    /**用户标识符*/
    private Long userid;
    /**用户状态(0:禁用;1:启用)*/
    private String userStatus;
    /**使用次数*/
    private Long numberOfUsed;
    /**违规次数*/
    private String numberOfInfractions;
    /**首次使用*/
    private Date firstUseTime;

    /**
     *无参构造函数
     */
    public VicitorEntity(){
        super();
    }

    /**
     * 带主键构造函数
     * @param id
     */
    public VicitorEntity(Long id){
        super();
        this.userid=id;
    }

    /**
     * 获取用户标识符
     * @return
     */
    public Long getUserid(){
        return this.userid;
    }

    /**
     * 设置用户标识符
     * @param userid
     */
    public void setUserid(Long userid){
        this.userid=userid;
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
     * 获取用户状态(0:禁用;1:启用)
     * @return
     */
    public String getUserStatus(){
        return this.userStatus;
    }

    /**
     * 设置用户状态(0:禁用;1:启用)
     * @param userStatus
     */
    public void setUserStatus(String userStatus){
        this.userStatus=(userStatus == null ? null : userStatus.trim());
    }
    /**
     * 获取使用次数
     * @return
     */
    public Long getNumberOfUsed(){
        return this.numberOfUsed;
    }

    /**
     * 设置使用次数
     * @param numberOfUsed
     */
    public void setNumberOfUsed(Long numberOfUsed){
        this.numberOfUsed=numberOfUsed;
    }
    /**
     * 获取违规次数
     * @return
     */
    public String getNumberOfInfractions(){
        return this.numberOfInfractions;
    }

    /**
     * 设置违规次数
     * @param numberOfInfractions
     */
    public void setNumberOfInfractions(String numberOfInfractions){
        this.numberOfInfractions=(numberOfInfractions == null ? null : numberOfInfractions.trim());
    }


}
