package api.pengxin.util;

public class SMSCode {
	public static final String SUCCESS = "1";
	public static final String SUCCESS_MESSAGE = "请求成功";
	
	public static final String ERROR_UNAME_PASSWORD = "-1";
	public static final String ERROR_UNAME_PASSWORD_MESSAGE = "用户名和密码参数为空或者参数含有非法字符";
	
	public static final String ERROR_MOBILENUMBER = "-2";
	public static final String ERROR_MOBILENUMBER_MESSAGE = "手机号参数不正确";
	
	public static final String ERROR_MSG_PARAMETER = "-3";
	public static final String ERROR_MSG_PARAMETER_MESSAGE = "msg参数为空或长度小于0个字符";
	
	public static final String ERROR_MSG_PARAMETER2 = "-4";
	public static final String ERROR_MSG_PARAMETER2_MESSAGE = "msg参数长度超过64个字符";
	
	public static final String MOBILE_BLACKLIST = "-6";
	public static final String MOBILE_BLACKLIST_MESSAGE = "发送号码为黑名单用户";
	
	public static final String SHIELDING = "-8";
	public static final String SHIELDING_MESSAGE = "下发内容中含有屏蔽词";
	
	public static final String NOACCOUNT = "-9";
	public static final String NOACCOUNT_MESSAGE = "下发账户不存在";
	
	public static final String DISABLE_ACCOUNT = "-10";
	public static final String DISABLE_ACCOUNT_MESSAGE = "下发账户已经停用";
	
	public static final String NO_BALANCE = "-11";
	public static final String NO_BALANCE_MESSAGE = "下发账户无余额";
	
	public static final String ERROR_MD5 = "-15";
	public static final String ERROR_MD5_MESSAGE = "MD5校验错误";
	
	public static final String ERROR_IP = "-16";
	public static final String ERROR_IP_MESSAGE = "IP服务器鉴权错误";
	
	public static final String ERROR_INTERFACE_TYPE = "-17";
	public static final String ERROR_INTERFACE_TYPE_MESSAGE = "接口类型错误";
	
	public static final String ERROR_SERVER_TYPE = "-18";
	public static final String ERROR_SERVER_TYPE_MESSAGE = "服务类型错误";
	
	public static final String SEND_LIMIT = "-22";
	public static final String SEND_LIMIT_MESSAGE = "手机号达到当天发送限制";
	
	public static final String SAMEMOBILE_SEND_LIMIT = "-23";
	public static final String SAMEMOBILE_SEND_LIMIT_MESSAGE = "同一手机号，相同内容达到当天发送限制";
	
	public static final String NO_TEMPLATE = "-24";
	public static final String NO_TEMPLATE_MESSAGE = "模板不存在";
	
	public static final String TOLONG_TEMPLATE = "-25";
	public static final String TOLONG_TEMPLATE_MESSAGE = "模板变量超长";
	
	public static final String NO_RECORD = "-26";
	public static final String NO_RECORD_MESSAGE = "下发限制，该号码没有上行记录";
	
	public static final String NO_WHITELIST = "-27";
	public static final String NO_WHITELIST_MESSAGE = "手机号不是白名单用户 ";
	
	public static final String ERROR_SYSTEM = "-99";
	public static final String ERROR_SYSTEM_MESSAGE = "系统异常";
	
}
