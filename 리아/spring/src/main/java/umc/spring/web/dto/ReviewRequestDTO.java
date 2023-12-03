package umc.spring.web.dto;

import lombok.Getter;

public class ReviewRequestDTO {

    @Getter
    public static class ReviewAddDto{
        Long store;
        Float point;
        String comment;
    }

}
