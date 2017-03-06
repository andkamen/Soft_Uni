package com.javaWebExam.services.interfaces;

import com.javaWebExam.entities.user.User;
import com.javaWebExam.models.bindingModels.LogInModel;
import com.javaWebExam.models.bindingModels.RegisterUserModel;

import javax.transaction.Transactional;

public interface UserService {

    void registerUser(RegisterUserModel registerUserModel);

    void saveUser(User user);

    User findRegisteredUser(LogInModel logInModel);

    User findByEmail(String email);

}
