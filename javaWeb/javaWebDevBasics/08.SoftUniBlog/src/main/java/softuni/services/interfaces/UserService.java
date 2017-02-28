package softuni.services.interfaces;

import softuni.models.bindingModels.RegisterModel;
import softuni.models.viewModels.LoggedUserDataModel;

public interface UserService {

    LoggedUserDataModel get(Long id);

    LoggedUserDataModel get(String email);

    LoggedUserDataModel getByEmailAndPassword(String email, String password);

    void persist(RegisterModel registerModel);

    boolean exists(String email);

}
