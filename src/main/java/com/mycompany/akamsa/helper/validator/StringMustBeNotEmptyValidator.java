/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.akamsa.helper.validator;

/**
 *
 * @author farhannivta
 */
public class StringMustBeNotEmptyValidator extends Validator {
    private String param;

    public StringMustBeNotEmptyValidator(String param) {
        this.param = param;
    }
    
    public StringMustBeNotEmptyValidator(String param, String customMessage) {
        this.param = param;
        this.setCustomMessage(customMessage);
    }
    
    @Override
    public ValidatorStatus check() {
        if(this.param.isBlank()) {
            return new FailedValidatorStatus(this.customMessage);
        }
        
        return super.check();
    }
}
