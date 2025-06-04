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
import com.mycompany.akamsa.helper.validator.FailedValidatorStatus;
import com.mycompany.akamsa.helper.validator.StringMustBeEqualsValidator;
import com.mycompany.akamsa.helper.validator.StringMustBeNotEmptyValidator;
import com.mycompany.akamsa.helper.validator.Validator;
import com.mycompany.akamsa.helper.validator.ValidatorStatus;
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
        
        String customer = this.purchaseCartView.getNameInput();;
        String startDate = this.purchaseCartView.getStartDateInput();
        String endDate = this.purchaseCartView.getEndDateInput();
        
        Validator registrationValidator = new StringMustBeNotEmptyValidator(customer, "Customer is empty");
        registrationValidator
                .setNext(new StringMustBeNotEmptyValidator(startDate, "Start date is empty"))
                .setNext(new StringMustBeNotEmptyValidator(endDate, "End date is empty"));
        
        ValidatorStatus validatorStatus = registrationValidator.check();
        
        if(validatorStatus instanceof FailedValidatorStatus) {
            this.purchaseCartView.showMessage(validatorStatus.getMessage());
            return;
        }
        
        if(CartCache.getCarts().isEmpty()) {
            this.purchaseCartView.showMessage("Carts is empty");
            return;
        }
        
        transaction.setCustomer(this.purchaseCartView.getNameInput());
        transaction.setAddress(this.purchaseCartView.getAddressInput());
        transaction.setStartDate(this.purchaseCartView.getStartDateInput());
        transaction.setEndDate(this.purchaseCartView.getEndDateInput());
        transaction.setTotalPrice(CartCache.totalBill());
        transaction.setNumberPhone(this.purchaseCartView.getPhoneNumberInput());
        
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