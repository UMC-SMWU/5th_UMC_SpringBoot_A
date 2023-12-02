package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MemberConverter;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Store;
import umc.spring.service.MemberService.MemberCommandService;
import umc.spring.service.StoreService.StoreCommandService;
import umc.spring.web.dto.MemberRequestDTO;
import umc.spring.web.dto.MemberResponseDTO;
import umc.spring.web.dto.StoreRequestDTO;
import umc.spring.web.dto.StoreResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreCommandService storeCommandService;

    @PostMapping("/")
    public ApiResponse<StoreResponseDTO.StoreAddResultDTO> join(@RequestBody @Valid StoreRequestDTO.StoreAddDto request){
        Store store = storeCommandService.addStore(request);
        return ApiResponse.onSuccess(StoreConverter.toStoreAddResultDTO(store));
    }
}
