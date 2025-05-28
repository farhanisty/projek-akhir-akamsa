/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.akamsa.repository.user;

import com.mycompany.akamsa.entity.User;
import com.mycompany.akamsa.exception.DuplicateEntryException;
import com.mycompany.akamsa.exception.EntityNotFoundException;
import com.mycompany.akamsa.helper.Connector;
import com.mycompany.akamsa.exception.RepositoryException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author farhannivta
 */
public class UserRepositoryImpl implements UserRepository {
    private final String tableName = "user";

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
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM " + this.tableName;
        
        try {
            Statement st = Connector.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()) {
                User user = new User();
                
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setIsAdmin(rs.getBoolean("is_admin"));
                user.setIsVerified(rs.getBoolean("is_verified"));
                user.setUpdatedAt(rs.getString("updated_at"));
                user.setCreatedAt(rs.getString("created_at"));
                
                users.add(user);
            }
        } catch (SQLException ex) {
            throw new RepositoryException(ex.getMessage(), ex);
        }
        
        return users;
    }

    @Override
    public User getById(int id) throws RepositoryException, EntityNotFoundException {
        PreparedStatement st = null;
        User user = new User();
        
        String sql = "SELECT * FROM " + this.tableName + " WHERE id = ?";

        
        try {
            st = Connector.getConnection().prepareStatement(sql);
            
            st.setInt(1, id);
            
            ResultSet rs = st.executeQuery();
            
            if(rs.next()) {
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setIsAdmin(rs.getBoolean("is_admin"));
                user.setIsVerified(rs.getBoolean("is_verified"));
                user.setUpdatedAt(rs.getString("updated_at"));
                user.setCreatedAt(rs.getString("created_at"));
            } else {
                throw new EntityNotFoundException("id not found", new Throwable());
            }
        } catch(SQLException e) {
            throw new RepositoryException(e.getMessage(), e);
        } finally {
            try {
                st.close();
            } catch(SQLException e) {
                throw new RepositoryException(e.getMessage(), e);
            }
        }
        
        return user;
    }

    @Override
    public boolean update(User user) throws RepositoryException {
         PreparedStatement st = null;
        boolean result = false;
        
        try {
            String sql = "UPDATE " + this.tableName + " SET username = ?, name = ?, password = ?, is_admin = ?, is_verified = ?, updated_at = NOW() WHERE id = ?";
            st = Connector.getConnection().prepareStatement(sql);
            
            st.setString(1, user.getUsername());
            st.setString(2, user.getName());
            st.setString(3, user.getPassword());
            st.setBoolean(4, user.getIsAdmin());
            st.setBoolean(5, user.getIsVerified());
            st.setInt(6, user.getId());
            
            if(st.executeUpdate() > 0) {
                result = true;
            } else {
                throw new EntityNotFoundException("user id not found", new Throwable());
            }
        } catch(SQLException e) {
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
    public boolean delete(int id) throws RepositoryException {
        PreparedStatement st = null;
        boolean result = false;
        
        try {
            String sql = "DELETE FROM " + this.tableName + " WHERE id = ?";
            st = Connector.getConnection().prepareStatement(sql);
            
            st.setInt(1, id);
            
            if(st.executeUpdate() > 0) {
                result = true;
            } else {
                throw new EntityNotFoundException("user id not found", new Throwable());
            }
        } catch(SQLException e) {
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
}
