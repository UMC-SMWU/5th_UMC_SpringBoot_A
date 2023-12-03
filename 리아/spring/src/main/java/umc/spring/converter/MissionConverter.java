package umc.spring.converter;

import umc.spring.domain.Mission;
import umc.spring.web.dto.MemberResponseDTO;

import java.time.LocalDateTime;

public class MissionConverter {

    public static MemberResponseDTO.MissionResultDTO toMissionResultDTO(Mission mission) {
        return MemberResponseDTO.MissionResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
