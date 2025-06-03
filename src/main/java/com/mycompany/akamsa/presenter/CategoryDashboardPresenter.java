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
        this.categoryDashboardView.addCarrierListener(() -> fireRentListByCategoryView("Carrier"));
        this.categoryDashboardView.addLightingListener(() -> fireRentListByCategoryView("Carrier"));
        this.categoryDashboardView.addNavigationListener(() -> fireRentListByCategoryView("Carrier"));
        this.categoryDashboardView.addTendaListener(() -> fireRentListByCategoryView("Carrier"));
        this.categoryDashboardView.addToolListener(() -> fireRentListByCategoryView("Carrier"));
        this.categoryDashboardView.addWearListener(() -> fireRentListByCategoryView("Carrier"));
    }
    
    private void fireRentListByCategoryView(String category) {
        this.pageController.showRentListByCategory(category);
        this.categoryDashboardView.close();
    }
}
