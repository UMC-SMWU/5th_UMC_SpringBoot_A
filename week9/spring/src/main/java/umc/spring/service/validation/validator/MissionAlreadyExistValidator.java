package umc.spring.service.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.MemberService.MemberQueryService;
import umc.spring.service.validation.annotation.ExistMissionAlready;

import java.util.Optional;
@RequiredArgsConstructor
@Component
public class MissionAlreadyExistValidator implements ConstraintValidator<ExistMissionAlready,Long> {

    private final MemberQueryService memberQueryService;



    @Override
    public void initialize(ExistMissionAlready constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {

        Optional<MemberMission> target = memberQueryService.findMemberMission(value);

        if (target.isEmpty() == false){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_ALREADY_EXIST.toString()).addConstraintViolation();

            return false;
        }
        return true;
    }


}
