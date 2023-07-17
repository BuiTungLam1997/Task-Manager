package com.example.task.manager.service.impl;

import com.example.task.manager.dto.UserDTO;
import com.example.task.manager.entity.UserEntity;
import com.example.task.manager.repository.UserRepository;
import com.example.task.manager.service.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    private ModelMapper mapper = new ModelMapper();
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDTO> findAll() {
        List<UserDTO> result = new ArrayList<>();
        try {
            List<UserEntity> userEntities = new ArrayList<>();
            userEntities = userRepository.findAll();
            for (UserEntity item : userEntities) {
                result.add(mapper.map(item, UserDTO.class));
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        return result;
    }

    @Override
    public List<UserDTO> findAll(Pageable pageable) {
        List<UserDTO> result = new ArrayList<>();
        try {
            List<UserEntity> userEntities = new ArrayList<>();
            userEntities = userRepository.findAll(pageable).getContent();
            for (UserEntity item : userEntities) {
                result.add(mapper.map(item, UserDTO.class));
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return result;
    }

    @Override
    public List<UserDTO> findAllActive(Pageable pageable) {
        String active = "is active";
        List<UserDTO> result = new ArrayList<>();
        try {
            List<UserEntity> userEntities = new ArrayList<>();
            userEntities = userRepository.findByStatus(active,pageable);
            for (UserEntity item : userEntities) {
                result.add(mapper.map(item, UserDTO.class));
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return result;
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        if (getFullName(userDTO) == null) {
            userDTO.setCreatedBy("Call from postman");
        }
        userDTO.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        UserEntity userEntity = mapper.map(userDTO, UserEntity.class);
        userRepository.save(userEntity);
        return mapper.map(userRepository.findById(userEntity.getId()), UserDTO.class);
    }

    @Override
    public UserDTO update(UserDTO userDTO, Long id) {
        Optional<UserEntity> oldUser = userRepository.findById(id);
        userDTO.setCreatedBy(oldUser.get().getCreatedBy());
        userDTO.setCreatedDate(oldUser.get().getCreatedDate());
        userRepository.save(mapper.map(userDTO, UserEntity.class));
        return mapper.map(userRepository.findById(id), UserDTO.class);
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {
            Optional<UserEntity> delete = userRepository.findById(id);
            if (delete == null) {
                continue;
            }
            delete.get().setStatus("not active");
            userRepository.save(mapper.map(delete, UserEntity.class));
        }
    }

    private String getFullName(UserDTO userDTO) {
        return null;
    }
}
