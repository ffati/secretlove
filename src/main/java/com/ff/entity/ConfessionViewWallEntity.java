package com.ff.entity;

import java.util.Date;

/**
 * @ClassName ConfessionViewWallEntity
 * @Description TODO
 * @Author ff
 * @Date 2020/2/17 12:57
 * @ModifyDate 2020/2/17 12:57
 * @Version 1.0
 */


public class ConfessionViewWallEntity {

    /**id*/
    private Long id;
    /**账号id*/
    private String userId;
    /**用户名*/
    private String userName;
    /**线索*/
    private String clue;
    /**内容*/
    private String content;
    /**倾诉对象*/
    private String receiver;
    /**背景图片*/
    private String backgroundImagSrc;

    private Date joinTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getClue() {
        return clue;
    }

    public void setClue(String clue) {
        this.clue = clue;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getBackgroundImagSrc() {
        return backgroundImagSrc;
    }

    public void setBackgroundImagSrc(String backgroundImagSrc) {
        this.backgroundImagSrc = backgroundImagSrc;
    }

    public Date getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }
}
