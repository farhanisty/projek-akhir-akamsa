/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.akamsa.helper.validator;

/**
 *
 * @author farhannivta
 */
public class StringMustBeEqualsValidator extends Validator {
    private String firstParam;
    private String secondParam;

    public StringMustBeEqualsValidator(String firstParam, String secondParam) {
        this.firstParam = firstParam;
        this.secondParam = secondParam;
    }
    
     public StringMustBeEqualsValidator(String firstParam, String secondParam, String customMessage) {
        this.firstParam = firstParam;
        this.secondParam = secondParam;
        this.setCustomMessage(customMessage);
    }
    
    @Override
    public ValidatorStatus check() {
        if(!this.firstParam.equals(this.secondParam)) {
            return new FailedValidatorStatus(this.getCustomMessage());
        }
        
        return super.check();
    }
}
