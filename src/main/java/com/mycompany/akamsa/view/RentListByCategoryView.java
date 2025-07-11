/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.akamsa.view;

import com.mycompany.akamsa.common.ClickListener;
import com.mycompany.akamsa.entity.Item;
import java.util.List;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author farhannivta
 */
public interface RentListByCategoryView {
    public void open();
    
    public void setItems(List<Item> items);
    
    public void close();
    
    
    public void setItemTableClickListener(ListSelectionListener listener);
    public int getSelectedRowIndex();
    public Item getItemByRow(int row);
    
    public void addTambahClickListener(ClickListener listener);
    
    public void addUpdateClickListener(ClickListener listener);
    
    public void addSewaClickListener(ClickListener listener);
    
    public String getSearchInput();
    public void setSearchInput(String input);
    
    public void addSearchClickListener(ClickListener listener);
}
