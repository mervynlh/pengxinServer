package com.drpeng.pengxin.api.controller;

import com.drpeng.pengxin.api.domain.Conference;
import com.drpeng.pengxin.common.BaseController;
import com.drpeng.pengxin.api.domain.ResultEntity;
import com.drpeng.pengxin.api.domain.ResultMes;
import com.drpeng.pengxin.api.util.HttpCodeMes;
import com.wordnik.swagger.annotations.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by huan.liu on 2016/4/12.
 */
@Api(value = "report management",description = "会务相关信息接口",basePath = "/v1/report")
@Controller
@RequestMapping("/v1/report")
public class ReportController extends BaseController {
    /**
     * 会议信息接口
     * @param token
     * @param conferenceId
     * @return
     */
    @RequestMapping(value = "/info",method = RequestMethod.GET)
    @ApiOperation(value = "会议信息接口",httpMethod = "GET",notes = "会议信息，包含统计信息")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "成功", response = ResultEntity.class) })
    @ResponseBody
    public ResultMes reportInfo(@RequestParam String token,@RequestParam Long conferenceId){
        ResultMes<Conference> entity =new ResultMes<Conference>();
        try {
            entity.setCode(HttpCodeMes.SUCCESS_CODE);
            entity.setMsg(HttpCodeMes.SUCCESS_MES);
            Conference conference = new Conference();
            conference.setId(conferenceId);
            conference.setName("会议名称");
            conference.setStartTime(new Date());
            conference.setEndTime(new Date());
            conference.setType("MCU");
            conference.setDownloadURL("http:www.xxxx.com");
            conference.setNumber(100);
            entity.setData(conference);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entity;
    }
}
