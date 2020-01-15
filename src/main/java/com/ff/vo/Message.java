package com.ff.vo;


import java.io.Serializable;

/**
 * @ClassName Message
 * @Description TODO
 * @Author ff
 * @Date 2019/12/22 22:25
 * @ModifyDate 2019/12/22 22:25
 * @Version 1.0
 */

public class Message implements Serializable {

    //页面显示或不显示此信息
    private String showOrNot;

    //状态码
    private String statusCode;

    //消息
    private String information;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getShowOrNot() {
        return showOrNot;
    }

    public void setShowOrNot(String showOrNot) {
        this.showOrNot = showOrNot;
    }
}
