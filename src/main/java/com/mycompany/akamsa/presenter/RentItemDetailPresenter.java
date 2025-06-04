package com.mycompany.akamsa.presenter;

import com.mycompany.akamsa.common.CartCache;
import com.mycompany.akamsa.entity.Cart;
import com.mycompany.akamsa.entity.Item;
import com.mycompany.akamsa.repository.item.ItemRepository;
import com.mycompany.akamsa.view.RentItemDetailView;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author farhannivta
 */
public class RentItemDetailPresenter {
    RentItemDetailView rentItemDetailView;
    ItemRepository itemRepository;
    Item item;

    public RentItemDetailPresenter(int itemId, RentItemDetailView rentItemDetailView, ItemRepository itemRepository) {
        this.rentItemDetailView = rentItemDetailView;
        this.itemRepository = itemRepository;
        this.item = this.itemRepository.getById(itemId);
        
        this.rentItemDetailView.setItem(this.item);
        this.rentItemDetailView.open();
        
        this.initListener();
    }
    
    private void initListener() {
        this.rentItemDetailView.setCartClickListener(() -> onCartClick());
    }
    
    private void onCartClick() {
        int total = this.rentItemDetailView.getCountBeliInput();
        int itemId = this.item.getId();
        
        Cart cart = new Cart();
        
        if(total > item.getStock()) {
            this.rentItemDetailView.showMessage("Input total more than stock!");
            return;
        }
        cart.setItem(item);
        cart.setTotal(total);
        
        CartCache.push(cart);
        
        this.rentItemDetailView.showMessage("Success add to cart");
    }
}
