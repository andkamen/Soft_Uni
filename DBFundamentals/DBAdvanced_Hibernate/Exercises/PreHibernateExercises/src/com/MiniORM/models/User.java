package com.MiniORM.models;


import com.MiniORM.persistance.Column;
import com.MiniORM.persistance.Entity;
import com.MiniORM.persistance.Id;

import java.util.Date;

@Entity(name = "users")
public class User {

    @Id
    private long id;

    @Column(name = "password")
    private String password;

    @Column(name = "age")
    private int age;

    @Column(name = "registration_date")
    private Date registrationDate;

    @SuppressWarnings("unused")
    public User() {
        super();
    }

    public User(String name, int age, Date registrationDate) {
        this.setPassword(name);
        this.setAge(age);
        this.setRegistrationDate(registrationDate);
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String name) {
        this.password = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getRegistrationDate() {
        return this.registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
}
