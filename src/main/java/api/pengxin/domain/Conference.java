package api.pengxin.domain;

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
    private String accountId;//服务商id
}
