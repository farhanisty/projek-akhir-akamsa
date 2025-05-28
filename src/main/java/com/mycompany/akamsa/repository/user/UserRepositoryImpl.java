/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.akamsa.repository.user;

import com.mycompany.akamsa.entity.User;
import com.mycompany.akamsa.exception.DuplicateEntryException;
import com.mycompany.akamsa.helper.Connector;
import com.mycompany.akamsa.exception.RepositoryException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author farhannivta
 */
public class UserRepositoryImpl implements UserRepository {
    private String tableName = "user";

    @Override
    public boolean insert(User user) throws RepositoryException, DuplicateEntryException {
        PreparedStatement st = null;
        boolean result = false;
        
        try {
            String sql = "INSERT INTO " + this.tableName + "(username, name, password) VALUES(?, ?, ?)";
            st = Connector.getConnection().prepareStatement(sql);
            
            st.setString(1, user.getUsername());
            st.setString(2, user.getName());
            st.setString(3, user.getPassword());
            
            if(st.executeUpdate() > 0) {
                result = true;
            }
        } catch(SQLException e) {
            if(e.getErrorCode() == 1062) {
                throw new DuplicateEntryException("Username sudah digunakan", e);
            }
            throw new RepositoryException(e.getMessage(), e);
        } finally {
            try {
                st.close();
            } catch(SQLException e) {
                throw new RepositoryException(e.getMessage(), e);
            }
        }
        
        return result;
    }

    @Override
    public List<User> getAll() throws RepositoryException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public User getById(int id) throws RepositoryException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(User user) throws RepositoryException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int id) throws RepositoryException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
