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
public interface LandingPageView {
    public void open();
    
    public void addSewaClickListener(ClickListener listener);
    
    public void setLoggedUsername(String username);
    
    public void addTransactionClickListener(ClickListener listener);
    
    public void close();
}
