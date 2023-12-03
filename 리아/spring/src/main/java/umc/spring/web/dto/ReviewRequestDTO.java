package umc.spring.web.dto;

import lombok.Getter;
import umc.spring.validation.annotation.ExistStores;
import umc.spring.validation.annotation.PointRange;

import javax.validation.constraints.Size;

public class ReviewRequestDTO {

    @Getter
    public static class ReviewAddDto{
        @ExistStores
        Long store;
        @PointRange
        Float point;
        String comment;
    }

}
