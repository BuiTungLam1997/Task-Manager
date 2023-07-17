package com.example.task.manager.service.impl;

import com.example.task.manager.dto.GroupDTO;
import com.example.task.manager.entity.GroupEntity;
import com.example.task.manager.repository.GroupRepository;
import com.example.task.manager.service.IGroupService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupService implements IGroupService {
    ModelMapper mapper = new ModelMapper();
    @Autowired
    private GroupRepository groupRepository;

    @Override
    public List<GroupDTO> findAll() {
        List<GroupDTO> result = new ArrayList<>();
        List<GroupEntity> groupPermission = groupRepository.findAll();
        for (GroupEntity item : groupPermission) {
            result.add(mapper.map(item, GroupDTO.class));
        }
        return result;
    }

    @Override
    public List<GroupDTO> findAll(Pageable pageable) {
        List<GroupDTO> result = new ArrayList<>();
        List<GroupEntity> groupPermission = groupRepository.findAll(pageable).getContent();
        for (GroupEntity item : groupPermission) {
            result.add(mapper.map(item, GroupDTO.class));
        }
        return result;
    }

    @Override
    public GroupDTO save(GroupDTO groupDTO) {
        groupRepository.save(mapper.map(groupDTO, GroupEntity.class));
        return mapper.map(groupRepository.findById(groupDTO.getId()), GroupDTO.class);
    }

    @Override
    public GroupDTO update(GroupDTO groupDTO) {
        groupRepository.save(mapper.map(groupDTO, GroupEntity.class));
        return mapper.map(groupRepository.findById(groupDTO.getId()), GroupDTO.class);
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id:ids) {
            groupRepository.deleteById(id);
        }
    }
}
