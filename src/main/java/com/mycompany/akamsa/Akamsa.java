/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.akamsa;

import com.mycompany.akamsa.config.Database;
import com.mycompany.akamsa.controller.PageController;

/**
 *
 * @author farhannivta
 */
public class Akamsa {

    public static void main(String[] args) {
        Database.init();
        
        PageController pageController = new PageController();
        pageController.showLogin();
    }
}
