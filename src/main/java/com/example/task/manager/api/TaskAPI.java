package com.example.task.manager.api;

import com.example.task.manager.Output.ResponseList;
import com.example.task.manager.dto.TaskDTO;
import com.example.task.manager.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/manager/api/task")
public class TaskAPI {
    @Autowired
    private ITaskService taskService;

    @GetMapping
    public ResponseList<TaskDTO> findAll() {
        ResponseList result = new ResponseList();
        result.setStatus("OK");
        result.setMessage("Find all success");
        result.setData(taskService.findAll());
        return result;
    }

    @PostMapping
    public TaskDTO insertTask(@RequestBody TaskDTO taskDTO) {
        return taskService.save(taskDTO);

    }
    @PutMapping (value = "/{id}")
    public TaskDTO updateTask(@RequestBody TaskDTO taskDTO,@PathVariable("id") Long id){
        taskDTO.setId(id);
        return taskService.update(taskDTO);
    }
}
