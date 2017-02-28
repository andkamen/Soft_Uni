package softuni.services;

import softuni.Utils.ModelParser;
import softuni.entities.User;
import softuni.models.bindingModels.RegisterModel;
import softuni.models.viewModels.LoggedUserDataModel;
import softuni.repositories.interfaces.UserRepository;
import softuni.services.interfaces.UserService;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
@Local(UserService.class)
public class UserServiceImpl implements UserService {

    @Inject
    private UserRepository userRepository;

    @Inject
    private ModelParser modelParser;

    @Override
    public LoggedUserDataModel get(Long id) {
        User user = this.userRepository.getUserById(id);
        LoggedUserDataModel loggedUser = null;
        if (user != null) {
            loggedUser = modelParser.getModelMapper().map(user, LoggedUserDataModel.class);
        }
        return loggedUser;
    }

    @Override
    public LoggedUserDataModel get(String email) {
        User user = this.userRepository.getUserByEmail(email);
        LoggedUserDataModel loggedUser = null;
        if (user != null) {
            loggedUser = modelParser.getModelMapper().map(user, LoggedUserDataModel.class);
        }
        return loggedUser;
    }

    @Override
    public LoggedUserDataModel getByEmailAndPassword(String email, String password) {
        User user = this.userRepository.getUserByEmailAndPassword(email, password);
        LoggedUserDataModel loggedUser = null;
        if (user != null) {
            loggedUser = modelParser.getModelMapper().map(user, LoggedUserDataModel.class);
        }
        return loggedUser;
    }

    @Override
    public void persist(RegisterModel registerModel) {
        User newUser = modelParser.getModelMapper().map(registerModel, User.class);
        this.userRepository.persist(newUser);
    }

    @Override
    public boolean exists(String email) {

        return this.userRepository.exists(email);
    }
}
