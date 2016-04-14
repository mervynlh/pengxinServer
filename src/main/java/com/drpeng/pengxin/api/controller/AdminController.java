package com.drpeng.pengxin.api.controller;

import com.drpeng.pengxin.api.domain.*;
import com.drpeng.pengxin.api.service.UserService;
import com.drpeng.pengxin.api.util.HttpCodeMes;
import com.drpeng.pengxin.common.BaseController;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * asystem management interface
 * @author  huan.liu
 */
@Api(value = "system management", description = "system management")
@Controller
@RequestMapping("/v1/admin")
public class AdminController extends BaseController {


	@Autowired
	private UserService userService;
	/**
	 * 创建账号
	 * @param account
	 * @param password
	 * @return
	 */
	@ApiOperation(value = "创建账号", httpMethod = "POST", notes = "Admin为某个接入服务商创建一个唯一的account，password。")
	@RequestMapping(value = "/account/create", method = RequestMethod.POST)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "成功", response = ResultEntity.class),
			@ApiResponse(code = 404, message = "User with given username does not exist"),
			@ApiResponse(code = 500, message = "Internal server error")})
	@ResponseBody
	public ResultMes addAccountUser(@RequestParam String account,@RequestParam String password){
		ResultMes<AccountUser> entity = new ResultMes<AccountUser>();
		try {
			entity.setCode(HttpCodeMes.SUCCESS_CODE);
			entity.setMsg(HttpCodeMes.SUCCESS_MES);
			AccountUser accountUser = new AccountUser();
			accountUser.setPassword(password);
			accountUser.setAccount(account);
			entity.setData(accountUser);
			User user = userService.getUserById(1l);
			//创建appid appsecret
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}
	/**
	 * 删除账号
	 * @param account
	 * @return
	 */
	@ApiOperation(value = "删除账号", httpMethod = "POST", notes = "Admin删除某个接入服务商的account。在实现上做逻辑删除。")
	@RequestMapping(value = "/account/del", method = RequestMethod.POST)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功", response = ResultEntity.class) })
	@ResponseBody
	public ResultEntity delAccountUser(@RequestParam String account){
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
	 * 修改账户密码
	 * @param account
	 * @param password
	 * @return
	 */
	@ApiOperation(value = "修改账号密码", httpMethod = "POST", notes = "(account)接入服务商可以修改自己的password.")
	@RequestMapping(value = "/account/updatepwd", method = RequestMethod.POST)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功", response = ResultEntity.class) })
	@ResponseBody
	public ResultEntity updateAccountUserPwd(@RequestParam String account,@RequestParam String password){
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
	 * 修改账户权限
	 * @param account
	 * @return
	 */
	@ApiOperation(value = "修改账号权限", httpMethod = "POST", notes = "修改账号权限(权限指的是哪些)")
	@RequestMapping(value = "/account/authority", method = RequestMethod.POST)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功", response = ResultEntity.class) })
	@ResponseBody
	public ResultEntity updateAccountUserAuthority(@RequestParam String account){
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
	 * 禁用账号
	 * @param account
	 * @return
	 */
	@ApiOperation(value = "禁用账号", httpMethod = "POST", notes = "禁用账号，被disable的account不能使用朋信平台提供的服务资源")
	@RequestMapping(value = "/account/disable", method = RequestMethod.POST)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功", response = ResultEntity.class) })
	@ResponseBody
	public ResultEntity disableAccountUser(@RequestParam String account){
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
	 * 解除禁用
	 * @param account
	 * @return
	 */
	@ApiOperation(value = "解除禁用", httpMethod = "POST", notes = "解除禁用，如果之前某个account被disable，admin 可以enable这个接入服务商的account，enable以后，\n" +
			"接入服务商可以继续使用朋信平台提供的服务资源，并且原有设定均保持不变。")
	@RequestMapping(value = "/account/enable", method = RequestMethod.POST)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功", response = ResultEntity.class) })
	@ResponseBody
	public ResultEntity enableAccountUser(@RequestParam String account){
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
	 * 创建系统管理员
	 * @param username
	 * @param password
	 * @return
	 */
	@ApiOperation(value = "创建系统管理员", httpMethod = "POST", notes = "创建系统管理员")
	@RequestMapping(value = "/sys/create", method = RequestMethod.POST)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "成功", response = ResultEntity.class),
			@ApiResponse(code = 404, message = "User with given username does not exist"),
			@ApiResponse(code = 500, message = "Internal server error")})
	@ResponseBody
	public ResultMes addSysUser(@RequestParam String username,@RequestParam String password){
		ResultMes<SysUser> entity = new ResultMes<SysUser>();
		try {


			entity.setCode(HttpCodeMes.SUCCESS_CODE);
			entity.setMsg(HttpCodeMes.SUCCESS_MES);
			SysUser user = new SysUser();
			user.setPassword(password);
			user.setUsername(username);
			entity.setData(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}
	/**
	 * 系统管理员列表
	 * @return
	 */
	@ApiOperation(value = "系统管理员列表", httpMethod = "GET", notes = "系统管理员列表")
	@RequestMapping(value = "/sys/list", method = RequestMethod.GET)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "成功", response = ResultEntity.class),
			@ApiResponse(code = 404, message = "User with given username does not exist"),
			@ApiResponse(code = 500, message = "Internal server error")})
	@ResponseBody
	public ResultMes sysUserList(){
		ResultMes<List<SysUser>> entity = new ResultMes<List<SysUser>>();
		try {
			entity.setCode(HttpCodeMes.SUCCESS_CODE);
			entity.setMsg(HttpCodeMes.SUCCESS_MES);
			SysUser user = new SysUser();
			List<SysUser> sysUserList = new ArrayList<>();
			for (int i = 0; i < 10; i++) {
				SysUser temp = new SysUser();
				temp.setUsername("username"+i);
				temp.setPassword(Math.random()+"");
			}
			entity.setData(sysUserList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}
	/**
	 * 修改系统管理员密码
	 * @param oldPwd
	 * @param newPwd
	 * @param confirmPwd
	 * @return
	 */
	@ApiOperation(value = "修改系统管理员密码", httpMethod = "POST", notes = "修改系统管理员密码")
	@RequestMapping(value = "/sys/update", method = RequestMethod.POST)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "成功", response = ResultEntity.class),
			@ApiResponse(code = 404, message = "User with given username does not exist"),
			@ApiResponse(code = 500, message = "Internal server error")})
	@ResponseBody
	public ResultEntity updateSysUserPwd(@RequestParam String oldPwd,@RequestParam String newPwd,@RequestParam String confirmPwd){
		ResultEntity entity = new ResultEntity();
		try {

			entity.setCode(HttpCodeMes.SUCCESS_CODE);
			entity.setMsg(HttpCodeMes.SUCCESS_MES);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}





}
