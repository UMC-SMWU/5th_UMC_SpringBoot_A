package umc.umcspring.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.umcspring.domain.common.BaseEntity;
import umc.umcspring.domain.enums.Gender;
import umc.umcspring.domain.enums.MemberStatus;
import umc.umcspring.domain.enums.SocialType;
import umc.umcspring.domain.mapping.MemberAgree;
import umc.umcspring.domain.mapping.MemberMission;
import umc.umcspring.domain.mapping.MemberPrefer;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 20)
    private String name;
    @Column(nullable = false, length = 40)
    private String address;
    @Column(nullable = false, length = 40)
    private String specAddress;
    private LocalDate inactiveDate;
    @Column(nullable = false, length = 50)
    private String email;
    private Integer point;
    private Integer age;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private Gender gender;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'")
    private MemberStatus status;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private SocialType socialType;

    //양방향 매핑
    @OneToMany(mappedBy="member", cascade = CascadeType.ALL)
    private List<MemberAgree> memberAgreeList = new ArrayList<MemberAgree>();
    @OneToMany(mappedBy="member", cascade = CascadeType.ALL)
    private List<MemberPrefer> memberPreferList = new ArrayList<MemberPrefer>();
    @OneToMany(mappedBy="member", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList = new ArrayList<MemberMission>();
    @OneToMany(mappedBy="member", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<Review>();
}
