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
public interface CategoryDashboardView {
    public void addLightingListener(ClickListener listener);
    
    public void addTendaListener(ClickListener listener);
    
    public void addToolListener(ClickListener listener);
    
    public void addWearListener(ClickListener listener);
    
    public void addCarrierListener(ClickListener listener);
    
    public void addNavigationListener(ClickListener listener);
}
