/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.akamsa.view;

import com.mycompany.akamsa.common.ClickListener;
import com.mycompany.akamsa.entity.Transaction;
import java.util.List;

/**
 *
 * @author farhannivta
 */
public interface TransactionView {
    public void open();
    
    public void setTransactionData(List<Transaction> transactions);
    
    public String getSearchInput();
    
    public void addSearchClickListener(ClickListener listener);
    
    public void close();
}
