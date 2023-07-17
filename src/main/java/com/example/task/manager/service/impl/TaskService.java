package com.example.task.manager.service.impl;

import com.example.task.manager.dto.TaskDTO;
import com.example.task.manager.entity.TaskEntity;
import com.example.task.manager.repository.TaskRepository;
import com.example.task.manager.service.ITaskService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService implements ITaskService {
    private ModelMapper mapper = new ModelMapper();
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<TaskDTO> findAll() {
        List<TaskDTO> result = new ArrayList<>();
        List<TaskEntity> taskEntities = taskRepository.findAll();
        for (TaskEntity item : taskEntities) {
            result.add(mapper.map(item, TaskDTO.class));
        }
        return result;
    }

    @Override
    public List<TaskDTO> findAll(Pageable pageable) {
        List<TaskDTO> result = new ArrayList<>();
        List<TaskEntity> taskEntities = taskRepository.findAll(pageable).getContent();
        for (TaskEntity item : taskEntities) {
            result.add(mapper.map(item, TaskDTO.class));
        }
        return result;
    }

    @Override
    public List<TaskDTO> findAllTaskReady(Pageable pageable) {
        String status = "ready";
        return findByStatus(status, pageable);
    }

    @Override
    public List<TaskDTO> findAllTaskWorking(Pageable pageable) {
        String status = "working";
        return findByStatus(status, pageable);
    }

    @Override
    public List<TaskDTO> findAllTaskDone(Pageable pageable) {
        String status = "done";
        return findByStatus(status, pageable);
    }

    @Override
    public TaskDTO save(TaskDTO taskDTO) {
        taskDTO.setCreatedBy("Call from postman");
        TaskEntity taskEntity = mapper.map(taskDTO, TaskEntity.class);
        taskRepository.save(taskEntity);
        return mapper.map(taskRepository.findById(taskEntity.getId()), TaskDTO.class);
    }

    @Override
    public TaskDTO update(TaskDTO taskDTO) {
        Optional<TaskEntity> old = taskRepository.findById(taskDTO.getId());
        taskDTO.setCreatedBy(old.get().getCreatedBy());
        TaskEntity taskEntity = mapper.map(taskDTO, TaskEntity.class);
        taskEntity = taskRepository.save(taskEntity);
        return mapper.map(taskRepository.findById(taskEntity.getId()), TaskDTO.class);
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {
            taskRepository.deleteById(id);
        }
    }

    private List<TaskDTO> findByStatus(String status, Pageable pageable) {
        List<TaskDTO> result = new ArrayList<>();
        List<TaskEntity> taskEntities = taskRepository.findByStatus(status, pageable);
        for (TaskEntity item : taskEntities) {
            result.add(mapper.map(item, TaskDTO.class));
        }
        return result;
    }
}
