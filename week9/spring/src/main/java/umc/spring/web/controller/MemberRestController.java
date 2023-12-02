package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MemberConverter;
import umc.spring.domain.Member;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.MemberService.MemberCommandService;
import umc.spring.service.validation.annotation.ExistMission;
import umc.spring.service.validation.annotation.ExistMissionAlready;
import umc.spring.web.dto.MemberRequestDTO;
import umc.spring.web.dto.MemberResponseDTO;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }

    @PostMapping("/missions/{missionId}")
    public ApiResponse<MemberResponseDTO.newMemberMissionResultDTO> newMemberMission(@ExistMission @ExistMissionAlready @PathVariable(name = "missionId")Long missionId,
                                                                                     @RequestParam(name = "memberId") Long memberId){
        MemberMission memberMission = memberCommandService.newMemberMission(memberId,missionId);
        return ApiResponse.onSuccess(MemberConverter.tonewMemberMissionResultDTO(memberMission));
    }
}
