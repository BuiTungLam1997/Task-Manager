package com.example.task.manager.service;

import com.example.task.manager.dto.UserDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserService {
    List<UserDTO> findAll();
    List<UserDTO> findAll(Pageable pageable);
    List<UserDTO> findAllActive(Pageable pageable);
    UserDTO save(UserDTO userDTO);
    UserDTO update(UserDTO userDTO,Long id);
    void delete(Long[] ids);
}
