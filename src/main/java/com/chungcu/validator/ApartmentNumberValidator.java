/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chungcu.validator;

import com.chungcu.services.ApartmentService;
import javax.persistence.NoResultException;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author tien
 */
public class ApartmentNumberValidator implements ConstraintValidator<ApartmentNumber, String> {

    @Autowired
    private ApartmentService apartmentService;

    @Override
    public void initialize(ApartmentNumber constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        try {
            return apartmentService.checkApartmentNumber(value);
        } catch (NoResultException ex) {
            return false;
        }
    }

}
