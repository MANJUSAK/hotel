package com.goodsoft.hotel.domain.entity.guestRoom;

/**
 * 公共信息发布
 * Created by zhiWang on 2017/11/27/027.
 */
public class GsPublicMsgIssuance {
    private String id;
    private String msgType;
    private String msgKeyWord;
    private String msgTheme;
    private String msgContent;
    private String msgRemark;
    private String examineTime  ;
    private String examinePeople;
    private String createPeople;
    private String createTime;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getMsgKeyWord() {
        return msgKeyWord;
    }

    public void setMsgKeyWord(String msgKeyWord) {
        this.msgKeyWord = msgKeyWord;
    }

    public String getMsgTheme() {
        return msgTheme;
    }

    public void setMsgTheme(String msgTheme) {
        this.msgTheme = msgTheme;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }

    public String getMsgRemark() {
        return msgRemark;
    }

    public void setMsgRemark(String msgRemark) {
        this.msgRemark = msgRemark;
    }

    public String getExamineTime() {
        return examineTime;
    }

    public void setExamineTime(String examineTime) {
        this.examineTime = examineTime;
    }

    public String getExaminePeople() {
        return examinePeople;
    }

    public void setExaminePeople(String examinePeople) {
        this.examinePeople = examinePeople;
    }

    public String getCreatePeople() {
        return createPeople;
    }

    public void setCreatePeople(String createPeople) {
        this.createPeople = createPeople;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "GsPublicMsgIssuance{" +
                "id='" + id + '\'' +
                ", msgType='" + msgType + '\'' +
                ", msgKeyWord='" + msgKeyWord + '\'' +
                ", msgTheme='" + msgTheme + '\'' +
                ", msgContent='" + msgContent + '\'' +
                ", msgRemark='" + msgRemark + '\'' +
                ", examineTime='" + examineTime + '\'' +
                ", examinePeople='" + examinePeople + '\'' +
                ", createPeople='" + examineTime + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
