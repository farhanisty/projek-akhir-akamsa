/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.akamsa.view;

import com.mycompany.akamsa.common.ClickListener;
import com.mycompany.akamsa.entity.Cart;
import java.util.List;

/**
 *
 * @author farhannivta
 */
public interface PurchaseCartView {
    public void open();
    
    public void setCarts(List<Cart> carts);
    
    public void addClearCickListener(ClickListener listener);
    
    public void addRentClickListener(ClickListener listener);
    
    public void setTotalBill(int totalBill);
    
    public String getStartDateInput();
    
    public String getEndDateInput();
    
    public String getNameInput();
    
    public String getPhoneNumberInput();
    
    public String getAddressInput();
    
    public void showMessage(String message);
    
    public void close();
}
