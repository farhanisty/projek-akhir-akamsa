/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.akamsa.presenter;

import com.mycompany.akamsa.controller.PageController;
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
    PageController pageController;

    public RentListByCategoryPresenter(String category, RentListByCategoryView view, ItemRepository itemRepository, PageController pageController) {
        this.category = category;
        this.view = view;
        this.itemRepository = itemRepository;
        this.pageController = pageController;
        
        
        this.view.setItems(this.itemRepository.getByCategory(category));
        this.view.open();
        
        this.initListener();
    }
    
    private void initListener() {
        this.view.addTambahClickListener(() -> this.pageController.showAddItem());
        this.view.addUpdateClickListener(() -> this.onUpdate());
        this.view.addSewaClickListener(() -> this.onSewa());
    }
    
    private void onUpdate() {
        int index = this.view.getSelectedRowIndex();
        
        if(index < 0) {
            return;
        }
        
        int id = this.view.getItemByRow(index).getId();
        
        this.view.close();
        this.pageController.showEditItem(id);
    }
    
    private void onSewa() {
        int index = this.view.getSelectedRowIndex();
        
        if(index < 0) {
            return;
        }
        
        int id = this.view.getItemByRow(index).getId();
        
        this.view.close();
        this.pageController.showRentItemDetail(id);
    }
}
