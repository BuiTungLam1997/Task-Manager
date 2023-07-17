package com.example.task.manager.service;

import com.example.task.manager.dto.PermissionDTO;

import java.util.List;

public interface IPermissionService {
    List<PermissionDTO> findAll();
    PermissionDTO save(PermissionDTO permissionDTO);
    PermissionDTO update(PermissionDTO permissionDTO);
    void delete(Long[] ids);
}
