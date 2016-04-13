package api.pengxin.web.controller;

import api.pengxin.common.BaseController;
import api.pengxin.domain.AccountUser;
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


/**
 * meeting room interface
 * @author  huan.liu
 */
@Api(value = "meeting room ", description = "meeting room相关接口")
@Controller
@RequestMapping("/v1/room")
public class MeetingRoomController extends BaseController {


	/**
	 * 创建meeting room
	 * @param token
	 * @return
	 */
	@ApiOperation(value = "创建会议室", httpMethod = "POST", notes = "创建会议室。")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功", response = ResultMes.class) })
	@ResponseBody
	public ResultMes addMeetingRoom(@RequestParam String token){
		ResultMes<MeetingRoom> entity = new ResultMes<MeetingRoom>();
		try {
			entity.setCode(HttpCodeMes.SUCCESS_CODE);
			entity.setMsg(HttpCodeMes.SUCCESS_MES);
			MeetingRoom meetingRoom = new MeetingRoom();
			meetingRoom.setId(1l);
			meetingRoom.setAccountId(1l);
			meetingRoom.setAlias("别名");
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
	 * @param token
	 * @param roomId
	 * @return
	 */
	@ApiOperation(value = "删除会议室", httpMethod = "POST", notes = "删除某个会议室")
	@RequestMapping(value = "/del", method = RequestMethod.POST)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功", response = ResultEntity.class) })
	@ResponseBody
	public ResultEntity delMeetingRoom(@RequestParam String token,@RequestParam String roomId){
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
	 * @param token
	 * @param meetingRoom
	 * @return
	 */
	@ApiOperation(value = "修改会议室", httpMethod = "POST", notes = "修改会议室")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功", response = ResultEntity.class) })
	@ResponseBody
	public ResultEntity updateMeetingRoom(@RequestParam String token,@ModelAttribute MeetingRoom meetingRoom){
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
	 * @param token
	 * @return
	 */
	@ApiOperation(value = "会议室列表", httpMethod = "GET", notes = "会议室列表")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功", response = ResultEntity.class) })
	@ResponseBody
	public ResultEntity delAccountUser(@RequestParam String token){
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
