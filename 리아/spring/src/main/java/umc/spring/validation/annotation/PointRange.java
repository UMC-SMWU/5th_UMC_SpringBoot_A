package umc.spring.validation.annotation;

import umc.spring.validation.validator.PointRangeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PointRangeValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PointRange {
    String message() default "Point value must be between 0 and 5";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
