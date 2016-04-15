package com.drpeng.pengxin.api.controller;

import com.drpeng.pengxin.common.BaseController;
import com.drpeng.pengxin.api.domain.ResultEntity;
import com.drpeng.pengxin.api.domain.ResultMes;
import com.drpeng.pengxin.api.domain.User;
import com.drpeng.pengxin.api.util.HttpCodeMes;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * user manager interface
 * @author  huan.liu
 */
@Api(value = "user management", description = "user management相关接口")
@Controller
@RequestMapping("/v1/user")
public class UserManagerController extends BaseController {


	/**
	 * 创建用户
	 * @param username
	 * @param appId
	 * @param appSecret
	 * @return
	 */
	@ApiOperation(value = "创建用户", httpMethod = "POST", notes = "服务商创建user")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功", response = ResultEntity.class) })
	@ResponseBody
	public ResultMes addUser(@RequestParam String appId,@RequestParam String appSecret,@RequestParam String username){
		ResultMes<User> entity = new ResultMes<User>();
		try {
			entity.setCode(HttpCodeMes.SUCCESS_CODE);
			entity.setMsg(HttpCodeMes.SUCCESS_MES);
			User user = new User();
			user.setId(1l);
			user.setAccountId(1l);
			user.setUsername(username+"@account");
			//对user1__41account1进行5次md5 hash产生的字符串
			user.setPassword("密码");
			entity.setData(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}

	/**
	 * 删除用户
	 * @param appId
	 * @param appSecret
	 * @param userId
	 * @return
	 */
	@ApiOperation(value = "删除用户", httpMethod = "POST", notes = "account删除某个user")
	@RequestMapping(value = "/del", method = RequestMethod.POST)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功", response = ResultEntity.class) })
	@ResponseBody
	public ResultEntity delUser(@RequestParam String appId,@RequestParam String appSecret,@RequestParam Long userId){
		ResultEntity entity = new ResultEntity();
		try {
			entity.setCode(HttpCodeMes.SUCCESS_CODE);
			entity.setMsg(HttpCodeMes.SUCCESS_MES);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}
	/**
	 * 获取用户列表
	 * @param appId
	 * @param appSecret
	 * @return
	 */
	@ApiOperation(value = "获取用户列表", httpMethod = "GET", notes = "获取用户列表")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功", response = ResultEntity.class) })
	@ResponseBody
	public ResultMes<List<User>> getUserList(@RequestParam String appId,@RequestParam String appSecret){
		ResultMes<List<User>> entity = new ResultMes();
		List<User> userList = new ArrayList<>();
		try {
			entity.setCode(HttpCodeMes.SUCCESS_CODE);
			entity.setMsg(HttpCodeMes.SUCCESS_MES);
			for (int i = 0; i <10; i++) {
				User user =  new User();
				user.setId(Long.valueOf(i));
				user.setUsername("用户名");
				user.setPassword("密码");
				userList.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}
	/**
	 * (登录)获取用户token信息 贵则：appId ，appSecret 以及用户名生成
	 * @param appId
	 * @param appSecret
	 * @param username
	 * @return
	 */
	@ApiOperation(value = "获取用户token", httpMethod = "GET", notes = "获取用户token信息")
	@RequestMapping(value = "/token", method = RequestMethod.GET)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功", response = ResultEntity.class) })
	@ResponseBody
	public ResultMes<Map<String,String>> getUserInfo(@RequestParam String appId,@RequestParam String appSecret,@RequestParam String username){
		ResultMes<Map<String,String>> entity = new ResultMes<Map<String,String>>();
		try {
			List<User> userList = new ArrayList<>();
			entity.setCode(HttpCodeMes.SUCCESS_CODE);
			entity.setMsg(HttpCodeMes.SUCCESS_MES);
			Map<String,String> map = new HashMap<>();
			map.put("token","E3CEB5881A0A1FDAAD01296D7554868D");
			map.put("expire","7200");
			entity.setData(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}








}
