package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

public class StoreRequestDTO {
    @Getter
    public static class ReviewDTO{

        @NotBlank
        String body;
        @NotNull
        float score;
    }

    @Getter
    public static class MissionDTO{
        @NotNull
        int reward;
        LocalDate deadline;
        @NotBlank
        String missionSpec;

    }
}
