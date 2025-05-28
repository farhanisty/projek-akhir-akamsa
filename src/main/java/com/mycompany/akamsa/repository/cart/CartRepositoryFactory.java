/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.akamsa.repository.cart;


/**
 *
 * @author farhannivta
 */
public class CartRepositoryFactory {
     private static CartRepository cartRepository = null;
    
    public static CartRepository getSingletone() {
        if(CartRepositoryFactory.cartRepository == null) {
            cartRepository = new CartRepositoryImpl();
        }
        
        return cartRepository;
    }
}
