/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.akamsa.helper.validator;

import java.util.List;

/**
 *
 * @author farhannivta
 */
public abstract class Validator {
    protected Validator nextValidator = null;
    protected String customMessage = "";

    public String getCustomMessage() {
        return customMessage;
    }

    public void setCustomMessage(String customMessage) {
        this.customMessage = customMessage;
    }
    
    public Validator setNext(Validator validator) {
        this.nextValidator = validator;
        
        return validator;
    }
    
    public ValidatorStatus check() {
        if(this.nextValidator != null) {
            return this.nextValidator.check();
        }
        
        return new SuccessValidatorStatus();
    }
}
