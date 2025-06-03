/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.akamsa.presenter;

import com.mycompany.akamsa.entity.Item;
import com.mycompany.akamsa.repository.item.ItemRepository;
import com.mycompany.akamsa.view.RentListByCategoryView;
import java.util.List;

/**
 *
 * @author farhannivta
 */
public class RentListByCategoryPresenter {
    String category;
    RentListByCategoryView view;
    ItemRepository itemRepository;

    public RentListByCategoryPresenter(String category, RentListByCategoryView view, ItemRepository itemRepository) {
        this.category = category;
        this.view = view;
        this.itemRepository = itemRepository;
        
        
        this.view.setItems(this.itemRepository.getByCategory(category));
        this.view.open();
        
        this.initListener();
    }
    
    private void initListener() {
        
    }
}
