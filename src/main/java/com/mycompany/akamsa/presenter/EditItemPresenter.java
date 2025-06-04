/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.akamsa.presenter;

import com.mycompany.akamsa.controller.PageController;
import com.mycompany.akamsa.entity.Item;
import com.mycompany.akamsa.helper.validator.StringMustBeNotEmptyValidator;
import com.mycompany.akamsa.helper.validator.Validator;
import com.mycompany.akamsa.repository.item.ItemRepository;
import com.mycompany.akamsa.view.ItemFormView;

/**
 *
 * @author farhannivta
 */
public class EditItemPresenter {
    int id;
    Item item;
    ItemFormView addView;
    ItemRepository itemRepository;
    PageController pageController;

    public EditItemPresenter(int id, ItemFormView addView, ItemRepository itemRepository, PageController pageController) {
        this.id = id;
        this.addView = addView;
        this.itemRepository = itemRepository;
        this.pageController = pageController;
    }
    
    public void init() {
        this.initListener();
        
        this.addView.open();
        
        this.item = this.itemRepository.getById(id);
    }
    
    public void initListener() {
        this.addView.addActionClickListener(() -> onUpdate());
    }
    
    private void onUpdate() {
        String name = this.addView.getUsernameInput();
        String stock = this.addView.getStockInput();
        String price = this.addView.getPriceInput();
        String image = this.addView.getImageInput();
        
        Validator registrationValidator = new StringMustBeNotEmptyValidator(name, "Name is empty");
        registrationValidator
                .setNext(new StringMustBeNotEmptyValidator(stock, "Stock is empty"))
                .setNext(new StringMustBeNotEmptyValidator(price, "Price is empty"));
        
        try {
            item.setName(name);
            item.setPrice(Float.parseFloat(price));
            item.setStock(Integer.parseInt(stock));
            item.setImage(image);
            
            this.itemRepository.update(item);
            
            this.addView.showMessage("Successfully update Item");
        } catch(Exception e) {
            this.addView.showMessage(e.getMessage());
        }
        
    }
    
    private void clearForm() {
        this.addView.setIdInput("");
        this.addView.setUsernameInput("");
        this.addView.setStockInput("");
        this.addView.setPriceInput("");
        this.addView.setImageInput("");
    }
}
