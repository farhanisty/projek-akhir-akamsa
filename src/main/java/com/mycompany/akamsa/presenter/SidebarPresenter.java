/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.akamsa.presenter;

import com.mycompany.akamsa.controller.PageController;
import com.mycompany.akamsa.view.SidebarView;

/**
 *
 * @author farhannivta
 */
public class SidebarPresenter {
    private SidebarView sidebarView;
    private PageController pageController;

    public SidebarPresenter(SidebarView sidebarView, PageController pageController) {
        this.sidebarView = sidebarView;
        this.pageController = pageController;
    }
    
    public void init() {
        this.initListener();
    }
    
    public void initListener() {
        this.sidebarView.addCartPageClickListener(() -> this.pageController.showTransaction());
        this.sidebarView.addTransactionPageClickListener(() -> fireTransaction());
    }
    
    private void fireTransaction() {
        this.pageController.showTransaction();
        this.sidebarView.close();
    }
}
