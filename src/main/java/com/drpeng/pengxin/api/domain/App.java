package com.drpeng.pengxin.api.domain;

/**
 * app应用
 * Created by huan.liu on 2016/4/14.
 */
public class App {
        private Long id;
        private String appId;//appId
        private String appSecret;//app秘钥

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }
}
