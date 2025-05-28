/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.akamsa.presenter;

import com.mycompany.akamsa.controller.PageController;
import com.mycompany.akamsa.entity.User;
import com.mycompany.akamsa.exception.EntityNotFoundException;
import com.mycompany.akamsa.exception.RepositoryException;
import com.mycompany.akamsa.helper.PasswordHelper;
import com.mycompany.akamsa.repository.user.UserRepository;
import com.mycompany.akamsa.view.auth.LoginView;

/**
 *
 * @author farhannivta
 */
public class LoginPresenter {
    private LoginView loginView;
    private UserRepository userRepository;
    private PageController pageController;

    public LoginPresenter(LoginView loginView, UserRepository userRepository, PageController pageController) {
        this.loginView = loginView;
        this.userRepository = userRepository;
        this.pageController = pageController;
        
        this.initListener();
    }
    
    private void initListener() {
        this.loginView.addLoginListener(e -> this.onLogin());
    }
    
    private void onLogin() {
        String username = this.loginView.getUsernameInput();
        String password = this.loginView.getPasswordInput();
        
        try {
            User user = this.userRepository.getByUsername(username);
            
            if(PasswordHelper.verifyPassword(password, user.getPassword())) {
                this.loginView.showMessage("Login Berhasil");
                this.loginView.close();
                this.pageController.showSignUp();
            } else {
                throw new EntityNotFoundException("username or password not match credentials", new Throwable());
            }
        } catch(EntityNotFoundException e) {
            this.loginView.showMessage(e.getMessage());
        } catch(RepositoryException e) {
            this.loginView.showMessage(e.getMessage());
        }
    }
}