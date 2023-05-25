package com.codingrecipe.member.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name="member_table")
public class MemberEntity {
    @Id //pk 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) //sequence
    private Long id;

    @Column(unique = true)
    private String memberEmail;

    @Column
    private String memberName;

    @Column
    private String memberPassword;
}
