package api.pengxin.util;

import java.util.Random;

public class HttpCodeMes {
	public final static String SUCCESS_CODE = "状态码";
	public final static String SUCCESS_MES="消息";
	
	public final static String MISS_PARAMETER = "1";
	public final static String MISS_PARAMETER_MES = "缺少参数";
	
	public final static String INVALID_TOKEN = "2";
	public final static String INVALID_TOKEN_MES = "无效token";
	
	public final static String NO_PERMISSIONS = "3";
	public final static String NO_PERMISSIONS_MES = "没有权限";
	
	public final static String NO_RESOURCE = "4";
	public final static String NO_RESOURCE_MES = "没有该资源";
	
	public final static String FAILURE_CONFLICT = "5";
	public final static String FAILURE_CONFLICT_MES = "因冲突导致失败";
	
	public final static String ERROR_USERNAME_PASSWORD = "6";
	public final static String ERROR_USERNAME_PASSWORD_MES="用户名或密码错误";
	
	public final static String PHONE_NUMBER_OCCUPIED="7"; 
	public final static String PHONE_NUMBER_OCCUPIED_MES="手机号已注册";
	
	public final static String VERIFICATION_CODE_ERROR="8";
	public final static String VERIFICATION_CODE_ERROR_MES="验证码错误";
	
	public final static String VERIFICATION_CODE_EXPIRES="9";
	public final static String VERIFICATION_CODE_EXPIRES_MES="验证码过期";
	
	public final static String SEND_EMAIL_ERROR="10";
	public final static String SEND_EMAIL_ERROR_MES="邮件发送失败";
	
	public final static String PASSWORD_ERROR="11";
	public final static String PASSWORD_ERROR_MES="密码错误";
	
	public final static String NOLOGIN_ERROR="12";
	public final static String NOLOGIN_ERROR_MES="没有登录,无访问权限";
	
	public final static String PASSWORD_FORMAT_ERROR="13";
	public final static String PASSWORD_FORMAT_ERROR_MES="密码长度必须在6-20个字符之间";
	
	/*public final static String NO_CORRECT_ISACTIVE_ERROR="14";
	public final static String NO_CORRECT_ISACTIVE_ERROR_MES="不正确的";*/
	
	public final static String TIME_ERROR="14";
	public final static String TIME_ERROR_MES="此时间段内有其他会议";
	
	public final static String USERNAME_ERROR="15";
	public final static String USERNAME_ERROR_MES="用户名已存在";
	
	
	public final static String DISPLAYNAME_ERROR="16";
	public final static String DISPLAYNAME_ERROR_MES="设备名称已存在";
	
	public final static String MEETNAME_ERROR="17";
	public final static String MEETNAME_ERROR_MES="会议名称已存在";
	
	public final static String MEETINGROOMNAME_ERROR="18";
	public final static String MEETINGROOMNAME_ERROR_MES="会议室名称已存在";
	
	public final static String DEPT_NAME_ERROR="19";
	public final static String DEPT_NAME_ERROR_MES="部门名称已存在";
	
	
	public final static String SERVER_INTERNAL_ERROR = "999";
	public final static String SERVER_INTERNAL_ERROR_MES = "服务器内部错误";
	
	
	//随机生成手机验证码
	public static String getMobileCode(){
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 4; i++) {
			int result=random.nextInt(10);
			sb.append(String.valueOf(result));
		}
		return sb.toString();
	}
	
}
