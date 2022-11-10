package com.sport_store.bll.repositories.abstractions;

import com.sport_store.dal.entities.UserEntity;
import com.sport_store.dal.entities.UserTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserTypeRepository extends JpaRepository<UserTypeEntity, Integer> {
}
