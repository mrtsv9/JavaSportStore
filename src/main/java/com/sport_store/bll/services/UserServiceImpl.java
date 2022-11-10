package com.sport_store.bll.services;

import com.sport_store.bll.models.user_service.GetUser;
import com.sport_store.bll.models.user_service.UserTypeForGetUser;
import com.sport_store.bll.repositories.abstractions.UserRepository;
import com.sport_store.bll.repositories.abstractions.UserTypeRepository;
import com.sport_store.bll.services.abstractions.UserService;
import com.sport_store.dal.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserTypeRepository userTypeRepository;

    @Override
    public List<GetUser> getAll() {
        var users = userRepository.findAll();

        var getUserList = new ArrayList<GetUser>();

        for (UserEntity user : users) {
            var newUser = new GetUser();
            newUser.setId(user.getId());
            newUser.setFirstName(user.getFirstName());
            newUser.setLastName(user.getLastName());
            newUser.setLogin(user.getLogin());
            newUser.setPassword(user.getPassword());

            var userType = new UserTypeForGetUser();
            var userTypeExist = userTypeRepository.findById(user.getUserType().getId());
            if (userTypeExist.isEmpty()) throw new IllegalArgumentException();
            userType.setId(userTypeExist.get().getId());
            userType.setType(userTypeExist.get().getType());

            newUser.setUserType(userType);
            getUserList.add(newUser);
        }

        return getUserList;
    }

    @Override
    public Optional<UserEntity> findByLogin(String login) {
        return userRepository.findByLogin(login);
    }
}













