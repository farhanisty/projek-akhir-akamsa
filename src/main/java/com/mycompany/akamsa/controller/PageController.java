/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.akamsa.controller;

import com.mycompany.akamsa.presenter.LoginPresenter;
import com.mycompany.akamsa.repository.user.UserRepository;
import com.mycompany.akamsa.repository.user.UserRepositoryFactory;
import com.mycompany.akamsa.view.auth.SignIn;
import com.mycompany.akamsa.view.auth.SignUp;

/**
 *
 * @author farhannivta
 */
public class PageController {
    private UserRepository userRepository;
    
    public PageController() {
        this.userRepository = UserRepositoryFactory.getSingletone();
    }
    public void showLogin() {
        SignIn signIn = new SignIn();
        signIn.setVisible(true);
        
        LoginPresenter loginPresenter = new LoginPresenter(signIn, userRepository, this);
    }
    
    public void showSignUp() {
        SignUp signUp = new SignUp();
        
        signUp.setVisible(true);
    }
}
