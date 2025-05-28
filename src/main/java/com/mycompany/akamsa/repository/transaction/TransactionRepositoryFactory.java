/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.akamsa.repository.transaction;


/**
 *
 * @author farhannivta
 */
public class TransactionRepositoryFactory {
     private static TransactionRepository transactionRepository = null;
    
    public static TransactionRepository getSingletone() {
        if(TransactionRepositoryFactory.transactionRepository == null) {
            transactionRepository = new TransactionRepositoryImpl();
        }
        
        return transactionRepository;
    }
}
