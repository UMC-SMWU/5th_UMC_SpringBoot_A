package umc.spring.web.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MissionConverter;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.service.StoreService.StoreCommandService;
import umc.spring.service.validation.annotation.ExistMember;
import umc.spring.service.validation.annotation.ExistStore;
import umc.spring.web.dto.StoreRequestDTO;
import umc.spring.web.dto.StoreResponseDTO;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreCommandService storeCommandService;

    @PostMapping("/{storeId}/reviews")
    public ApiResponse<StoreResponseDTO.newReviewResultDTO> newReview(@RequestBody @Valid StoreRequestDTO.ReviewDTO request,
                                                                      @ExistStore @PathVariable(name = "storeId") Long storeId,
                                                                      @ExistMember @RequestParam(name = "memberId") Long memberId){
        Review review = storeCommandService.newReview(memberId, storeId, request);
        return ApiResponse.onSuccess(ReviewConverter.tonewReviewResultDTO(review));
    }

    @PostMapping("/{storeId}/missions")
    public ApiResponse<StoreResponseDTO.newMissionResultDTO> newMission(@RequestBody @Valid StoreRequestDTO.MissionDTO request,
                                                             @ExistStore @PathVariable(name = "storeId") Long storeId) {
        Mission mission = storeCommandService.newMission(storeId, request);
        return ApiResponse.onSuccess(MissionConverter.tonewMissionResultDTo(mission));
    }
}
