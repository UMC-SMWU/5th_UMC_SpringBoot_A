package umc.spring.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.FoodCategoryHandler;
import umc.spring.apiPayload.exception.handler.MissionHandler;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberMissionRepository;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.StoreRepository;

import java.util.Optional;

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
        // 이미 CHALLENGING 상태인 MemberMission이 있는지 확인
        Optional<MemberMission> existingMission = memberMissionRepository.findByMemberIdAndMissionIdAndStatus(
                memberId, missionId, MissionStatus.CHALLENGING);

        if (existingMission.isPresent()) {
            throw new MissionHandler(ErrorStatus.MISSION_ALREADY_EXIST);
        }

        MemberMission memberMission = MemberMission.builder()
                .status(MissionStatus.CHALLENGING)
                .build();

        memberMission.setMember(memberRepository.findById(memberId).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.MEMBER_NOT_FOUND)));
        memberMission.setMission(missionRepository.findById(missionId).orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND)));
        return memberMissionRepository.save(memberMission);
    }
}