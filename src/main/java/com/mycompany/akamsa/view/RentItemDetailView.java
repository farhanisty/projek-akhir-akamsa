/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.akamsa.view;

import com.mycompany.akamsa.common.ClickListener;
import com.mycompany.akamsa.entity.Item;

/**
 *
 * @author farhannivta
 */
public interface RentItemDetailView {
    public void open();
    
    public void setItem(Item item);
    
    public int getCountBeliInput();
    
    public void setCartClickListener(ClickListener listener);
    
    public void showMessage(String message);
    
    public void close();
}
