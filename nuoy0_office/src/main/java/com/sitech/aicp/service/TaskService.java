package com.sitech.aicp.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sitech.aicp.bean.PageResult;
import com.sitech.aicp.bean.query.TaskPageQuery;
import com.sitech.aicp.mapper.TaskMapper;
import com.sitech.aicp.pojo.Task;
import com.sitech.aicp.pojo.User;
import com.sitech.aicp.web.handler.RequestHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Service
public class TaskService {

    @Resource
    TaskMapper taskMapper;

    /**
     * 分页查询
     */
    public PageResult<Task> getAllTask(TaskPageQuery pageQuery){
        // 分页
        PageHelper.startPage(pageQuery.getPageNo(), pageQuery.getPageSize(),pageQuery.getSortBy()+(pageQuery.getDesc() ? " DESC" : " ASC"));
        // 查询
        List<Task> tasks = taskMapper.getAllTask(pageQuery);

        PageInfo<Task> info = new PageInfo<>(tasks);
        // 解析分页结果
        return new PageResult<Task>(info.getTotal(), tasks);

    }

    public int insertTask(Task task){
        User user = RequestHolder.getCurrentUser();
        HttpServletRequest request = RequestHolder.getCurrentRequest();

        if(null==task.getDispatcher()){
            task.setDispatcher(user.getUserCode());
        }
        if(null==task.getTasker()){
            task.setTasker(user.getUserCode());
        }
        if (0==task.getState()){
            task.setState(1); //任务初始状态为
        }

        task.setCreateTime(new Date());
        task.setLastUpdateTime(new Date());
        task.setOpeationIp(request.getRemoteAddr());
        return taskMapper.insert(task);
    }

    public int updateTask(Task task){
        task.setLastUpdateTime(new Date());
        return taskMapper.updateByPrimaryKey(task);
    }
    public int deleteTask(Long taskId){
        return taskMapper.deleteByPrimaryKey(taskId);
    }
}
