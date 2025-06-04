/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.akamsa.controller;

import com.mycompany.akamsa.presenter.AddItemPresenter;
import com.mycompany.akamsa.presenter.AdminDashboardPresenter;
import com.mycompany.akamsa.presenter.CategoryDashboardPresenter;
import com.mycompany.akamsa.presenter.EditItemPresenter;
import com.mycompany.akamsa.presenter.LandingPagePresenter;
import com.mycompany.akamsa.presenter.LoginPresenter;
import com.mycompany.akamsa.presenter.PurchaseCartPresenter;
import com.mycompany.akamsa.presenter.RentItemDetailPresenter;
import com.mycompany.akamsa.presenter.RentListByCategoryPresenter;
import com.mycompany.akamsa.presenter.SidebarPresenter;
import com.mycompany.akamsa.presenter.SignUpPresenter;
import com.mycompany.akamsa.presenter.TransactionPresenter;
import com.mycompany.akamsa.repository.cart.CartRepository;
import com.mycompany.akamsa.repository.cart.CartRepositoryFactory;
import com.mycompany.akamsa.repository.item.ItemRepository;
import com.mycompany.akamsa.repository.item.ItemRepositoryFactory;
import com.mycompany.akamsa.repository.transaction.TransactionRepository;
import com.mycompany.akamsa.repository.transaction.TransactionRepositoryFactory;
import com.mycompany.akamsa.repository.user.UserRepository;
import com.mycompany.akamsa.repository.user.UserRepositoryFactory;
import com.mycompany.akamsa.view.AdminDashboardView;
import com.mycompany.akamsa.view.PurchaseCartView;
import com.mycompany.akamsa.view.RentItemDetailView;
import com.mycompany.akamsa.view.RentListByCategoryView;
import com.mycompany.akamsa.view.TransactionView;
import com.mycompany.akamsa.view.auth.LoginUi;
import com.mycompany.akamsa.view.auth.SignUp;
import com.mycompany.akamsa.view.ui.AddItem;
import com.mycompany.akamsa.view.ui.AdminDashboard;
import com.mycompany.akamsa.view.ui.CategoryDashboardUi;
import com.mycompany.akamsa.view.ui.LandingPage;
import com.mycompany.akamsa.view.ui.PurchaseCartUi;
import com.mycompany.akamsa.view.ui.RentItemDetailUi;
import com.mycompany.akamsa.view.ui.RentListByCategoryUi;
import com.mycompany.akamsa.view.ui.TransactionUi;
import com.mycompany.akamsa.view.ui.UpdateItem;

/**
 *
 * @author farhannivta
 */
public class PageController {
    private UserRepository userRepository;
    private CartRepository cartRepository;
    private TransactionRepository transactionRepository;
    private ItemRepository itemRepository;
    
    public PageController() {
        this.userRepository = UserRepositoryFactory.getSingletone();
        this.cartRepository = CartRepositoryFactory.getSingletone();
        this.transactionRepository = TransactionRepositoryFactory.getSingletone();
        this.itemRepository = ItemRepositoryFactory.getSingletone();
    }
    public void showLogin() {
        LoginUi signIn = new LoginUi();
        signIn.setVisible(true);
        
        LoginPresenter loginPresenter = new LoginPresenter(signIn, userRepository, this);
    }
    
    public void showSignUp() {
        SignUp signUp = new SignUp();
        
        signUp.setVisible(true);
        
        SignUpPresenter signUpPresenter = new SignUpPresenter(signUp, this.userRepository, this);
    }
    
    public void showLandingPage() {
        LandingPage view = new LandingPage();
        
        SidebarPresenter sidebarPresenter = new SidebarPresenter(view, this);
        sidebarPresenter.init();
        
        LandingPagePresenter presenter = new LandingPagePresenter(view, this);
        presenter.init();
    }
    
    public void showCategoryDashboard() {
        CategoryDashboardUi categoryDashboardView = new CategoryDashboardUi();
        categoryDashboardView.setVisible(true);
        
        SidebarPresenter sidebarPresenter = new SidebarPresenter(categoryDashboardView, this);
        sidebarPresenter.init();
        
        CategoryDashboardPresenter categoryDashboardPresenter = new CategoryDashboardPresenter(categoryDashboardView, this);
    }
    
    public void showPurchaseCart() {
        PurchaseCartUi purchaseCartView = new PurchaseCartUi();
        SidebarPresenter sidebarPresenter = new SidebarPresenter(purchaseCartView, this);
        sidebarPresenter.init();
        
        PurchaseCartPresenter purchaseCartPresenter = new PurchaseCartPresenter(purchaseCartView, this.transactionRepository, this.cartRepository, this);
    }
    
    public void showRentItemDetail(int id) {
        RentItemDetailUi view = new RentItemDetailUi();
        
        SidebarPresenter sidebarPresenter = new SidebarPresenter(view, this);
        sidebarPresenter.init();
        RentItemDetailPresenter rentItemDetailPresenter = new RentItemDetailPresenter(id, view, this.itemRepository);
    }
    
    public void showTransaction() {
        TransactionUi view = new TransactionUi();
        
        SidebarPresenter sidebarPresenter = new SidebarPresenter(view, this);
        sidebarPresenter.init();
        
        TransactionPresenter transactionPresenter = new TransactionPresenter(view, this.transactionRepository);
    }
    
    public void showRentListByCategory(String category) {
        RentListByCategoryUi view = new RentListByCategoryUi();
        
        SidebarPresenter sidebarPresenter = new SidebarPresenter(view, this);
        sidebarPresenter.init();
        
        RentListByCategoryPresenter rentListByCategoryPresenter = new RentListByCategoryPresenter(category, view, this.itemRepository, this);
    }
    
    public void showAdminDashboard() {
        AdminDashboardView view = new AdminDashboard();
        
        AdminDashboardPresenter presenter = new AdminDashboardPresenter(view, this.userRepository, this);
        presenter.init();
    }
    
    public void showAddItem() {
        AddItem view = new AddItem();
        
        SidebarPresenter sidebarPresenter = new SidebarPresenter(view, this);
        sidebarPresenter.init();
        
        AddItemPresenter presenter = new AddItemPresenter(view, this.itemRepository, this);
        presenter.init();
    }
    
    public void showEditItem(int id) {
        UpdateItem view = new UpdateItem();
        
        SidebarPresenter sidebarPresenter = new SidebarPresenter(view, this);
        sidebarPresenter.init();
        
        EditItemPresenter presenter = new EditItemPresenter(id, view, this.itemRepository, this);
        presenter.init();
    }
}
