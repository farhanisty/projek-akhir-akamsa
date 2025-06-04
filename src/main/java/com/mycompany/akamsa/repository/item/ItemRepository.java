/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.akamsa.repository.item;

import com.mycompany.akamsa.entity.Item;
import com.mycompany.akamsa.exception.RepositoryException;
import java.util.List;

/**
 *
 * @author farhannivta
 */
public interface ItemRepository {
    public boolean insert(Item item) throws RepositoryException;
    
    public List<Item> getAll() throws RepositoryException;
    
    public Item getById(int id) throws RepositoryException;
    
    public boolean update(Item item) throws RepositoryException;
    
    public boolean delete(int id) throws RepositoryException;
    
    public List<Item> getByCategory(String category) throws RepositoryException;
    
    public List<Item> getByNameAndCategory(String name, String category) throws RepositoryException;
}
