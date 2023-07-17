package com.example.task.manager.service;

import com.example.task.manager.dto.UserGroupDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserGroupService {
    List<UserGroupDTO> findAll();
    List<UserGroupDTO> findAll(Pageable pageable);
    UserGroupDTO save(UserGroupDTO userGroupDTO);
    UserGroupDTO update(UserGroupDTO userGroupDTO);
    void delete (Long[] ids);


}
