package com.example.task.manager.service;

import com.example.task.manager.dto.GroupDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IGroupService {
    List<GroupDTO> findAll();
    List<GroupDTO> findAll(Pageable pageable);
    GroupDTO save(GroupDTO groupDTO);
    GroupDTO update(GroupDTO groupDTO);
    void delete(Long[] ids);
}
