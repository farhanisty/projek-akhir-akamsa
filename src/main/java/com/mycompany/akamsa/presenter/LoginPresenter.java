/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.akamsa.presenter;

import com.mycompany.akamsa.common.Auth;
import com.mycompany.akamsa.controller.PageController;
import com.mycompany.akamsa.entity.User;
import com.mycompany.akamsa.exception.EntityNotFoundException;
import com.mycompany.akamsa.exception.RepositoryException;
import com.mycompany.akamsa.helper.PasswordHelper;
import com.mycompany.akamsa.repository.user.UserRepository;
import com.mycompany.akamsa.view.auth.LoginView;
import com.mycompany.akamsa.view.ui.LandingPage;

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
        this.loginView.addLoginListener(() -> this.onLogin());
        this.loginView.addGoToSignUpListener(() -> this.onGoToSignUp());
    }
    
    private void onLogin() {
        String username = this.loginView.getUsernameInput();
        String password = this.loginView.getPasswordInput();
        
        try {
            User user = this.userRepository.getByUsername(username);
            
            if(PasswordHelper.verifyPassword(password, user.getPassword())) {
                
                if(!user.getIsVerified()) {
                    this.loginView.showMessage("Your account is not verifed yet");
                    return;
                }
                
                Auth.setUser(user);
                this.loginView.showMessage("Login Berhasil");
                this.loginView.close();
                
                if(user.getIsAdmin()) {
                    this.pageController.showAdminDashboard();
                } else {
                    this.pageController.showLandingPage();
                }
                
                
            } else {
                throw new EntityNotFoundException("username or password not match credentials", new Throwable());
            }
        } catch(EntityNotFoundException e) {
            this.loginView.showMessage(e.getMessage());
        } catch(RepositoryException e) {
            this.loginView.showMessage(e.getMessage());
        } finally {
            this.loginView.setPasswordInput("");
            this.loginView.setUsernameInput("");
        }
    }
    
    private void onGoToSignUp() {
        this.loginView.close();
        this.pageController.showSignUp();
    }
}