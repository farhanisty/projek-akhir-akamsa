/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.akamsa.exception;

/**
 *
 * @author farhannivta
 */
public class EntityNotFoundException extends RepositoryException {
    
    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
