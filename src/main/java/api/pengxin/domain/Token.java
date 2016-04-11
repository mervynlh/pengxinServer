package api.pengxin.domain;

import java.util.Date;

/**
 * Created by zhjy on 2016/4/11.
 */
public class Token {
    private Long id;
    private String token;
    private Date createTime;
    private Date expiresTime;//过期时间
    private Long accountId;//服务商id

}
