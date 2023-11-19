package com.umc.spring.member_prefer.service;

import com.umc.spring.member_prefer.repository.MemberPreferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberPreferService {
    private final MemberPreferRepository memberPreferRepository;
}
