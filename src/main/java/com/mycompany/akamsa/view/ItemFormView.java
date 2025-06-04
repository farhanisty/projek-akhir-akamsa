/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.akamsa.view;

import com.mycompany.akamsa.common.ClickListener;

/**
 *
 * @author farhannivta
 */
public interface ItemFormView {
    public void open();
    public void close();
    
    public String getIdInput();
    public void setIdInput(String id);
    
    public String getUsernameInput();
    public void setUsernameInput(String username);
    
    public String getPriceInput();
    public void setPriceInput(String price);
    
    public String getStockInput();
    public void setStockInput(String stock);
    
    public String getCategoryInput();
    public void setCategoryInput(String category);
    
    public String getImageInput();
    public void setImageInput(String name);
    
    public void addActionClickListener(ClickListener listener);
    
    public void showMessage(String message);
}
