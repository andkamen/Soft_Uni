package com.javaWebExam.services;


import com.javaWebExam.Utils.ModelParser;
import com.javaWebExam.entities.user.Role;
import com.javaWebExam.entities.user.User;
import com.javaWebExam.models.bindingModels.LogInModel;
import com.javaWebExam.models.bindingModels.RegisterUserModel;
import com.javaWebExam.repositories.interfaces.UserRepository;
import com.javaWebExam.services.interfaces.UserService;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless

public class UserServiceImpl implements UserService {

    @Inject
    private UserRepository userRepository;

    @Inject
    private ModelParser modelParser;

    @Override
    public void registerUser(RegisterUserModel registerUserModel) {
        User user = this.modelParser.getModelMapper().map(registerUserModel, User.class);

        int userCount = this.userRepository.getUsersCount();
        Role defaultRole = Role.USER;
        if (userCount == 0) {
            defaultRole = Role.ADMIN;
        }
        user.setRole(defaultRole);
        this.userRepository.persist(user);
    }

    @Override
    public void saveUser(User user) {
        this.userRepository.save(user);
    }

    @Override
    public User findRegisteredUser(LogInModel logInModel) {
        User user = this.userRepository.findByEmailAndPassword(logInModel.getEmail(), logInModel.getPassword());
        return user;
    }

    @Override
    public User findByEmail(String email) {
        User user = this.userRepository.findByEmail(email);
        return user;
    }


}
