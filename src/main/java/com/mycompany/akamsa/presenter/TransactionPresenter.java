/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.akamsa.presenter;

import com.mycompany.akamsa.repository.transaction.TransactionRepository;
import com.mycompany.akamsa.view.TransactionView;

/**
 *
 * @author farhannivta
 */
public class TransactionPresenter {
    private TransactionRepository transactionRepository;
    private TransactionView view;

    public TransactionPresenter(TransactionView view, TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
        this.view = view;
        
        this.initTable();
        this.view.open();
        
        
    }
    
    private void initTable() {
        this.view.setTransactionData(this.transactionRepository.getAll());
    }
}
