package umc.spring.service.MissionService;

import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.mapping.MemberMission;

public interface MissionCommandService {
    @Transactional
    MemberMission addMissionToStore(Long memberId, Long missionId);
}
