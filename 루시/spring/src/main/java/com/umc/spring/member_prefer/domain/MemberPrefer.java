package com.umc.spring.member_prefer.domain;

import com.umc.spring.common.BaseEntity;
import com.umc.spring.food_category.domain.FoodCategory;
import com.umc.spring.member.domain.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class MemberPrefer extends BaseEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "memberId")
    private Member member;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "categoryId")
    private FoodCategory foodCategory;
}
