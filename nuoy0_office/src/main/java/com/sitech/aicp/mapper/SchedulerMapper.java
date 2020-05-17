package com.sitech.aicp.mapper;

import com.sitech.aicp.pojo.Schedule;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SchedulerMapper extends Mapper<Schedule> {

    @Select("select * from schedule")
    List<Schedule> getAllSchedule();


}
