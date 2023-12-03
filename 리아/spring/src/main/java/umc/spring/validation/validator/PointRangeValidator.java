package umc.spring.validation.validator;

import umc.spring.validation.annotation.PointRange;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PointRangeValidator implements ConstraintValidator<PointRange, Float> {

    @Override
    public void initialize(PointRange constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Float point, ConstraintValidatorContext context) {
        return point != null && point >= 0 && point <= 5;
    }
}

