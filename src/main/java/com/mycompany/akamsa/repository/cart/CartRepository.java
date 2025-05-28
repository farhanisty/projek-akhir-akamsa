/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.akamsa.repository.cart;

import com.mycompany.akamsa.entity.Cart;
import com.mycompany.akamsa.exception.RepositoryException;
import java.util.List;

/**
 *
 * @author farhannivta
 */
public interface CartRepository {
    public boolean insert(Cart cart) throws RepositoryException;
    
    public List<Cart> getAll() throws RepositoryException;
    
    public Cart getById(int id) throws RepositoryException;
    
    public boolean update(Cart cart) throws RepositoryException;
    
    public boolean delete(int id) throws RepositoryException;
}
