/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.akamsa.view;

import com.mycompany.akamsa.common.ClickListener;
import com.mycompany.akamsa.entity.User;
import java.util.List;
import javax.swing.event.ListSelectionListener;
/**
 *
 * @author ASUS
 */
public interface AdminDashboardView {
    public void open();
    
    public void setUsers(List<User> Users);
    
    public void close();
    
    public void addButtonLogOutClickListener(ClickListener listener);
    
    public void addUpdateClickListener(ClickListener listener);
    
    public void addDeleteClickListener(ClickListener listener);
    
    public boolean showConfirmation(String message);
    
    public String getIdInput();
    
    public void setIdInput(String id);
    
    public String getUsernameInput();
    
    public void setUsernameInput(String username);
    
    public boolean getIsAdminInput();
    
    public void setIsAdminInput(boolean isAdmin);
    
    public boolean getIsVerifiedInput();
    
    public void setIsVerifiedInput(boolean isVerified);
    
    public void setUserTableClickListener(ListSelectionListener listener);
    public int getSelectedRowIndex();
    public User getUserbyRow(int row);
    
    public void showMessage(String message);
}
