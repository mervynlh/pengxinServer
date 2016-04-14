package com.drpeng.pengxin.api.controller;

import com.drpeng.pengxin.api.domain.*;
import com.drpeng.pengxin.common.BaseController;
import com.drpeng.pengxin.api.service.UserService;
import com.drpeng.pengxin.api.util.HttpCodeMes;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


/**
 * account manager interface
 * @author  huan.liu
 */
@Api(value = "Account Service", description = "Account service 服务商操作管理")
@Controller
@RequestMapping("/v1/account")
public class AccountManagerController extends BaseController {

	@ApiOperation(value = "通过服务商账号获取appId，appSecret", httpMethod = "GET", notes = "通过服务商账号密码获取appId，appSecret")
	@RequestMapping(value = "/token", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> createAccount(@RequestParam("account") String account,
											 @RequestParam("password") String password) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		try {
			map.put("code", HttpCodeMes.SUCCESS_CODE);
			map.put("msg", HttpCodeMes.SUCCESS_MES);
			map.put("appId","141324341");
			map.put("appSecret","96E79218965EB72C92A549DD5A330112");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	/**
	 * 修改账户密码
	 * @param account
	 * @param oldPwd
	 * @param newPwd
	 * @param confirmPwd
	 * @return
	 */
	@ApiOperation(value = "修改账号密码", httpMethod = "POST", notes = "(account)接入服务商可以修改自己的password.")
	@RequestMapping(value = "/updatepwd", method = RequestMethod.POST)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功", response = ResultEntity.class) })
	@ResponseBody
	public ResultEntity updateAccountUserPwd(@RequestParam String account,@RequestParam String oldPwd,@RequestParam String newPwd,@RequestParam String confirmPwd){
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
	 * 重置appSecret
	 * @param appId
	 * @return
	 */
	@ApiOperation(value = "修改账号密码", httpMethod = "POST", notes = "(account)接入服务商可以修改自己的password.")
	@RequestMapping(value = "/updateAppId/{appId}", method = RequestMethod.POST)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功", response = ResultEntity.class) })
	@ResponseBody
	public ResultMes updateAccountUserPwd(@PathVariable String appId){
		ResultMes<App> entity = new ResultMes<App>();
		try {
			entity.setCode(HttpCodeMes.SUCCESS_CODE);
			entity.setMsg(HttpCodeMes.SUCCESS_MES);
			App app = new App();
			app.setAppId("3424123");
			app.setAppSecret("E3CEB5881A0A1FDAAD01296D7554868D");
			entity.setData(app);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}





}
