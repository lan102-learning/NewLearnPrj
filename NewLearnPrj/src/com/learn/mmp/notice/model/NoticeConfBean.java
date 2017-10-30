package com.learn.mmp.notice.model;

import java.util.List;

public class NoticeConfBean {
    private static final String url = "../resource/mmp/notice.properties";
    
    //private String catchTime;
    private List<String> catchTimeList;
    private String sendEmail;
    private String sendEmailPwd;
    private String emailSmtpHost;
    private String port;
    private String charset;
    private boolean isSendImm;
    private String sendTime ;
    private List<String> receiveMailList;
    private List<String> receiveNameList;
    
    
    @Override
    public String toString() {
        return "NoticeConfBean [catchTimeList=" + catchTimeList + ", sendEmail=" + sendEmail + ", sendEmailPwd="
                + sendEmailPwd + ", emailSmtpHost=" + emailSmtpHost + ", port=" + port + ", charset=" + charset
                + ", isSendImm=" + isSendImm + ", sendTime=" + sendTime + ", receiveMailList=" + receiveMailList
                + ", receiveNameList=" + receiveNameList + "]";
    }
    
   /* @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("");
        sb.append("NoticeConfBean [catchTimeList=" );
        if(catchTimeList!=null) {
            sb.append("{");
        for (String string : catchTimeList) {
            sb.append(string + ",");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("}");
        } else {
            sb.append("null");
        }
        sb.append(",sendEmail=" + sendEmail + ", sendEmailPwd="  + sendEmailPwd + ", isSendImm=" + isSendImm + ", sendTime=" + sendTime );
        
        sb.append(", receiveMailList=");
        if(receiveMailList!=null) {
            sb.append("{");
        for (String string : receiveMailList) {
            sb.append(string+",");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("}");
        } else {
            sb.append("null");
        }
        sb.append("]");
        return sb.toString();
    }*/
    
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

    public String getEmailSmtpHost() {
        return emailSmtpHost;
    }

    public void setEmailSmtpHost(String emailSmtpHost) {
        this.emailSmtpHost = emailSmtpHost;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public List<String> getReceiveNameList() {
        return receiveNameList;
    }

    public void setReceiveNameList(List<String> receiveNameList) {
        this.receiveNameList = receiveNameList;
    }

    public void setSendImm(boolean isSendImm) {
        this.isSendImm = isSendImm;
    }

}
