package com.drpeng.pengxin.api.domain;

import java.io.Serializable;
import java.util.List;

/**
 * 会议室
 * Created by huan.liu on 2016/4/11.
 */
public class MeetingRoom implements Serializable {
    private static final long serialVersionUID = 3417408341315728059L;
    private Long id;
    private String type;
    private List<String> alias;//别名,可以有多个
    private String hostPassword;//管理员密码
    private String memberPassword;//成员密码
    private String guestPassword;//客人密码
    private String canRecording;//是否可以录像
    private String canLive;//是否直播
    private String livePassword;//直播密码
    private String liveUrl;//直播地址
    private Long accountId;//创建人id

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getAlias() {
        return alias;
    }

    public void setAlias(List<String> alias) {
        this.alias = alias;
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

    public String getGuestPassword() {
        return guestPassword;
    }

    public void setGuestPassword(String guestPassword) {
        this.guestPassword = guestPassword;
    }

    public String getCanRecording() {
        return canRecording;
    }

    public void setCanRecording(String canRecording) {
        this.canRecording = canRecording;
    }

    public String getCanLive() {
        return canLive;
    }

    public void setCanLive(String canLive) {
        this.canLive = canLive;
    }

    public String getLivePassword() {
        return livePassword;
    }

    public void setLivePassword(String livePassword) {
        this.livePassword = livePassword;
    }

    public String getLiveUrl() {
        return liveUrl;
    }

    public void setLiveUrl(String liveUrl) {
        this.liveUrl = liveUrl;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
}
