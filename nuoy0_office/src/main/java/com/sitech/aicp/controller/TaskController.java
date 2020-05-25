package com.sitech.aicp.controller;

import com.sitech.aicp.bean.JsonData;
import com.sitech.aicp.bean.PageResult;
import com.sitech.aicp.bean.query.TaskPageQuery;
import com.sitech.aicp.pojo.Task;
import com.sitech.aicp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("task")
public class TaskController {
    @Autowired
    TaskService TaskService;

    @PostMapping("getall")
    public JsonData getAllTask(@RequestBody TaskPageQuery pageQuery) {
        PageResult<Task> pageResult = TaskService.getAllTask(pageQuery);
        return JsonData.success(pageResult);
    }

    @PostMapping("insert")
    public JsonData insertTask(@RequestBody Task task) {
        TaskService.insertTask(task);
        return JsonData.success("添加成功");
    }

    @PostMapping("update")
    public JsonData updateTask(@RequestBody Task task) {
        TaskService.updateTask(task);
        return JsonData.success("更新成功");
    }

    @PostMapping("delete/{id}")
    public JsonData deleteTask(@PathVariable("id") Long taskId) {
        TaskService.deleteTask(taskId);
        return JsonData.success("删除成功");
    }
}
