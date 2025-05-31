/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.akamsa.repository.cart;

import com.mycompany.akamsa.entity.Cart;
import com.mycompany.akamsa.entity.Item;
import com.mycompany.akamsa.entity.Transaction;
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
public class CartRepositoryImpl implements CartRepository {
    private final String tableName = "cart";

    @Override
    public boolean insert(Cart cart) throws RepositoryException {
        PreparedStatement st = null;
        boolean result = false;
        
        try {
            String sql = "INSERT INTO " + this.tableName + "(item_id, transaction_id, total) VALUES(?, ?, ?)";
            st = Connector.getConnection().prepareStatement(sql);
            
            st.setInt(1, cart.getItem().getId());
            st.setInt(2, cart.getTransaction().getId());
            st.setInt(3, cart.getTotal());
            
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
    public List<Cart> getAll() throws RepositoryException {
        List<Cart> carts = new ArrayList<>();
        String sql = "SELECT * FROM " + this.tableName;
        
        try {
            Statement st = Connector.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()) {
                carts.add(this.convertResultSetToCart(rs));
            }
        } catch (SQLException ex) {
            throw new RepositoryException(ex.getMessage(), ex);
        }
        
        return carts;
    }

    @Override
    public Cart getById(int id) throws RepositoryException {
        PreparedStatement st = null;
        Cart cart = null;
        
        String sql = "SELECT * FROM " + this.tableName + " WHERE id = ?";

        
        try {
            st = Connector.getConnection().prepareStatement(sql);
            
            st.setInt(1, id);
            
            ResultSet rs = st.executeQuery();
            
            if(rs.next()) {
                cart = this.convertResultSetToCart(rs);
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
        
        return cart;
    }

    @Override
    public boolean update(Cart cart) throws RepositoryException {
        PreparedStatement st = null;
        boolean result = false;
        
        try {
            String sql = "UPDATE " + this.tableName + " SET item_id = ?, transaction_id = ?, total = ? updated_at = NOW() WHERE id = ?";
            st = Connector.getConnection().prepareStatement(sql);
            
            st.setInt(1, cart.getItem().getId());
            st.setInt(2, cart.getTransaction().getId());
            st.setInt(3, cart.getTotal());
            st.setInt(4, cart.getId());
            
            if(st.executeUpdate() > 0) {
                result = true;
            } else {
                throw new EntityNotFoundException("cart id not found", new Throwable());
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
                throw new EntityNotFoundException("cart id not found", new Throwable());
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
        
    private Cart convertResultSetToCart(ResultSet rs) throws SQLException {
        Cart cart = new Cart();
        Transaction transaction = new Transaction();
        Item item = new Item();
        
        cart.setId(rs.getInt("id"));
        cart.setItem(item);
        cart.setTransaction(transaction);
        cart.setTotal(rs.getInt("total"));
        cart.setUpdatedAt(rs.getString("updated_at"));
        cart.setCreatedAt(rs.getString("created_at"));
        
        transaction.setId(rs.getInt("transaction_id"));
        item.setId(rs.getInt("item_id"));
        
        return cart;
    }
}
