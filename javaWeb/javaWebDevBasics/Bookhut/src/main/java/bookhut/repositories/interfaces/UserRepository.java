package bookhut.repositories.interfaces;

import bookhut.entities.User;

public interface UserRepository {

    void createUser(User user);

    User findByUsernameAndPassword(String username, String password);

}
