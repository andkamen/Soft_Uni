package com.javaWebExam.repositories;


import com.javaWebExam.entities.user.User;
import com.javaWebExam.repositories.interfaces.UserRepository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless

public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void persist(User user) {
        this.entityManager.persist(user);
    }

    @Override
    public int getUsersCount() {
        Query query = this.entityManager.createQuery("SELECT u From User AS u");

        List<User> users = query.getResultList();

        return users.size();
    }

    @Override
    public void save(User user) {
        this.entityManager.merge(user);
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        Query query = this.entityManager.createQuery(
                "SELECT u FROM User AS u " +
                        "WHERE u.email =:email " +
                        "AND u.password = :password");
        query.setParameter("email", email);
        query.setParameter("password", password);
        List<User> users = query.getResultList();
        User user = null;
        if (!users.isEmpty()) {
            user = users.stream().findFirst().get();
        }

        return user;
    }

    @Override
    public User findByEmail(String email) {
        Query query = this.entityManager.createQuery(
                "SELECT u FROM User AS u " +
                        "WHERE u.email =:email");
        query.setParameter("email", email);
        List<User> users = query.getResultList();
        User user = null;
        if (!users.isEmpty()) {
            user = users.stream().findFirst().get();
        }

        return user;
    }

}
