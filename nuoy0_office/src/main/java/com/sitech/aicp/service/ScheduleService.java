package com.sitech.aicp.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sitech.aicp.bean.PageQuery;
import com.sitech.aicp.bean.PageResult;
import com.sitech.aicp.mapper.SchedulerMapper;
import com.sitech.aicp.pojo.Schedule;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class ScheduleService {

    @Resource
    SchedulerMapper schedulerMapper;

    /**
     * 分页查询
     */
    public PageResult<Schedule> getAllSchedule(PageQuery pageQuery){
        // 分页
        PageHelper.startPage(pageQuery.getPageNo(), pageQuery.getPageSize(),pageQuery.getSortBy()+(pageQuery.getDesc() ? " DESC" : " ASC"));
        // 查询
        List<Schedule> schedules = schedulerMapper.getAllSchedule();

        PageInfo<Schedule> info = new PageInfo<>(schedules);
        // 解析分页结果
        return new PageResult<Schedule>(info.getTotal(), schedules);

    }

    public int insertSchedule(Schedule schedule){
        schedule.setCreateTime(new Date());
        schedule.setLastUpdateTime(new Date());
        return schedulerMapper.insert(schedule);
    }

    public int updateSchedule(Schedule schedule){
        schedule.setLastUpdateTime(new Date());
        return schedulerMapper.updateByPrimaryKey(schedule);
    }
}
