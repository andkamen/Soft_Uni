package com.javaWebExam.controllers;

import com.javaWebExam.Utils.DataValidator;
import com.javaWebExam.entities.user.User;
import com.javaWebExam.models.bindingModels.LogInModel;
import com.javaWebExam.models.bindingModels.RegisterUserModel;
import com.javaWebExam.services.interfaces.UserService;
import com.mvcFramework.annotations.controller.Controller;
import com.mvcFramework.annotations.parameters.ModelAttribute;
import com.mvcFramework.annotations.request.GetMapping;
import com.mvcFramework.annotations.request.PostMapping;
import com.mvcFramework.models.Model;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.util.LinkedHashSet;
import java.util.Set;

@Stateless
@Controller
public class UserController {

    @Inject
    private UserService userService;

    @GetMapping("/register")
    public String getRegisterView(Model model) {
        model.addAttribute("title", "Register");
        model.addAttribute("view", "templates/register.jsp");

        return "WEB-INF/base-layout";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute RegisterUserModel registerUserModel, Model model) {
        Set<String> errors = DataValidator.validateData(registerUserModel);

        if (!registerUserModel.getPassword().equals(registerUserModel.getConfirmPassword())) {
            errors.add("Password mismatch");
        }

        User foundUser = this.userService.findByEmail(registerUserModel.getEmail());
        if(foundUser!=null){
            errors.add("An account is already registered with this email");
        }

        if (errors.size() > 0) {
            model.addAttribute("title", "Register");
            model.addAttribute("view", "templates/register.jsp");
            model.addAttribute("errors", errors);
            return "/WEB-INF/base-layout";
        } else {
            this.userService.registerUser(registerUserModel);
            return "redirect:/login";
        }
    }


    @GetMapping("/login")
    public String getLoginView(Model model) {

        model.addAttribute("title", "Login");
        model.addAttribute("view", "templates/login.jsp");

        return "WEB-INF/base-layout";
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute LogInModel logInModel, Model model, HttpSession session) {
        User user = this.userService.findRegisteredUser(logInModel);
        Set<String> errors = new LinkedHashSet<>();

        if (user == null) {
            errors.add("Invalid login credentials");

            model.addAttribute("errors", errors);
            model.addAttribute("title", "Login");
            model.addAttribute("view", "templates/login.jsp");

            return "WEB-INF/base-layout";
        }

        session.setAttribute("currentUser", user);

        return "redirect:/";

    }

    @GetMapping("/logout")
    public String logoutUser(HttpSession session) {
        session.invalidate();

        return "redirect:/";
    }
}
