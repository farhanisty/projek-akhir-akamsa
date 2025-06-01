/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.akamsa.repository.transaction;

import com.mycompany.akamsa.entity.Transaction;
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
public class TransactionRepositoryImpl implements TransactionRepository {
    private final String tableName = "transaction";

    @Override
    public int insert(Transaction transaction) throws RepositoryException {
        PreparedStatement st = null;
               
        try {
            String sql = "INSERT INTO " + this.tableName + "(cashier_id, customer, number_phone, address, total_price, start_date, end_date) VALUES(?, ?, ?, ?, ?, ?, ?)";
            st = Connector.getConnection().prepareStatement(sql);
            
            st.setInt(1, transaction.getCashier().getId());
            st.setString(2, transaction.getCustomer());
            st.setString(3, transaction.getNumberPhone());
            st.setString(4, transaction.getAddress());
            st.setFloat(5, transaction.getTotalPrice());
            st.setString(6, transaction.getEndDate());
            st.setString(7, transaction.getEndDate());
            
            if(st.executeUpdate() > 0) {
                ResultSet generatedKeys = st.getGeneratedKeys();
                if(generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    return 0;
                }
            } else {
                return 0;
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
    }

    @Override
    public List<Transaction> getAll() throws RepositoryException {
        List<Transaction> transactions = new ArrayList<>();
        String sql = """
                     SELECT 
                     	t.*, u.username as u_username, 
                     	u.name as u_name, 
                     	u.password as u_password, 
                     	u.is_admin as u_is_admin, 
                     	u.is_verified as u_is_verified, 
                     	u.updated_at as u_updated_at, 
                     	u.created_at as u_created_at 
                     FROM transaction t
                     JOIN user u ON u.id = t.cashier_id
                     """;
        
        try {
            Statement st = Connector.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()) {
                transactions.add(this.convertResultSetToTransaction(rs));
            }
        } catch (SQLException ex) {
            throw new RepositoryException(ex.getMessage(), ex);
        }
        
        return transactions;
    }

    @Override
    public Transaction getById(int id) throws RepositoryException {
        PreparedStatement st = null;
        Transaction transaction = null;
        
        String sql = """
                     SELECT 
                     	t.*, u.username as u_username, 
                     	u.name as u_name, 
                     	u.password as u_password, 
                     	u.is_admin as u_is_admin, 
                     	u.is_verified as u_is_verified, 
                     	u.updated_at as u_updated_at, 
                     	u.created_at as u_created_at 
                     FROM transaction t
                     JOIN user u ON u.id = t.cashier_id
                     WHERE t.id = ?
                     """;

        
        try {
            st = Connector.getConnection().prepareStatement(sql);
            
            st.setInt(1, id);
            
            ResultSet rs = st.executeQuery();
            
            if(rs.next()) {
                transaction = this.convertResultSetToTransaction(rs);
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
        
        return transaction;
    }

    @Override
    public boolean update(Transaction transaction) throws RepositoryException {
        PreparedStatement st = null;
        boolean result = false;
        
        try {
            String sql = "UPDATE " + this.tableName + " SET cashier_id = ?, customer = ?, number_phone = ?, address = ?, total_price = ?, start_date = ?, end_date = ?, updated_at = NOW() WHERE id = ?";
            st = Connector.getConnection().prepareStatement(sql);
            
            st.setInt(1, transaction.getCashier().getId());
            st.setString(2, transaction.getCustomer());
            st.setString(3, transaction.getNumberPhone());
            st.setString(4, transaction.getAddress());
            st.setFloat(5, transaction.getTotalPrice());
            st.setString(6, transaction.getEndDate());
            st.setString(7, transaction.getEndDate());
            st.setInt(8, transaction.getId());
            
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
    
    private Transaction convertResultSetToTransaction(ResultSet rs) throws SQLException {
        Transaction transaction = new Transaction();
        User cashier = new User();
        transaction.setCashier(cashier);
        
        transaction.setId(rs.getInt("id"));
        transaction.setCustomer(rs.getString("customer"));
        transaction.setNumberPhone(rs.getString("number_phone"));
        transaction.setAddress(rs.getString("address"));
        transaction.setTotalPrice(rs.getFloat("total_price"));
        transaction.setStartDate(rs.getString("start_date"));
        transaction.setEndDate(rs.getString("end_date"));
        transaction.setCreatedAt(rs.getString("created_at"));
        transaction.setUpdatedAt(rs.getString("updated_at"));
        
        cashier.setId(rs.getInt("cashier_id"));
        cashier.setUsername(rs.getString("u_username"));
        cashier.setName(rs.getString("u_name"));
        cashier.setPassword(rs.getString("u_password"));
        cashier.setIsAdmin(rs.getBoolean("u_is_admin"));
        cashier.setIsVerified(rs.getBoolean("u_is_verified"));
        cashier.setUpdatedAt(rs.getString("u_updated_at"));
        cashier.setCreatedAt(rs.getString("u_created_at"));
        
        return transaction;
    }
}
