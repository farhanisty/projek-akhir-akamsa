/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.akamsa.view.auth;

import java.awt.event.ActionListener;

/**
 *
 * @author farhannivta
 */
public interface LoginView {
    public String getUsernameInput();
    public void setUsernameInput();
    
    public String getPasswordInput();
    public void setPasswordInput();
    
    public void addLoginListener(ActionListener listener);
    
    public void showMessage(String meessage);
    
    public void close();
}