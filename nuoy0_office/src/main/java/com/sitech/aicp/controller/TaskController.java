package com.sitech.aicp.controller;

import com.sitech.aicp.bean.JsonData;
import com.sitech.aicp.bean.PageResult;
import com.sitech.aicp.bean.query.TaskPageQuery;
import com.sitech.aicp.pojo.Task;
import com.sitech.aicp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("task")
public class TaskController {
    @Autowired
    TaskService taskService;

    @PostMapping("getall")
    public JsonData getAllTask(@RequestBody TaskPageQuery pageQuery) {
        PageResult<Task> pageResult = taskService.getAllTask(pageQuery);
        return JsonData.success(pageResult);
    }

    @PostMapping("insert")
    public JsonData insertTask(@RequestBody Task task) {
        taskService.insertTask(task);
        return JsonData.success("添加成功");
    }

    @PostMapping("update")
    public JsonData updateTask(@RequestBody Task task) {
        taskService.updateTask(task);
        return JsonData.success("更新成功");
    }

    @PostMapping("delete/{id}")
    public JsonData deleteTask(@PathVariable("id") Long taskId) {
        taskService.deleteTask(taskId);
        return JsonData.success("删除成功");
    }
    @PostMapping("donetask")
    public JsonData doneTask(@RequestBody  List<Long> ids) {
        taskService.updateTaskStateBatch(ids,3);
        return JsonData.success("删除成功");
    }
}
