/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.akamsa.repository.transaction;

import com.mycompany.akamsa.entity.Transaction;
import com.mycompany.akamsa.exception.RepositoryException;
import java.util.List;

/**
 *
 * @author farhannivta
 */
public interface TransactionRepository {
    public boolean insert(Transaction transaction) throws RepositoryException;
    
    public List<Transaction> getAll() throws RepositoryException;
    
    public Transaction getById(int id) throws RepositoryException;
    
    public boolean update(Transaction transaction) throws RepositoryException;
    
    public boolean delete(int id) throws RepositoryException;
}
