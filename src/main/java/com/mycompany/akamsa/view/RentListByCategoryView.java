/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.akamsa.view;

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
}
