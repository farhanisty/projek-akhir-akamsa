/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.akamsa.presenter;

import com.mycompany.akamsa.controller.PageController;
import com.mycompany.akamsa.view.CategoryDashboardView;

/**
 *
 * @author farhannivta
 */
public class CategoryDashboardPresenter {
    CategoryDashboardView categoryDashboardView;
    PageController pageController;

    public CategoryDashboardPresenter(CategoryDashboardView categoryDashboardView, PageController pageController) {
        this.categoryDashboardView = categoryDashboardView;
        this.pageController = pageController;
        
        this.initListener();
    }
    
    private void initListener() {
        this.categoryDashboardView.addCarrierListener(() -> onCarrierClick());
        this.categoryDashboardView.addLightingListener(() -> onLightingClick());
        this.categoryDashboardView.addNavigationListener(() -> onNavigationClick());
        this.categoryDashboardView.addTendaListener(() -> onTendaClick());
        this.categoryDashboardView.addToolListener(() -> onToolClick());
        this.categoryDashboardView.addWearListener(() -> onWearClick());
    }
    
    private void onTendaClick() {
        System.out.print("tenda");
    }
    
    private void onToolClick() {
        System.out.print("tenda");
    }
    
    private void onWearClick() {
        System.out.print("tenda");
    }
    
    private void onCarrierClick() {
        System.out.print("tenda");
    }
    
    private void onLightingClick() {
        System.out.print("tenda");
    }
    
    private void onNavigationClick() {
        System.out.print("tenda");
    }
}
