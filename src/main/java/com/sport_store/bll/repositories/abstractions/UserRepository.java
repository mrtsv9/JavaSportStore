package com.sport_store.bll.repositories.abstractions;

import com.sport_store.dal.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
        Optional<UserEntity> findByLogin(String login);
}
