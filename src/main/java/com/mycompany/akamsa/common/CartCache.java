/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.akamsa.common;

import com.mycompany.akamsa.entity.Cart;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author farhannivta
 */
public class CartCache {
    private static final List<Cart> carts = new ArrayList<>();
    
    public static void push(Cart cart) {
        int id = 1;
        if(!carts.isEmpty()) {
            id = carts.getLast().getId();
        }
        
        cart.setId(id);
        
        carts.add(cart);
    }
    
    public static List<Cart> getCarts() {
        return CartCache.carts;
    }
    
    public static void remove(int id) {
        carts.remove(id - 1);
    }
    
    public static void clear() {
        carts.clear();
    }
    
    public static int totalBill() {
        int total = 0;
        
        for(Cart c: carts) {
            total += c.getTotal() * c.getItem().getPrice();
        }
        
        return total;
    }
}
