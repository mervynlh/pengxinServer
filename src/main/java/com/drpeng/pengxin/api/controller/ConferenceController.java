package com.drpeng.pengxin.api.controller;

import com.drpeng.pengxin.api.domain.*;
import com.drpeng.pengxin.common.BaseController;
import com.drpeng.pengxin.api.util.HttpCodeMes;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * meeting room interface
 * @author  huan.liu
 */
@Api(value = "conference", description = "conference相关接口")
@Controller
@RequestMapping("/v1")
public class ConferenceController extends BaseController {


	/**
	 * 创建会议-SFU模式1 ,该会议不能录制，直播
	 * @param token
	 * @param username
	 * @param conference
	 * @return
	 */
	@ApiOperation(value = "创建会议-SFU模式1", httpMethod = "POST", notes = "创建会议-SFU1模式会议,点对点呼叫")
	@RequestMapping(value = "/conference/create_SFU/1", method = RequestMethod.POST)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功", response = ResultMes.class) })
	@ResponseBody
	public ResultMes addSFUConference1(@RequestParam String token,@ModelAttribute String username,@ModelAttribute Conference conference){
		ResultMes<Conference> entity = new ResultMes<Conference>();
		try {
			entity.setCode(HttpCodeMes.SUCCESS_CODE);
			entity.setMsg(HttpCodeMes.SUCCESS_MES);
			conference.setId(1l);
			conference.setType("SFU1");
			entity.setData(conference);

			//添加会议成员
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}
	/**
	 * 创建会议
	 * @param token
	 * @param conference
	 * @return
	 */
	@ApiOperation(value = "创建会议-SFU模式2", httpMethod = "POST", notes = "创建会议-SFU模式2会议")
	@RequestMapping(value = "/conference/create_SFU/2", method = RequestMethod.POST)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功", response = ResultMes.class) })
	@ResponseBody
	public ResultMes addSFUConference2(@RequestParam String token,@ModelAttribute Conference conference){
		ResultMes<Conference> entity = new ResultMes<Conference>();
		try {
			entity.setCode(HttpCodeMes.SUCCESS_CODE);
			entity.setMsg(HttpCodeMes.SUCCESS_MES);
			conference.setId(1l);
			conference.setType("SFU2");
			entity.setData(conference);

			//添加会议成员
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}
	/**
	 * 创建会议MCU
	 * @param token
	 * @param conference
	 * @return
	 */
	@ApiOperation(value = "创建会议-MCU模式", httpMethod = "POST", notes = "创建会议-MCU模式会议")
	@RequestMapping(value = "/conference/create_MCU", method = RequestMethod.POST)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功", response = ResultMes.class) })
	@ResponseBody
	public ResultMes addMCUConference(@RequestParam String token,@ModelAttribute Conference conference){
		ResultMes<Conference> entity = new ResultMes<Conference>();
		try {
			entity.setCode(HttpCodeMes.SUCCESS_CODE);
			entity.setMsg(HttpCodeMes.SUCCESS_MES);
			conference.setId(1l);
			conference.setStartTime(new Date());
			conference.setEndTime(new Date());
			conference.setAccountId(1L);
			conference.setType("SFU");
			entity.setData(conference);

			//添加会议成员
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
	@RequestMapping(value = "/conference/cancel/{conferenceId}", method = RequestMethod.POST)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功", response = ResultMes.class) })
	@ResponseBody
	public ResultMes cancelConference(@RequestParam String token,@PathVariable Long conferenceId){
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
	@RequestMapping(value = "/conference/update", method = RequestMethod.POST)
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
	 * @param conferenceId
	 * @param password
	 * @return
	 */
	@ApiOperation(value = "进入会议", httpMethod = "POST", notes = "进入会议")
	@RequestMapping(value = "/conference/enter/{confenerceId}", method = RequestMethod.POST)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功", response = ResultEntity.class) })
	@ResponseBody
	public ResultEntity enterConference(@RequestParam String token,@PathVariable String conferenceId,@RequestParam String password){
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
	 * 获取会议室成员
	 * @param token
	 * @param conferenceId
	 * @return
	 */
	@ApiOperation(value = "获取会议室成员", httpMethod = "GET", notes = "获取会议室成员")
	@RequestMapping(value = "/conference/member/list", method = RequestMethod.GET)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功", response = ResultEntity.class) })
	@ResponseBody
	public ResultMes<List<Member>> memberList(@RequestParam String token,@RequestParam Long conferenceId){
		ResultMes<List<Member>> entity = new ResultMes<List<Member>>();
		try {
			entity.setCode(HttpCodeMes.SUCCESS_CODE);
			entity.setMsg(HttpCodeMes.SUCCESS_MES);
			List<Member> memberList = new ArrayList<>();
			for (int i = 0; i <10 ; i++) {
				Member member = new Member();
				member.setId(Long.valueOf(i));
				member.setConferenceId(conferenceId);
				member.setUserId(Long.valueOf(i));
				member.setMuteStatus("静音状态");
				member.setType("成员类型，主持人，普通成员");
				memberList.add(member);
			}
			entity.setData(memberList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}

	/**
	 * 主持人静音成员
	 * @param token
	 * @param username  成员
	 * @param conferenceId
	 * @return
	 */
	@ApiOperation(value = "主持人静音成员", httpMethod = "POST", notes = "主持人静音成员")
	@RequestMapping(value = "/conference/member/mute", method = RequestMethod.POST)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功", response = ResultEntity.class) })
	@ResponseBody
	public ResultEntity muteMember(@RequestParam String token,@RequestParam String username,@RequestParam Long conferenceId){
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
	 * @param username
	 * @param conferenceId
	 * @return
	 */
	@ApiOperation(value = "主持人解除静音成员", httpMethod = "POST", notes = "主持人解除静音成员")
	@RequestMapping(value = "/conference/member/unmute", method = RequestMethod.POST)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功", response = ResultEntity.class) })
	@ResponseBody
	public ResultEntity unMuteMember(@RequestParam String token,@RequestParam String username,@RequestParam Long conferenceId){
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
	 * @param username
	 * @param conferenceId
	 * @return
	 */
	@ApiOperation(value = "主持人邀请成员", httpMethod = "POST", notes = "主持人邀请成员")
	@RequestMapping(value = "/conference/member/invite", method = RequestMethod.POST)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功", response = ResultEntity.class) })
	@ResponseBody
	public ResultEntity inviteMember(@RequestParam String token,@RequestParam String username,@RequestParam Long conferenceId){
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
	 * @param username
	 * @param conferenceId
	 * @return
	 */
	@ApiOperation(value = "主持人踢出成员", httpMethod = "POST", notes = "主持人踢出成员")
	@RequestMapping(value = "/conference/member/kick", method = RequestMethod.POST)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功", response = ResultEntity.class) })
	@ResponseBody
	public ResultEntity kickMember(@RequestParam String token,@RequestParam String username,@RequestParam Long conferenceId){
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
	@RequestMapping(value = "/conference/close/{conferenceId}", method = RequestMethod.POST)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功", response = ResultEntity.class) })
	@ResponseBody
	public ResultEntity closeConference(@RequestParam String token,@PathVariable Long conferenceId){
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
	@ApiOperation(value = "会议事件信息", httpMethod = "GET", notes = "会议事件信息")
	@RequestMapping(value = "/conference/events", method = RequestMethod.GET)
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


	/**
	 * 创建meeting room
	 * @param appId
	 * @param appSecret
	 * @return
	 */
	@ApiOperation(value = "创建会议室", httpMethod = "POST", notes = "创建会议室。")
	@RequestMapping(value = "/room/create", method = RequestMethod.POST)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功", response = ResultMes.class) })
	@ResponseBody
	public ResultMes addMeetingRoom(@RequestParam String appId,@RequestParam String appSecret,@ModelAttribute MeetingRoom meetingRoom,@RequestParam List<String> aliases){
		ResultMes<MeetingRoom> entity = new ResultMes<MeetingRoom>();
		try {
			entity.setCode(HttpCodeMes.SUCCESS_CODE);
			entity.setMsg(HttpCodeMes.SUCCESS_MES);
			meetingRoom.setAlias(aliases);
			meetingRoom.setCanLive("是否直播");
			meetingRoom.setHostPassword("会议管理者密码");
			meetingRoom.setGuestPassword("参会人密码");
			meetingRoom.setLiveUrl("直播地址");
			entity.setData(meetingRoom);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}
	/**
	 * 删除会议室
	 * @param appId
	 * @param appSecret
	 * @param roomId
	 * @return
	 */
	@ApiOperation(value = "删除会议室", httpMethod = "POST", notes = "删除某个会议室")
	@RequestMapping(value = "/room/del", method = RequestMethod.POST)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功", response = ResultEntity.class) })
	@ResponseBody
	public ResultEntity delMeetingRoom(@RequestParam String appId,@RequestParam String appSecret,@RequestParam String roomId){
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
	 * 修改会议室
	 * @param appId
	 * @param appSecret
	 * @param meetingRoom
	 * @return
	 */
	@ApiOperation(value = "修改会议室", httpMethod = "POST", notes = "修改会议室")
	@RequestMapping(value = "/room/update", method = RequestMethod.POST)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功", response = ResultEntity.class) })
	@ResponseBody
	public ResultEntity updateMeetingRoom(@RequestParam String appId,@RequestParam String appSecret,@ModelAttribute MeetingRoom meetingRoom,@ModelAttribute List<String> aliases){
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
	 * 会议室列表
	 * @param appId
	 * @param appSecret
	 * @return
	 */
	@ApiOperation(value = "会议室列表", httpMethod = "GET", notes = "会议室列表")
	@RequestMapping(value = "/room/list", method = RequestMethod.GET)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功", response = ResultEntity.class) })
	@ResponseBody
	public ResultMes<List<Conference>> roomList(@RequestParam String appId,@RequestParam String appSecret){
		ResultMes<List<Conference>> entity = new ResultMes<List<Conference>>();
		try {
			entity.setCode(HttpCodeMes.SUCCESS_CODE);
			entity.setMsg(HttpCodeMes.SUCCESS_MES);
			List<Conference> list = new ArrayList<>();
			for (int i = 0; i < 10; i++) {
				Conference conference = new Conference();
				conference.setId(Long.valueOf(i));
				conference.setStartTime(new Date());
				conference.setEndTime(new Date());
				conference.setAccountId(1L);
				conference.setType("SFU");
				conference.setHostPassword("会议管理者密码");
				list.add(conference);
			}
			entity.setData(list);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}









}
