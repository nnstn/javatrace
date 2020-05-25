package com.sitech.aicp.mapper;

import com.sitech.aicp.bean.query.TaskPageQuery;
import com.sitech.aicp.pojo.Task;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.SelectProvider;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TaskMapper extends Mapper<Task> {

//    @Select("select * from task where task_name like CONCAT('%',#{key},'%')")
//    List<Task> getAllTask(PageQuery pageQuery);

    @SelectProvider(type = DynamicTaskProvider.class, method = "getAllTaskByCondition")
    List<Task> getAllTask(TaskPageQuery pageQuery);

    class DynamicTaskProvider{
        public String getAllTaskByCondition(TaskPageQuery pageQuery){
            StringBuilder sqlBuilder = new StringBuilder();
            sqlBuilder.append("select * from task where 1=1");
            if(StringUtils.isNoneBlank(pageQuery.getTaskName())){ //任务模糊搜索
                sqlBuilder.append(" and  task_name like CONCAT('%','"+pageQuery.getTaskName()+"','%')");
            }
            if(StringUtils.isNoneBlank(pageQuery.getTasker())){ //按任务所有者搜索
                sqlBuilder.append(" and  tasker ='"+pageQuery.getTasker().trim()+"'");
            }
            if(StringUtils.isNoneBlank(pageQuery.getState())){ //按任务任务状态
                sqlBuilder.append(" and  state ='"+pageQuery.getState().trim()+"'");
            }
            return sqlBuilder.toString();
        }
    }

}
