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
        this.sidebarView.addCartPageClickListener(() -> fireCartPage());
        this.sidebarView.addTransactionPageClickListener(() -> fireTransaction());
        this.sidebarView.addButtonLogOutClickListener(() -> fireLogout());
        this.sidebarView.addHomePageClickListener(() -> fireHomePage());
    }
    
    private void fireTransaction() {
        this.pageController.showTransaction();
        this.sidebarView.close();
    }
    
    private void fireCartPage() {
        this.pageController.showPurchaseCart();
        this.sidebarView.close();
    }
    
    private void fireLogout() {
        this.pageController.showLogin();
        this.sidebarView.close();
    }
    
    private void fireHomePage() {
        this.pageController.showCategoryDashboard();
        this.sidebarView.close();
    }
}
