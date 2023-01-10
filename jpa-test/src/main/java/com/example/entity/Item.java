package com.example.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Item {
	@Id
	@Column(name="item_id")
	private Long id;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false)
	private int price;
	
	@Column(nullable=false)
	private int stockQuantity;
}
