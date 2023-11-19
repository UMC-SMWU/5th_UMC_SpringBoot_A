package com.umc.spring.member_agree.repository;

import com.umc.spring.member_agree.domain.MemberAgree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberAgreeRepository extends JpaRepository<MemberAgree, Long> {
}
