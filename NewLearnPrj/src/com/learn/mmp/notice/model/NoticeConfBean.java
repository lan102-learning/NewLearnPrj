package com.learn.mmp.notice.model;

import java.util.Date;
import java.util.List;

public class NoticeConfBean {
//    private Date catchTime ;
    private List<Date> catchTimeList;
    private String sendMail;
    private String sendMailPsw;
    private boolean isSendImm;
    private Date sendTime ;
    private List<String> receiveMailList;
    
    //////////////////////getter & setter////////////////////////
    public List<Date> getCatchTimeList() {
        return catchTimeList;
    }
    public void setCatchTimeList(List<Date> catchTimeList) {
        this.catchTimeList = catchTimeList;
    }
    public String getSendMail() {
        return sendMail;
    }
    public void setSendMail(String sendMail) {
        this.sendMail = sendMail;
    }
    public String getSendMailPsw() {
        return sendMailPsw;
    }
    public void setSendMailPsw(String sendMailPsw) {
        this.sendMailPsw = sendMailPsw;
    }
    public boolean isSendImm() {
        return isSendImm;
    }
    public void setSendImm(boolean isSendImm) {
        this.isSendImm = isSendImm;
    }
    public Date getSendTime() {
        return sendTime;
    }
    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }
    public List<String> getReceiveMailList() {
        return receiveMailList;
    }
    public void setReceiveMailList(List<String> receiveMailList) {
        this.receiveMailList = receiveMailList;
    }
    
    
}
