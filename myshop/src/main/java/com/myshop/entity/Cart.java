package com.myshop.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="cart")	//테이블 명 설정
@Getter
@Setter
@ToString
public class Cart {
	@Id
	@Column(name = "cart_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@OneToOne(fetch = FetchType.LAZY)	//부모테이블 Member와 1대1 관계 명시
	@JoinColumn(name = "member_id")
	private Member member;
	
	
}
