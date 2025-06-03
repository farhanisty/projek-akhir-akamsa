/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.akamsa.presenter;

import com.mycompany.akamsa.controller.PageController;
import com.mycompany.akamsa.entity.User;
import com.mycompany.akamsa.exception.RepositoryException;
import com.mycompany.akamsa.helper.validator.FailedValidatorStatus;
import com.mycompany.akamsa.helper.validator.StringMustBeEqualsValidator;
import com.mycompany.akamsa.helper.validator.StringMustBeNotEmptyValidator;
import com.mycompany.akamsa.helper.validator.Validator;
import com.mycompany.akamsa.helper.validator.ValidatorStatus;
import com.mycompany.akamsa.repository.user.UserRepository;
import com.mycompany.akamsa.view.AdminDashboardView;

/**
 *
 * @author farhannivta
 */
public class AdminDashboardPresenter {
    AdminDashboardView view;
    UserRepository userRepository;
    PageController pageController;

    public AdminDashboardPresenter(AdminDashboardView view, UserRepository userRepository, PageController pageController) {
        this.view = view;
        this.userRepository = userRepository;
        this.pageController = pageController;
    }
    
    public void init() {
        this.view.setUsers(this.userRepository.getAll());
        this.view.open();
        
        this.initListener();
    }
    
    private void initListener() {
        this.view.addButtonLogOutClickListener(() -> this.onLogout());
        this.view.addUpdateClickListener(() -> this.onUpdate());
        this.view.addDeleteClickListener(() -> this.onDelete());
        this.view.setUserTableClickListener(e -> this.onUserSelected());
    }
    
    private void onLogout() {
        if(this.view.showConfirmation("Apakah yakin ingin logout?")) {
            this.view.close();
            this.pageController.showLogin();
        }
    }
    
    private void onDelete() {
        if(!this.view.showConfirmation("Are you sure to delete?")) {
            return;
        }
        
        String id = this.view.getIdInput();
        
        if(id.isBlank()) {
            this.view.showMessage("Id is empty");
            return;
        }
        
        this.userRepository.delete(Integer.parseInt(id));
        this.clearInput();
        this.view.showMessage("User successfully deleted");
    }
    
    private void onUpdate() {
        String id = this.view.getIdInput();
        String username = this.view.getUsernameInput();
        boolean isAdmin = this.view.getIsAdminInput();
        boolean isVerified = this.view.getIsVerifiedInput();
        
        Validator registrationValidator = new StringMustBeNotEmptyValidator(String.valueOf(id), "Id is empty");
        registrationValidator
                .setNext(new StringMustBeNotEmptyValidator(username, "Username is empty"));
        
        ValidatorStatus validatorStatus = registrationValidator.check();
        
        if(validatorStatus instanceof FailedValidatorStatus) {
            this.view.showMessage(validatorStatus.getMessage());
            return;
        }
        
        try {
            User user = this.view.getUserbyRow(this.view.getSelectedRowIndex());
            user.setId(Integer.parseInt(id));
            user.setUsername(username);
            user.setIsAdmin(isAdmin);
            user.setIsVerified(isVerified);
            
            this.userRepository.update(user);
            
            this.view.showMessage("Update user successfully");
            
            this.clearInput();
        } catch(RepositoryException e) {
            this.view.showMessage(e.getMessage());
        }
    }
    
    private void onUserSelected() {
        int index = this.view.getSelectedRowIndex();
        
        if(index < 0) {
            return;
        }
        
        User user = this.view.getUserbyRow(index);
        
        this.view.setIdInput(String.valueOf(user.getId()));
        this.view.setUsernameInput(user.getUsername());
        this.view.setIsAdminInput(user.getIsAdmin());
        this.view.setIsVerifiedInput(user.getIsVerified());
    }
    
    private void clearInput() {
        this.view.setIdInput("");
        this.view.setUsernameInput("");
        this.view.setIsAdminInput(false);
        this.view.setIsVerifiedInput(false);

        this.view.setUsers(this.userRepository.getAll());
    }
}
