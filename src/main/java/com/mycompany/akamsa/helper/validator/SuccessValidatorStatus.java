/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.akamsa.helper.validator;

/**
 *
 * @author farhannivta
 */
public class SuccessValidatorStatus extends ValidatorStatus {

    public SuccessValidatorStatus(String message) {
        this.setStatus(true);
        this.setMessage(message);
    }
    
    public SuccessValidatorStatus() {
        this.setStatus(true);
        this.setMessage("Validation Success");
    }
}
