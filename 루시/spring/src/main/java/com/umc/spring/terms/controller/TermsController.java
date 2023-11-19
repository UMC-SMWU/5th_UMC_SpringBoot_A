package com.umc.spring.terms.controller;

import com.umc.spring.terms.service.TermsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TermsController {
    private final TermsService termsService;
}
