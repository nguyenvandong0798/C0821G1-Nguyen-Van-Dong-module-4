package com.codegym.casestudy.common.idcard;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IdCardValidator implements ConstraintValidator<IdCardConstraint, String> {

    @Override
    public void initialize(IdCardConstraint constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.matches("^[0-9]{9}$");
    }

}
