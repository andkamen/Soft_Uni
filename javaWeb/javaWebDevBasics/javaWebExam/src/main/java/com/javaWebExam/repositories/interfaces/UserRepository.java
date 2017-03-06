package com.javaWebExam.repositories.interfaces;

import com.javaWebExam.entities.user.User;

import javax.transaction.Transactional;

public interface UserRepository {

    void persist(User user);

    int getUsersCount();

    void save(User user);

    User findByEmailAndPassword(String email, String password);

    User findByEmail(String email);
}
