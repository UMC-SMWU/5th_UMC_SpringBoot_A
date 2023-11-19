package com.umc.spring.member.domain;

import com.umc.spring.common.BaseEntity;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@NoArgsConstructor(access = PROTECTED)
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(length = 20)
    private String name;

    @Column(length = 10)
    @Enumerated(STRING)
    private Gender gender;

    private int age;

    @Embedded
    private Address address;

    @Embedded
    private Address spec_address;

    @Column(length = 10)
    @Enumerated(STRING)
    private SocialType socialType;
}
