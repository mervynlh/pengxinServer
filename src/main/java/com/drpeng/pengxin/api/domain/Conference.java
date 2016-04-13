package com.drpeng.pengxin.api.domain;

import java.util.Date;

/**
 * 会议实体
 * Created by zhjy on 2016/4/11.
 */
public class Conference {
    private Long id;
    private Integer status;
    private String hostPassword;//管理员密码
    private String memberPassword;//成员密码
    //recordingOrNot，LiveOrNot，，downloadURL，vodURL，vodPassword。
    private String recordingOrNot;
    private String LiveOrNot;//是否直播
    private boolean VoiceOnly;//true 纯音频会议
    private String downloadURL;//下载地址
    private String vodURL;//地址
    private String vodPassword;//密码
    private Date startTime;
    private Date endTime;
    private Long accountId;//服务商id
    private String type;//类型

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getHostPassword() {
        return hostPassword;
    }

    public void setHostPassword(String hostPassword) {
        this.hostPassword = hostPassword;
    }

    public String getMemberPassword() {
        return memberPassword;
    }

    public void setMemberPassword(String memberPassword) {
        this.memberPassword = memberPassword;
    }

    public String getRecordingOrNot() {
        return recordingOrNot;
    }

    public void setRecordingOrNot(String recordingOrNot) {
        this.recordingOrNot = recordingOrNot;
    }

    public String getLiveOrNot() {
        return LiveOrNot;
    }

    public void setLiveOrNot(String liveOrNot) {
        LiveOrNot = liveOrNot;
    }

    public boolean isVoiceOnly() {
        return VoiceOnly;
    }

    public void setVoiceOnly(boolean voiceOnly) {
        VoiceOnly = voiceOnly;
    }

    public String getDownloadURL() {
        return downloadURL;
    }

    public void setDownloadURL(String downloadURL) {
        this.downloadURL = downloadURL;
    }

    public String getVodURL() {
        return vodURL;
    }

    public void setVodURL(String vodURL) {
        this.vodURL = vodURL;
    }

    public String getVodPassword() {
        return vodPassword;
    }

    public void setVodPassword(String vodPassword) {
        this.vodPassword = vodPassword;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
