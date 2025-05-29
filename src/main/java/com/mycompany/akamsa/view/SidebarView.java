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
public interface SidebarView {
    public void addHomePageClickListener(ClickListener listener);
    
    public void addRentPageClickListener(ClickListener listener);
    
    public void addCartPageClickListener(ClickListener listener);
    
    public void addTransactionPageClickListener(ClickListener listener);
}
