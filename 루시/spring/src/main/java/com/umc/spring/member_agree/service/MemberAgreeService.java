package com.umc.spring.member_agree.service;

import com.umc.spring.member_agree.repository.MemberAgreeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberAgreeService {
    private final MemberAgreeRepository memberAgreeRepository;
}
