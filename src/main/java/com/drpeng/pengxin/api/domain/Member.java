package com.drpeng.pengxin.api.domain;

import java.io.Serializable;

/**
 * Created by huan.liu on 2016/4/11.
 */
public class Member implements Serializable {
        private static final long serialVersionUID = -7594774111856197489L;
        private Long id;
        private Long userId;//用户id
        private Long conferenceId;//会议id
        private Integer status;//状态
        private String muteStatus;//静音状态
        private String type;//成员类型，主持人，成员

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public Long getUserId() {
                return userId;
        }

        public void setUserId(Long userId) {
                this.userId = userId;
        }

        public Long getConferenceId() {
                return conferenceId;
        }

        public void setConferenceId(Long conferenceId) {
                this.conferenceId = conferenceId;
        }

        public Integer getStatus() {
                return status;
        }

        public void setStatus(Integer status) {
                this.status = status;
        }

        public String getMuteStatus() {
                return muteStatus;
        }

        public void setMuteStatus(String muteStatus) {
                this.muteStatus = muteStatus;
        }

        public String getType() {
                return type;
        }

        public void setType(String type) {
                this.type = type;
        }
}
