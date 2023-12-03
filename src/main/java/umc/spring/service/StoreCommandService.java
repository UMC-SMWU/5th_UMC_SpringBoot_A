package umc.spring.service;

import umc.spring.domain.Review;
import umc.spring.web.dto.StoreRequestDTO;

public interface StoreCommandService {

    Review createReview(Long memberId, Long storeId, StoreRequestDTO.ReviewDTO request);
}
