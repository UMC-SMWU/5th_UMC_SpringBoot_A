package umc.spring.domain;

import lombok.*;
import umc.spring.domain.Member;
import umc.spring.domain.common.BaseEntity;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Builder

public class Review extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private Float score;


    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member;

//    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
//    private List<MemberMission> memberMissionList = new ArrayList<>();
}
