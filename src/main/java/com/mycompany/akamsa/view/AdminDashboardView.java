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
    
    
    public void setUserTableClickListener(ListSelectionListener listener);
    public int getSelectedRowIndex();
    public User getUserbyRow(int row);
}
