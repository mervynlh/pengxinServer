package api.pengxin.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import api.pengxin.domain.User;
import api.pengxin.service.UserService;
import api.pengxin.util.HttpCodeMes;

import org.apache.log4j.Logger;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@Api(value = "AccoutUser", description = "用户相关管理")
@Controller
public class AccountUserController{
	
	 // log对象
    private static final Logger logger = Logger.getLogger(AccountUserController.class);// log对象
	@Autowired
	private UserService userService;
	/**
	 * 客户用户登录，获取token
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	@ApiOperation(value = "获取客户信息及token", httpMethod = "GET", notes = "用户登录,获取token")
	@RequestMapping(value = "/v1/orgs/usertest", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> logins(@RequestParam("username") String username,
			@RequestParam("password") String password) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		try {
			// 用户名或密码错误
			map.put("code", HttpCodeMes.ERROR_USERNAME_PASSWORD);
			map.put("message", HttpCodeMes.ERROR_USERNAME_PASSWORD_MES);
		} catch (Exception e) {
			map.put("code", HttpCodeMes.SERVER_INTERNAL_ERROR);
			map.put("message", HttpCodeMes.SERVER_INTERNAL_ERROR_MES);
			e.printStackTrace();
		}
		return map;
	}
	@ApiOperation(value="测试使用",notes="测试使用，可以扩展")
	@RequestMapping(value="/test",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> test(@RequestParam String username,@RequestParam int age){
		HashMap<String, Object> map = new HashMap<>();
		try {
			map.put("aaa","aaa");
			map.put("username", username);
			map.put("age", age);
			User user = userService.getUserById(1l);
			map.put("user", user);
			logger.info("user:"+user);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return map;
	}

	

}
