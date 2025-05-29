/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.akamsa.repository.item;

import com.mycompany.akamsa.entity.Item;
import com.mycompany.akamsa.entity.User;
import com.mycompany.akamsa.exception.EntityNotFoundException;
import com.mycompany.akamsa.exception.RepositoryException;
import com.mycompany.akamsa.helper.Connector;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author farhannivta
 */
public class ItemRepositoryImpl implements ItemRepository {
    private final String tableName = "item";

    @Override
    public boolean insert(Item item) throws RepositoryException {
        PreparedStatement st = null;
        boolean result = false;
        
        try {
            String sql = "INSERT INTO " + this.tableName + "(name, price, stock, category, image) VALUES(?, ?, ?, ?, ?)";
            st = Connector.getConnection().prepareStatement(sql);
            
            st.setString(1, item.getName());
            st.setFloat(2, item.getPrice());
            st.setInt(3, item.getStock());
            st.setString(4, item.getCategory());
            st.setString(5, item.getImage());
            
            if(st.executeUpdate() > 0) {
                result = true;
            }
        } catch(SQLException e) {
            throw new RepositoryException(e.getMessage(), e);
        } finally {
            try {
                st.close();
            } catch(Exception e) {
                throw new RepositoryException(e.getMessage(), e);
            }
        }
        
        return result;
    }

    @Override
    public List<Item> getAll() throws RepositoryException {
        List<Item> items = new ArrayList<>();
        String sql = "SELECT * FROM " + this.tableName;
        
        try {
            Statement st = Connector.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()) {
                Item item = new Item();
                
                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));
                item.setPrice(rs.getFloat("price"));
                item.setStock(rs.getInt("stock"));
                item.setCategory(rs.getString("category"));
                item.setImage(rs.getString("image"));
                item.setUpdatedAt(rs.getString("updated_at"));
                item.setCreatedAt(rs.getString("created_at"));
                
                items.add(item);
            }
        } catch (SQLException ex) {
            throw new RepositoryException(ex.getMessage(), ex);
        }
        
        return items;
    }

    @Override
    public Item getById(int id) throws RepositoryException {
        PreparedStatement st = null;
        var item = new Item();
        
        String sql = "SELECT * FROM " + this.tableName + " WHERE id = ?";

        
        try {
            st = Connector.getConnection().prepareStatement(sql);
            
            st.setInt(1, id);
            
            ResultSet rs = st.executeQuery();
            
            if(rs.next()) {
                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));
                item.setPrice(rs.getFloat("price"));
                item.setStock(rs.getInt("stock"));
                item.setCategory(rs.getString("category"));
                item.setImage(rs.getString("image"));
                item.setUpdatedAt(rs.getString("updated_at"));
                item.setCreatedAt(rs.getString("created_at"));
            } else {
                throw new EntityNotFoundException("id not found", new Throwable());
            }
        } catch(SQLException e) {
            throw new RepositoryException(e.getMessage(), e);
        } finally {
            try {
                st.close();
            } catch(Exception e) {
                throw new RepositoryException(e.getMessage(), e);
            }
        }
        
        return item;
    }

    @Override
    public boolean update(Item item) throws RepositoryException {
        PreparedStatement st = null;
        boolean result = false;
        
        try {
            String sql = "UPDATE " + this.tableName + " SET name = ?, price = ?, stock = ?, category = ?, image = ?, updated_at = NOW() WHERE id = ?";
            st = Connector.getConnection().prepareStatement(sql);
            
            st.setString(1, item.getName());
            st.setFloat(2, item.getPrice());
            st.setInt(3, item.getStock());
            st.setString(4, item.getCategory());
            st.setString(5, item.getImage());
            st.setInt(6, item.getId());
            
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
            } catch(Exception e) {
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
            } catch(Exception e) {
                throw new RepositoryException(e.getMessage(), e);
            }
        }
        
        return result;
    }
    
}
