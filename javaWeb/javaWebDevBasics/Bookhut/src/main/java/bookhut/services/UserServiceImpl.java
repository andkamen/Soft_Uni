package bookhut.services;

import bookhut.entities.User;
import bookhut.models.bindingModels.LoginModel;
import bookhut.repositories.UserRepositoryImpl;
import bookhut.repositories.interfaces.UserRepository;
import bookhut.services.interfaces.UserService;
import org.modelmapper.ModelMapper;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private ModelMapper modelMapper;


    public UserServiceImpl() {
        this.userRepository = UserRepositoryImpl.getInstance();
        this.modelMapper = new ModelMapper();
    }

    @Override
    public void createUser(LoginModel loginModel) {
        User newUser = this.modelMapper.map(loginModel, User.class);
        this.userRepository.createUser(newUser);
    }

    @Override
    public LoginModel findByUsernameAndPassword(String username, String password) {
        User user = this.userRepository.findByUsernameAndPassword(username, password);
        LoginModel loginModel = null;
        if (user != null) {
            loginModel = this.modelMapper.map(user, LoginModel.class);
        }
        return loginModel;
    }
}
