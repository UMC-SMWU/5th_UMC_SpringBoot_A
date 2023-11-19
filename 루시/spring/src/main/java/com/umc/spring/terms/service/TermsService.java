package com.umc.spring.terms.service;

import com.umc.spring.terms.repository.TermsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TermsService {
    private final TermsRepository termsRepository;
}
