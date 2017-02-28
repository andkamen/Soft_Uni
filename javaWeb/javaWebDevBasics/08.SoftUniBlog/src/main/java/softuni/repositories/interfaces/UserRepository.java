package softuni.repositories.interfaces;

import softuni.entities.User;

public interface UserRepository {

    User getUserById(Long id);

    User getUserByEmail(String email);

    User getUserByEmailAndPassword(String email, String password);

    void persist(User user);

    boolean exists(String email);
}
