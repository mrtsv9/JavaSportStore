package com.sport_store.bll.services.abstractions;

import com.sport_store.bll.models.user_service.GetUser;
import com.sport_store.dal.entities.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<GetUser> getAll();
    Optional<UserEntity> findByLogin(String login);
}
