package com.example.task.manager.service.impl;

import com.example.task.manager.dto.UserGroupDTO;
import com.example.task.manager.entity.UserGroupEntity;
import com.example.task.manager.repository.UserGroupRepository;
import com.example.task.manager.service.IUserGroupService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserGroupService implements IUserGroupService {
    ModelMapper mapper = new ModelMapper();
    @Autowired
    private UserGroupRepository userGroupRepository;

    @Override
    public List<UserGroupDTO> findAll() {
        List<UserGroupDTO> result = new ArrayList<>();
        List<UserGroupEntity> userGroupEntities = userGroupRepository.findAll();
        for (UserGroupEntity item: userGroupEntities
             ) {
            result.add(mapper.map(item,UserGroupDTO.class));
        }
        return result;
    }

    @Override
    public List<UserGroupDTO> findAll(Pageable pageable) {
        List<UserGroupDTO> result = new ArrayList<>();
        List<UserGroupEntity> userGroupEntities = userGroupRepository.findAll(pageable).getContent();
        for (UserGroupEntity item: userGroupEntities
        ) {
            result.add(mapper.map(item,UserGroupDTO.class));
        }
        return result;
    }

    @Override
    public UserGroupDTO save(UserGroupDTO userGroupDTO) {
        userGroupRepository.save(mapper.map(userGroupDTO,UserGroupEntity.class));
        return mapper.map(userGroupRepository.findById(userGroupDTO.getId()),UserGroupDTO.class);
    }

    @Override
    public UserGroupDTO update(UserGroupDTO userGroupDTO) {
        userGroupRepository.save(mapper.map(userGroupDTO,UserGroupEntity.class));
        return mapper.map(userGroupRepository.findById(userGroupDTO.getId()),UserGroupDTO.class);
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id: ids
             ) {
            userGroupRepository.deleteById(id);
        }
    }
}
