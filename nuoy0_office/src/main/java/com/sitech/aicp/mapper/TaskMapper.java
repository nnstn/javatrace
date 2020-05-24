package com.sitech.aicp.mapper;

import com.sitech.aicp.pojo.Task;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TaskMapper extends Mapper<Task> {

    @Select("select * from task")
    List<Task> getAllTask();


}
