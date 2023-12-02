package umc.spring.service.MemberService;

import org.springframework.stereotype.Service;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;

import java.util.Optional;



public interface MemberQueryService {

    Optional<Member> findMember(Long id);
    Optional<Mission> findMission(Long id);
}
