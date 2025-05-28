/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.akamsa.repository.user;

/**
 *
 * @author farhannivta
 */
public class UserRepositoryFactory {
    private static UserRepository userRepository = null;
    
    public static UserRepository getSingletone() {
        if(UserRepositoryFactory.userRepository == null) {
            userRepository = new UserRepositoryImpl();
        }
        
        return userRepository;
    }
}
