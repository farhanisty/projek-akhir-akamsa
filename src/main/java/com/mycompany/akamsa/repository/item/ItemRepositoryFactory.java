/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.akamsa.repository.item;

/**
 *
 * @author farhannivta
 */
public class ItemRepositoryFactory {
    private static ItemRepository itemRepository = null;
    
    public static ItemRepository getSingletone() {
        if(ItemRepositoryFactory.itemRepository == null) {
            itemRepository = new ItemRepositoryImpl();
        }
        
        return itemRepository;
    }
}
