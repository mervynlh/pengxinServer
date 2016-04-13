package api.pengxin.web.controller;

import api.pengxin.common.BaseController;
import api.pengxin.domain.Conference;
import api.pengxin.domain.MeetingRoom;
import api.pengxin.domain.ResultEntity;
import api.pengxin.domain.ResultMes;
import api.pengxin.util.HttpCodeMes;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


/**
 * meeting room interface
 * @author  huan.liu
 */
@Api(value = "conference", description = "conference相关接口")
@Controller
@RequestMapping("/v1/conference")
public class ConferenceController extends BaseController {


	/**
	 * 创建会议
	 * @param token
	 * @return
	 */
	@ApiOperation(value = "创建会议-SFU模式", httpMethod = "POST", notes = "创建会议-SFU模式会议")
	@RequestMapping(value = "/create_SFU", method = RequestMethod.POST)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功", response = ResultMes.class) })
	@ResponseBody
	public ResultMes addSFUConference(@RequestParam String token){
		ResultMes<Conference> entity = new ResultMes<Conference>();
		try {
			entity.setCode(HttpCodeMes.SUCCESS_CODE);
			entity.setMsg(HttpCodeMes.SUCCESS_MES);
			Conference conference = new Conference();
			conference.setId(1l);
			conference.setStartTime(new Date());
			conference.setEndTime(new Date());
			conference.setAccountId(1L);
			conference.setType("SFU");

			conference.setHostPassword("会议管理者密码");
			entity.setData(conference);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}
	/**
	 * 创建会议MCU
	 * @param token
	 * @return
	 */
	@ApiOperation(value = "创建会议-MCU模式", httpMethod = "POST", notes = "创建会议-MCU模式会议")
	@RequestMapping(value = "/create_MCU", method = RequestMethod.POST)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功", response = ResultMes.class) })
	@ResponseBody
	public ResultMes addMCUConference(@RequestParam String token){
		ResultMes<Conference> entity = new ResultMes<Conference>();
		try {
			entity.setCode(HttpCodeMes.SUCCESS_CODE);
			entity.setMsg(HttpCodeMes.SUCCESS_MES);
			Conference conference = new Conference();
			conference.setId(1l);
			conference.setStartTime(new Date());
			conference.setEndTime(new Date());
			conference.setAccountId(1L);
			conference.setType("SFU");
			conference.setMemberPassword("会议成员密码");
			conference.setDownloadURL("会议下载地址");
			conference.setLiveOrNot("true");
			conference.setHostPassword("会议管理者密码");
			entity.setData(conference);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}
	/**
	 * 取消会议
	 * @param token
	 * @param conferenceId
	 * @return
	 */
	@ApiOperation(value = "取消会议", httpMethod = "POST", notes = "取消会议")
	@RequestMapping(value = "/cancel", method = RequestMethod.POST)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功", response = ResultMes.class) })
	@ResponseBody
	public ResultMes cancelConference(@RequestParam String token,@RequestParam Long conferenceId){
		ResultMes<Conference> entity = new ResultMes<Conference>();
		try {
			entity.setCode(HttpCodeMes.SUCCESS_CODE);
			entity.setMsg(HttpCodeMes.SUCCESS_MES);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}
	/**
	 * 修改会议
	 * @param token
	 * @param conference
	 * @return
	 */
	@ApiOperation(value = "修改会议", httpMethod = "POST", notes = "修改会议")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功", response = ResultMes.class) })
	@ResponseBody
	public ResultMes updateConference(@RequestParam String token,@ModelAttribute Conference conference){
		ResultMes<Conference> entity = new ResultMes<Conference>();
		try {
			entity.setCode(HttpCodeMes.SUCCESS_CODE);
			entity.setMsg(HttpCodeMes.SUCCESS_MES);
			entity.setData(conference);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}
	/**
	 * 进入会议
	 * @param token
	 * @param confenerceId
	 * @param password
	 * @return
	 */
	@ApiOperation(value = "进入会议", httpMethod = "POST", notes = "进入会议")
	@RequestMapping(value = "/enter", method = RequestMethod.POST)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功", response = ResultEntity.class) })
	@ResponseBody
	public ResultEntity enterConference(@RequestParam String token,@RequestParam String confenerceId,@RequestParam String password){
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
	 * 主持人静音成员
	 * @param token
	 * @param userId
	 * @param conferenceId
	 * @return
	 */
	@ApiOperation(value = "主持人静音成员", httpMethod = "POST", notes = "主持人静音成员")
	@RequestMapping(value = "/member/mute", method = RequestMethod.POST)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功", response = ResultEntity.class) })
	@ResponseBody
	public ResultEntity muteMember(@RequestParam String token,@RequestParam Long userId,@RequestParam Long conferenceId){
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
	 * 主持人解除静音成员
	 * @param token
	 * @param userId
	 * @param conferenceId
	 * @return
	 */
	@ApiOperation(value = "主持人解除静音成员", httpMethod = "POST", notes = "主持人解除静音成员")
	@RequestMapping(value = "/member/unmute", method = RequestMethod.POST)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功", response = ResultEntity.class) })
	@ResponseBody
	public ResultEntity unMuteMember(@RequestParam String token,@RequestParam Long userId,@RequestParam Long conferenceId){
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
	 * 主持人邀请成员
	 * @param token
	 * @param userId
	 * @param conferenceId
	 * @return
	 */
	@ApiOperation(value = "主持人邀请成员", httpMethod = "POST", notes = "主持人邀请成员")
	@RequestMapping(value = "/member/invite", method = RequestMethod.POST)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功", response = ResultEntity.class) })
	@ResponseBody
	public ResultEntity inviteMember(@RequestParam String token,@RequestParam Long userId,@RequestParam Long conferenceId){
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
	 * 主持人踢出成员
	 * @param token
	 * @param userId
	 * @param conferenceId
	 * @return
	 */
	@ApiOperation(value = "主持人踢出成员", httpMethod = "POST", notes = "主持人踢出成员")
	@RequestMapping(value = "/member/kick", method = RequestMethod.POST)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功", response = ResultEntity.class) })
	@ResponseBody
	public ResultEntity kickMember(@RequestParam String token,@RequestParam Long userId,@RequestParam Long conferenceId){
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
	 * 主持人关闭会议
	 * @param token
	 * @param conferenceId
	 * @return
	 */
	@ApiOperation(value = "主持人关闭会议", httpMethod = "POST", notes = "主持人关闭会议")
	@RequestMapping(value = "/close", method = RequestMethod.POST)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功", response = ResultEntity.class) })
	@ResponseBody
	public ResultEntity closeConference(@RequestParam String token,@RequestParam Long conferenceId){
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
	 * 获取会议event
	 * @param token
	 * @param conferenceId
	 * @return
	 */
	@ApiOperation(value = "会议事件信息", httpMethod = "POST", notes = "会议事件信息")
	@RequestMapping(value = "/events", method = RequestMethod.POST)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功", response = ResultEntity.class) })
	@ResponseBody
	public ResultEntity conferenceEvent(@RequestParam String token,@RequestParam Long conferenceId){
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
