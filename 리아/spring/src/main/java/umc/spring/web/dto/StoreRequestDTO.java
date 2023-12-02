package umc.spring.web.dto;

import lombok.Getter;

public class StoreRequestDTO {

    @Getter
    public static class StoreAddDto{
        String name;
        String address;
        Float score;
        Long region;
    }
}
