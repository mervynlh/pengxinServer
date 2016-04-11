package api.pengxin.web.controller;

import api.pengxin.domain.AccountUser;
import api.pengxin.domain.ResultEntity;
import api.pengxin.domain.ResultMes;
import api.pengxin.domain.User;
import api.pengxin.util.HttpCodeMes;
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
public class UserManagerController {

	@ApiOperation(value = "通过服务商账号密码获取token", httpMethod = "GET", notes = "通过服务商账号密码获取token")
	@RequestMapping(value = "/token", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> createAccount(@RequestParam("account") String account,
											 @RequestParam("password") String password) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		try {
			map.put("code", HttpCodeMes.SUCCESS_CODE);
			map.put("msg", HttpCodeMes.SUCCESS_MES);
			map.put("token","dfadadfsdljfasljdasdaskljqweqe21");
			map.put("expires_in",7200);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	/**
	 * 创建用户
	 * @param token
	 * @param username
	 * @return
	 */
	@ApiOperation(value = "创建用户", httpMethod = "POST", notes = "服务商创建user")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功", response = ResultEntity.class) })
	@ResponseBody
	public ResultMes addUser(@RequestParam String token,@RequestParam String username){
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
	 * @param token
	 * @param userId
	 * @return
	 */
	@ApiOperation(value = "删除用户", httpMethod = "POST", notes = "account删除某个user")
	@RequestMapping(value = "/del", method = RequestMethod.POST)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功", response = ResultEntity.class) })
	@ResponseBody
	public ResultEntity delUser(@RequestParam String token,@RequestParam Long userId){
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
	 * @param token
	 * @return
	 */
	@ApiOperation(value = "获取用户列表", httpMethod = "POST", notes = "获取用户列表")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功", response = ResultEntity.class) })
	@ResponseBody
	public ResultMes<List<User>> getUserList(@RequestParam String token){
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
	 * 获取用户列表
	 * @param token
	 * @return
	 */
	@ApiOperation(value = "获取用户信息", httpMethod = "GET", notes = "获取用户信息")
	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功", response = ResultEntity.class) })
	@ResponseBody
	public ResultMes<User> getUserInfo(@RequestParam String token,@PathVariable Long userId){
		ResultMes<User> entity = new ResultMes<User>();
		try {
			entity.setCode(HttpCodeMes.SUCCESS_CODE);
			entity.setMsg(HttpCodeMes.SUCCESS_MES);
			User user =  new User();
			user.setId(userId);
			user.setUsername("用户名");
			user.setPassword("密码");
			entity.setData(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}








}
