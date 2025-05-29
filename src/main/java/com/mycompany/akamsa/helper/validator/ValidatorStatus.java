/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.akamsa.helper.validator;

/**
 *
 * @author farhannivta
 */
public abstract class ValidatorStatus {
    private boolean status;
    private String message;
    
    protected void setStatus(boolean status) {
        this.status = status;
    }
    
    protected void setMessage(String message) {
        this.message = message;
    }
    
    public String getMessage() {
        return this.message;
    }
    
    public boolean getStatus() {
        return this.status;
    }
}