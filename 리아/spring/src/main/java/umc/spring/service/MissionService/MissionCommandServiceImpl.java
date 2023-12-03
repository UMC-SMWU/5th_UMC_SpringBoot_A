package umc.spring.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberMissionRepository;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.StoreRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionCommandServiceImpl implements MissionCommandService  {

    private final StoreRepository storeRepository;

    private final MissionRepository missionRepository;
    private final MemberRepository memberRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    @Transactional
    public MemberMission addMissionToStore(Long memberId, Long missionId) {
        MemberMission memberMission = MemberMission.builder()
                .status(MissionStatus.CHALLENGING)
                .build();

        memberMission.setMember(memberRepository.findById(memberId).get());
        memberMission.setMission(missionRepository.findById(missionId).get());

        return memberMissionRepository.save(memberMission);
    }

}