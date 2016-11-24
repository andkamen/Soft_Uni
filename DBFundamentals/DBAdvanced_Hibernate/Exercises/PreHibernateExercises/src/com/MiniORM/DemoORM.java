package com.MiniORM;

import com.MiniORM.connection.DatabaseConnection;
import com.MiniORM.models.User;
import com.MiniORM.orm.EntityManager;

import java.sql.SQLException;
import java.util.Date;

public class DemoORM {
    public static void main(String[] args) {
        try {
            EntityManager em = new EntityManager(DatabaseConnection.getConnection());
            User student = new User("Ivan", 22, new Date());
            student.setId(1);
            em.persist(student);
            User student1 = new User("Ivan1", 23, new Date());
            student1.setId(2);
            em.persist(student1);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
