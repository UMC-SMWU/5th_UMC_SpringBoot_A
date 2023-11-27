package com.umc.spring.temp.web.controller;

import com.umc.spring.temp.apiPayload.ApiResponse;
import com.umc.spring.temp.apiPayload.code.BaseCode;
import com.umc.spring.temp.converter.TempConverter;
import com.umc.spring.temp.service.TempQueryService;
import com.umc.spring.temp.web.dto.TempResponse;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.aspectj.apache.bcel.classfile.Code;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/temp")
@RequiredArgsConstructor
public class TempRestController {

    private final TempQueryService tempQueryService;

    @GetMapping("/test")
    public ApiResponse<TempResponse.TempTestDTO> testAPI(){

        return ApiResponse.onSuccess(TempConverter.toTempTestDTO());
    }

    @GetMapping("/exception")
    public ApiResponse<TempResponse.TempExceptionDTO> exceptionAPI(@RequestParam Integer flag){
        tempQueryService.CheckFlag(flag);
        return ApiResponse.onSuccess(TempConverter.toTempExceptionDTO(flag));
    }
}
