package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Member2 {
	
	@Id
	@Column(name="member_id")
	private Long id;
	
	@Column(nullable=false)
	private String name;
	@Column(nullable=false)
	private String city;
	@Column(nullable=false)
	private String street;
	@Column(nullable=false)
	private String zipcode;
}
