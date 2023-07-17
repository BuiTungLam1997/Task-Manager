package com.example.task.manager.service;

import com.example.task.manager.dto.TaskDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ITaskService {
    List<TaskDTO> findAll();
    List<TaskDTO> findAll(Pageable pageable);
    List<TaskDTO> findAllTaskReady(Pageable pageable);
    List<TaskDTO> findAllTaskWorking(Pageable pageable);
    List<TaskDTO> findAllTaskDone(Pageable pageable);
    TaskDTO save(TaskDTO taskDTO);
    TaskDTO update(TaskDTO taskDTO);
    void delete(Long[] ids);
}
