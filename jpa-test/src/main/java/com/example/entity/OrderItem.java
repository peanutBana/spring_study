package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class OrderItem {
	@Id
	@Column(name="order_item_id")
	private Long id;

	@Column(nullable=false)
	private Long orderId;
	
	@Column(nullable=false)
	private Long itemId;
	
	@Column(nullable=false)
	private int orderPrice;
	
	@Column(nullable=false)
	private int count;
}
