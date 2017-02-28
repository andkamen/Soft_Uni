package softuni.repositories;

import softuni.entities.User;
import softuni.repositories.interfaces.UserRepository;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
@Local(UserRepository.class)
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User getUserById(Long id) {
        Query query = this.entityManager.createQuery("SELECT u FROM User AS u WHERE u.id = :id");
        query.setParameter("id", id);
        List<User> users = query.getResultList();

        return users.isEmpty()?null:users.get(0);
    }

    @Override
    public User getUserByEmail(String email) {
        Query query = this.entityManager.createQuery("SELECT u FROM User AS u WHERE u.email = :email");
        query.setParameter("email", email);
        List<User> users = query.getResultList();

        return users.isEmpty()?null:users.get(0);
    }

    @Override
    public User getUserByEmailAndPassword(String email, String password) {

        Query query = this.entityManager.createQuery("SELECT u FROM User AS u WHERE u.email = :email AND u.password = :password");

        query.setParameter("email",email);
        query.setParameter("password", password);

        List<User> users = query.getResultList();

        return users.isEmpty()?null:users.get(0);
    }

    @Override
    public void persist(User user) {
        entityManager.persist(user);
    }

    @Override
    public boolean exists(String email) {
        User user = this.getUserByEmail(email);

        return user != null;
    }
}
