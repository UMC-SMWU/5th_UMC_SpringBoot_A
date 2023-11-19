package com.umc.spring.member_prefer.repository;

import com.umc.spring.member_prefer.domain.MemberPrefer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberPreferRepository extends JpaRepository<MemberPrefer, Long> {
}
