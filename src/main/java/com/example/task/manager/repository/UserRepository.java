package com.example.task.manager.repository;

import com.example.task.manager.entity.UserEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    Optional<UserEntity> findById(Long id);
    List<UserEntity> findByStatus(String status, Pageable pageable);
}
