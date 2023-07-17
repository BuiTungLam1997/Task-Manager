package com.example.task.manager.service.impl;

import com.example.task.manager.dto.PermissionDTO;
import com.example.task.manager.entity.PermissionEntity;
import com.example.task.manager.repository.PermissionRepository;
import com.example.task.manager.service.IPermissionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PermissionService implements IPermissionService {
    ModelMapper mapper = new ModelMapper();
    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public List<PermissionDTO> findAll() {
        List<PermissionDTO> result = new ArrayList<>();
        List<PermissionEntity> permission = permissionRepository.findAll();
        for (PermissionEntity item : permission) {
            result.add(mapper.map(item, PermissionDTO.class));
        }
        return result;
    }

    @Override
    public PermissionDTO save(PermissionDTO permissionDTO) {
        permissionRepository.save(mapper.map(permissionDTO, PermissionEntity.class));
        return mapper.map(permissionRepository.findById(permissionDTO.getId()), PermissionDTO.class);
    }

    @Override
    public PermissionDTO update(PermissionDTO permissionDTO) {
        permissionRepository.save(mapper.map(permissionDTO, PermissionEntity.class));
        return mapper.map(permissionRepository.findById(permissionDTO.getId()), PermissionDTO.class);
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id: ids) {
            permissionRepository.deleteById(id);
        }
    }
}
