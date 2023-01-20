package com.myshop.entity;

import javax.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

import com.myshop.constant.ItemSellStatus;
import com.myshop.dto.ItemFormDto;

@Entity
@Table(name="item")	//테이블 명 설정
@Getter
@Setter
@ToString
public class Item extends BaseEntity{
	//not null이 아닐때는 필드 타입을 객체로 지정해야 한다. ex)int -> Integer
	
	@Id
	@Column(name="item_id")
	@GeneratedValue(strategy=GenerationType.AUTO)		//전략 : 기본키를 생성하는 방법
	private Long id;
	
	@Column(nullable=false, length=50)
	private String itemNm;
	
	@Column(nullable=false, name="price")
	private int price;
	
	@Column(nullable=false)
	private int stockNumber;
	
	@Lob
	@Column(nullable=false)
	private String itemDetail;
	
	@Enumerated(EnumType.STRING)
	private ItemSellStatus itemSellStatus;
	
	public void updateItem(ItemFormDto itemFormDto) {
		this.itemNm = itemFormDto.getItemNm();
		this.price = itemFormDto.getPrice();
		this.stockNumber = itemFormDto.getStockNumber();
		this.itemDetail = itemFormDto.getItemDetail();
		this.itemSellStatus = itemFormDto.getItemSellStatus();
	}
	
}
