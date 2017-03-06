package com.javaWebExam.models.bindingModels;

import javax.validation.constraints.Pattern;

public class RegisterUserModel {

    @Pattern(regexp = "^[a-zA-Z -.]+$",message = "Invalid name.")
    private String fullName;

    @Pattern(regexp = "^.+@.+\\..+$",message = "The email must contain '@' and '.'")
    private String email;

    @Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,}", message = "The password length must be at least 6 symbols and must contain at least 1 uppercase, 1 lowercase letter and 1 digit")
    private String password;

    private String confirmPassword;

    public RegisterUserModel() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
