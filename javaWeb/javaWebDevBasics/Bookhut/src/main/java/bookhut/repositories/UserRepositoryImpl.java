package bookhut.repositories;

import bookhut.entities.User;
import bookhut.repositories.interfaces.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    private static UserRepositoryImpl userRepository;

    private List<User> users;

    private UserRepositoryImpl() {
        this.users = new ArrayList<>();
    }

    public static UserRepositoryImpl getInstance() {
        if (userRepository == null) {
            userRepository = new UserRepositoryImpl();
        }
        return userRepository;
    }


    @Override
    public void createUser(User user) {
        this.users.add(user);
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        User foundUser = null;

        for (User user : users) {
            if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
                foundUser = user;
            }
        }

        return foundUser;
    }
}
