package com.umc.spring.member_mission.repository;

import com.umc.spring.member_mission.domain.MemberMission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
}
