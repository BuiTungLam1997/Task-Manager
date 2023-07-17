package com.example.task.manager.repository;

import com.example.task.manager.entity.UserGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserGroupRepository extends JpaRepository<UserGroupEntity,Long> {
}
