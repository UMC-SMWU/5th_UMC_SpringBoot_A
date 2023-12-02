package umc.spring.service.StoreService;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.converter.MissionConverter;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.ReviewRepository;
import umc.spring.repository.StoreRepository;
import umc.spring.web.dto.StoreRequestDTO;

@Service
@Transactional
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService{

    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;
    private final MissionRepository missionRepository;
    private final ReviewRepository reviewRepository;

    @Override
    public Review newReview(Long memberId, Long storeId, StoreRequestDTO.ReviewDTO request){
        Review review = ReviewConverter.toReview(request);
        review.setMember(memberRepository.findById(memberId).get());
        review.setStore(storeRepository.findById(storeId).get());

        return reviewRepository.save(review);
    }
    @Override
    public Mission newMission(Long storeId, StoreRequestDTO.MissionDTO request) {
        Mission mission = MissionConverter.toMission(request);
        mission.setStore(storeRepository.findById(storeId).get());

        return missionRepository.save(mission);
    }

}
