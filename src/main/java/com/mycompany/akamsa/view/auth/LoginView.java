/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.akamsa.view.auth;

import com.mycompany.akamsa.common.ClickListener;
import java.awt.event.ActionListener;

/**
 *
 * @author farhannivta
 */
public interface LoginView {
    public String getUsernameInput();
    public void setUsernameInput(String username);
    
    public String getPasswordInput();
    public void setPasswordInput(String password);
    
    public void addLoginListener(ClickListener listener);
    
    public void addGoToSignUpListener(ClickListener listener);
    
    public void showMessage(String meessage);
    
    public void close();
}