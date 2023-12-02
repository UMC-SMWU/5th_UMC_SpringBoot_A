package umc.spring.service.validation.annotation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.spring.service.validation.validator.MissionAlreadyExistValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MissionAlreadyExistValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistMissionAlready {
    String message() default "해당 미션은 이미 도전중입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
