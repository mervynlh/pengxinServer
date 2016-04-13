package com.drpeng.pengxin.api.controller;

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
     * @return
     */
    @RequestMapping(value = "/info",method = RequestMethod.GET)
    @ApiOperation(value = "会议信息接口",httpMethod = "POST",notes = "会议信息，包含统计信息")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "成功", response = ResultEntity.class) })
    @ResponseBody
    public ResultMes reportInfo(@ApiParam(required = true, name = "token", value = "用户token")@RequestParam String token){
        ResultMes entity =new ResultMes();
        try {
            entity.setCode(HttpCodeMes.SUCCESS_CODE);
            entity.setMsg(HttpCodeMes.SUCCESS_MES);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entity;
    }
}
