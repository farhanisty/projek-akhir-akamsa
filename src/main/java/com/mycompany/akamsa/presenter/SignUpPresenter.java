/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.akamsa.presenter;

import com.mycompany.akamsa.controller.PageController;
import com.mycompany.akamsa.entity.User;
import com.mycompany.akamsa.exception.DuplicateEntryException;
import com.mycompany.akamsa.exception.RepositoryException;
import com.mycompany.akamsa.helper.PasswordHelper;
import com.mycompany.akamsa.helper.validator.FailedValidatorStatus;
import com.mycompany.akamsa.helper.validator.StringMustBeEqualsValidator;
import com.mycompany.akamsa.helper.validator.StringMustBeNotEmptyValidator;
import com.mycompany.akamsa.helper.validator.SuccessValidatorStatus;
import com.mycompany.akamsa.helper.validator.Validator;
import com.mycompany.akamsa.helper.validator.ValidatorStatus;
import com.mycompany.akamsa.repository.user.UserRepository;
import com.mycompany.akamsa.view.auth.SignUpView;

/**
 *
 * @author farhannivta
 */
public class SignUpPresenter {
    UserRepository userRepository;
    SignUpView signUpView;
    PageController pageController;

    public SignUpPresenter(SignUpView signUpView, UserRepository userRepository, PageController pageController) {
        this.userRepository = userRepository;
        this.signUpView = signUpView;
        this.pageController = pageController;
        
        this.initListener();
    }
    
    private void initListener() {
        this.signUpView.addSignUpListener(() -> this.onSignUp());
        this.signUpView.addGoToLoginListener(() -> onGoToLogin());
    }
    
    private void onSignUp() {
        String username = this.signUpView.getUsernameInput();
        String name = this.signUpView.getNameInput();
        String password = this.signUpView.getPasswordInput();
        String confirmPassword = this.signUpView.getConfirmPasswordInput();
        
        Validator registrationValidator = new StringMustBeNotEmptyValidator(username, "Username is empty");
        registrationValidator
                .setNext(new StringMustBeNotEmptyValidator(name, "Name is empty"))
                .setNext(new StringMustBeNotEmptyValidator(password, "Password is empty"))
                .setNext(new StringMustBeEqualsValidator(password, confirmPassword, "password and confirm password not equals"));
        
        ValidatorStatus validatorStatus = registrationValidator.check();
        
        if(validatorStatus instanceof FailedValidatorStatus) {
            this.signUpView.showMessage(validatorStatus.getMessage());
            return;
        }
        
        try {
            String hashedPassword = PasswordHelper.hashPassword(password);
            
            User user = new User();
            user.setUsername(username);
            user.setName(name);
            user.setPassword(hashedPassword);
            
            this.userRepository.insert(user);
            
            this.signUpView.showMessage("Sign up success");
            this.signUpView.close();
            this.pageController.showLogin();
        } catch(DuplicateEntryException e) {
            this.signUpView.showMessage("username has been registred");
        } catch(RepositoryException e) {
            this.signUpView.showMessage(e.getMessage());
        }
    }
    
    private void onGoToLogin() {
        this.signUpView.close();
        this.pageController.showLogin();
    }
}
