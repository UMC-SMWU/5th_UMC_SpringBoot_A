package umc.spring.service.StoreService;

import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.web.dto.StoreRequestDTO;

public interface StoreCommandService {

    Review newReview(Long memberId, Long storeId, StoreRequestDTO.ReviewDTO request);
    Mission newMission(Long storeId, StoreRequestDTO.MissionDTO request);
}
