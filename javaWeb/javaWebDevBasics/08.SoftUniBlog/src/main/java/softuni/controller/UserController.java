package softuni.controller;

import com.mvcFramework.annotations.controller.Controller;
import com.mvcFramework.annotations.parameters.ModelAttribute;
import com.mvcFramework.annotations.request.GetMapping;
import com.mvcFramework.annotations.request.PostMapping;
import com.mvcFramework.models.Model;
import softuni.Utils.Constants;
import softuni.models.bindingModels.LoginAttemptModel;
import softuni.models.bindingModels.RegisterModel;
import softuni.models.viewModels.LoggedUserDataModel;
import softuni.services.interfaces.UserService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Controller
public class UserController {

    @Inject
    private UserService userService;

    @GetMapping("/login")
    public String getLoginView(Model model, HttpSession session) {
        if (session.getAttribute(Constants.LOGGED_IN_USER) != null) {
            return "redirect:/";
        }

        model.addAttribute("title", "Login");
        model.addAttribute("view", "user/login.jsp");

        return "WEB-INF/base-layout";
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute LoginAttemptModel loginAttemptModel, Model model, HttpSession session) {
        List<String> errors = new ArrayList<>();

        String email = loginAttemptModel.getEmail();
        String password = loginAttemptModel.getPassword();

        LoggedUserDataModel loggedUser = null;

        if (email == null || password == null) {
            errors.add("A field was left empty");
        } else {
            loggedUser = this.userService.getByEmailAndPassword(email, password);
            if (loggedUser == null) {
                errors.add("Email or Password are invalid");
            }
        }

        if (errors.size() == 0) {
            session.setAttribute(Constants.LOGGED_IN_USER, loggedUser);

            return "redirect:/";
        } else {
            model.addAttribute("errors", errors);
            model.addAttribute("title", "Login");
            model.addAttribute("view", "user/login.jsp");
            return "WEB-INF/base-layout";
        }
    }

    @GetMapping("/profile")
    public String getProfileView(Model model, HttpSession session) {
        if (session.getAttribute(Constants.LOGGED_IN_USER) == null) {
            return "redirect:/";
        }

        model.addAttribute("title", "My Profile");
        model.addAttribute("view", "user/profile.jsp");

        return "WEB-INF/base-layout";
    }

    @GetMapping("/signout")
    public String signout(Model model, HttpSession session) {
        session.invalidate();

        return "redirect:/";
    }

    @GetMapping("/register")
    public String getRegisterView(Model model, HttpSession session) {
        if (session.getAttribute(Constants.LOGGED_IN_USER) != null) {
            return "redirect:/";
        }
        model.addAttribute("title", "Register");
        model.addAttribute("view", "user/register.jsp");

        return "WEB-INF/base-layout";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute RegisterModel registerModel, Model model) {
        List<String> errors = new ArrayList<>();

        validatePassword(errors, registerModel.getPassword(), registerModel.getConfirmPassword());
        validateEmail(errors, registerModel.getEmail());
        validateName(errors, registerModel.getName());

        if (errors.size() == 0) {
            this.userService.persist(registerModel);

            return "redirect:/login";
        } else {
            model.addAttribute("errors", errors);
            model.addAttribute("title", "Register");
            model.addAttribute("view", "user/register.jsp");

            return "WEB-INF/base-layout";
        }
    }

    private void validateName(List<String> errors, String name) {
        if (name == null) {
            errors.add("Name field was left empty");
        } else if (name.length() < 5 || name.length() > 50) {
            errors.add("Name must be between 5 and 50 chars");
        } else if (!name.matches("[a-zA-Z -]+")) {
            errors.add("Name must contain only english letters and '-'");
        }
    }

    private void validateEmail(List<String> errors, String email) {
        if (email == null) {
            errors.add("Email field was left empty");
        } else if (!email.contains("@") || !email.split("@")[1].contains(".")) {
            errors.add("Invalid Email type");
        } else if (this.userService.exists(email)) {
            errors.add("Email is already in use. ");
        }
    }

    private void validatePassword(List<String> errors, String password, String confirmPassword) {
        if (password == null || confirmPassword == null) {
            errors.add("Some password fields were left empty");
        } else if (!password.equals(confirmPassword)) {
            errors.add("Passwords are not matching");
        } else if (password.length() < 3 || password.length() > 30) {
            errors.add("Password must be between 3 and 30 chars");
        }
    }
}
