package umc.spring.domain;

import lombok.*;
import umc.spring.domain.common.BaseEntity;
import umc.spring.domain.mapping.MemberMission;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer reward;

    private LocalDate deadline;

    @Column(nullable = false, length = 40)
    private String missionSpec;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

   @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL)
   private List<MemberMission> memberMissionList = new ArrayList<>();

   public void setStore(Store store){
       if(this.store != null){
           store.getReviewList().remove(this);
       }
       this.store = store;
       store.getMissionList().add(this);
   }
}
