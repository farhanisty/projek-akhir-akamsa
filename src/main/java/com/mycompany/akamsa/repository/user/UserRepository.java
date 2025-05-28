/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.akamsa.repository.user;

import com.mycompany.akamsa.entity.User;
import com.mycompany.akamsa.exception.DuplicateEntryException;
import com.mycompany.akamsa.exception.RepositoryException;
import java.util.List;

/**
 *
 * @author farhannivta
 */
public interface UserRepository {
    public boolean insert(User user) throws RepositoryException, DuplicateEntryException;
    
    public List<User> getAll() throws RepositoryException;
    
    public User getById(int id) throws RepositoryException;
    
    public boolean update(User user) throws RepositoryException;
    
    public boolean delete(int id) throws RepositoryException;
    
    public User getByUsername(String username) throws RepositoryException;
}
