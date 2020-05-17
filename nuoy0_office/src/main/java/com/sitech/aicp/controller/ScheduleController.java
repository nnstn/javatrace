package com.sitech.aicp.controller;

import com.sitech.aicp.bean.JsonData;
import com.sitech.aicp.bean.PageQuery;
import com.sitech.aicp.bean.PageResult;
import com.sitech.aicp.pojo.Schedule;
import com.sitech.aicp.service.ScheduleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("schedule")
public class ScheduleController {
    @Autowired
    ScheduleService scheduleService;

    @ApiOperation("")
    @RequestMapping("getall")
    public JsonData getAllSchedule(PageQuery pageQuery) {
        PageResult<Schedule> pageResult = scheduleService.getAllSchedule(pageQuery);
        return JsonData.success(pageResult);
    }
}
