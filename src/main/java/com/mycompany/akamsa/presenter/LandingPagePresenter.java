/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.akamsa.presenter;

import com.mycompany.akamsa.common.Auth;
import com.mycompany.akamsa.controller.PageController;
import com.mycompany.akamsa.view.LandingPageView;

/**
 *
 * @author farhannivta
 */
public class LandingPagePresenter {
    LandingPageView landingPageView;
    PageController pageController;

    public LandingPagePresenter(LandingPageView landingPageView, PageController pageController) {
        this.landingPageView = landingPageView;
        this.pageController = pageController;
    }
    
    public void init() {
        this.initListener();
        this.landingPageView.setLoggedUsername(Auth.getUser().getName());
        this.landingPageView.open();
    }
    
    private void initListener() {
        this.landingPageView.addSewaClickListener(() -> fireSewa());
        this.landingPageView.addTransactionClickListener(() -> fireTransaction());
    }
    
    private void fireSewa() {
        this.landingPageView.close();
        this.pageController.showCategoryDashboard();
    }
    
    private void fireTransaction() {
        this.landingPageView.close();
        this.pageController.showTransaction();
    }
}
