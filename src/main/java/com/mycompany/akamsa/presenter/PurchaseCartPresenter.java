/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.akamsa.presenter;

import com.mycompany.akamsa.common.Auth;
import com.mycompany.akamsa.common.CartCache;
import com.mycompany.akamsa.controller.PageController;
import com.mycompany.akamsa.entity.Cart;
import com.mycompany.akamsa.entity.Transaction;
import com.mycompany.akamsa.entity.User;
import com.mycompany.akamsa.exception.RepositoryException;
import com.mycompany.akamsa.repository.cart.CartRepository;
import com.mycompany.akamsa.repository.transaction.TransactionRepository;
import com.mycompany.akamsa.view.PurchaseCartView;
import java.util.List;

/**
 *
 * @author farhannivta
 */
public class PurchaseCartPresenter {
    PurchaseCartView purchaseCartView;
    TransactionRepository transactionRepository;
    CartRepository cartRepository;
    PageController pageController;

    public PurchaseCartPresenter(PurchaseCartView purchaseCartView, TransactionRepository transactionRepository, CartRepository cartRepository, PageController pageController) {
        this.purchaseCartView = purchaseCartView;
        this.transactionRepository = transactionRepository;
        this.cartRepository = cartRepository;
        this.pageController = pageController;
        
        this.purchaseCartView.open();
        this.init();
        this.initListener();
    }
    
    private void init() {
        int totalBill = CartCache.totalBill();
        this.purchaseCartView.setCarts(CartCache.getCarts());
        this.purchaseCartView.setTotalBill(totalBill);
        
        
    }
    
    private void initListener() {
        this.purchaseCartView.addClearCickListener(() -> onClearCarts());
        this.purchaseCartView.addRentClickListener(() -> this.onRent());
    }
    
    private void onRent() {
        Transaction transaction = new Transaction();
        User cashier = Auth.getUser();
        List<Cart> carts = CartCache.getCarts();
        
        transaction.setCustomer(this.purchaseCartView.getNameInput());
        transaction.setAddress(this.purchaseCartView.getAddressInput());
        transaction.setStartDate(this.purchaseCartView.getStartDateInput());
        transaction.setEndDate(this.purchaseCartView.getEndDateInput());
        transaction.setTotalPrice(CartCache.totalBill());
        
        transaction.setCashier(cashier);
        
        try {
            int transactionId = this.transactionRepository.insert(transaction);
            transaction.setId(transactionId);
            
            for(Cart c: carts) {
                c.setTransaction(transaction);
                
                this.cartRepository.insert(c);
            }
            
            this.purchaseCartView.showMessage("Transaction Successfull");
            CartCache.clear();
            
            this.purchaseCartView.close();
            
            this.pageController.showTransaction();
            
        } catch(RepositoryException e) {
            this.purchaseCartView.showMessage(e.getMessage());
        }
    }
    
    private void onClearCarts() {
        CartCache.clear();
        this.init();
    }
}