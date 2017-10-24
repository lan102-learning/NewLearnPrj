package com.learn.mmp.notice.model;

import java.util.List;

public class NoticeConfBean {
    private static final String url = "../resource/mmp/notice.properties";
    
    //private String catchTime;
    private List<String> catchTimeList;
    private String sendEmail;
    private String sendEmailPwd;
    private boolean isSendImm;
    private String sendTime ;
    private List<String> receiveMailList;

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("NoticeConfBean [catchTimeList=" );
        if(catchTimeList.size()==0) {
        for (String string : catchTimeList) {
            sb.append("," + string);
        }}
        sb.append("], sendEmail=" + sendEmail + ", sendEmailPwd="  + sendEmailPwd + ", isSendImm=" + isSendImm + ", sendTime=" + sendTime );
        
        sb.append(", receiveMailList=");
        if(receiveMailList.size()==0) {
        for (String string : receiveMailList) {
            sb.append("," + string);
        }}
        sb.append("]");
        return sb.toString();
    }
    
    ////////////////////// getter & setter////////////////////////

    /*public String getCatchTime() {
        return catchTime;
    }

    public void setCatchTime(String catchTime) {
        this.catchTime = catchTime;
    }*/

    public List<String> getCatchTimeList() {
        return catchTimeList;
    }

    public void setCatchTimeList(List<String> catchTimeList) {
        this.catchTimeList = catchTimeList;
    }

    public String getSendEmail() {
        return sendEmail;
    }

    public void setSendEmail(String sendEmail) {
        this.sendEmail = sendEmail;
    }

    public String getSendEmailPwd() {
        return sendEmailPwd;
    }

    public void setSendEmailPwd(String sendEmailPwd) {
        this.sendEmailPwd = sendEmailPwd;
    }

    public boolean getIsSendImm() {
        return isSendImm;
    }

    public void setIsSendImm(boolean isSendImm) {
        this.isSendImm = isSendImm;
    }

    public List<String> getReceiveMailList() {
        return receiveMailList;
    }

    public void setReceiveMailList(List<String> receiveMailList) {
        this.receiveMailList = receiveMailList;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public static String getUrl() {
        return url;
    }

}
