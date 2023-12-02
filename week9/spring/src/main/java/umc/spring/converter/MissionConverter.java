package umc.spring.converter;

import umc.spring.domain.Mission;
import umc.spring.web.dto.StoreRequestDTO;
import umc.spring.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;

public class MissionConverter {

    public static Mission toMission(StoreRequestDTO.MissionDTO request){
        return Mission.builder()
                .reward(request.getReward())
                .deadline(request.getDeadline())
                .missionSpec(request.getMissionSpec())
                .build();
    }

    public static StoreResponseDTO.newMissionResultDTO tonewMissionResultDTo (Mission mission){
        return StoreResponseDTO.newMissionResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
