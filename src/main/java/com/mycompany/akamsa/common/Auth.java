/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.akamsa.common;

import com.mycompany.akamsa.entity.User;

/**
 *
 * @author farhannivta
 */
public class Auth {
    private static User user;

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        Auth.user = user;
    }
}
