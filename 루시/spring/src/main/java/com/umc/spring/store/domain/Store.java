package com.umc.spring.store.domain;

import com.umc.spring.common.BaseEntity;
import com.umc.spring.member.domain.Address;
import com.umc.spring.region.domain.Region;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.*;
import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Store extends BaseEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "regionId")
    private Region region;

    @Column(length = 50)
    private String name;

    @Embedded
    private Address address;

    private Float score;
}
