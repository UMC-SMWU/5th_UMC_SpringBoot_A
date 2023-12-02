package umc.spring.converter;

import umc.spring.domain.Review;
import umc.spring.web.dto.StoreRequestDTO;
import umc.spring.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;

public class ReviewConverter {

    public static Review toReview(StoreRequestDTO.ReviewDTO request){
        return Review.builder()
                .body(request.getBody())
                .score(request.getScore())
                .build();
    }

    public static StoreResponseDTO.newReviewResultDTO tonewReviewResultDTO(Review review){
        return StoreResponseDTO.newReviewResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();



    }
}
