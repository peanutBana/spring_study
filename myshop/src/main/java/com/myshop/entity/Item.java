package com.myshop.entity;

import javax.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

import com.myshop.constant.ItemSellStatus;
import com.myshop.dto.ItemFormDto;
import com.myshop.exception.OutOfStockException;

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
	
	//상품 재고 감소
	public void removeStock(int stockNumber) {
		int restStock = this.stockNumber - stockNumber;
		
		if(restStock < 0) {
			throw new OutOfStockException("상품의 재고가 부족합니다. (현재 재고 수량:" + this.stockNumber + ")");
		}
		this.stockNumber = restStock;	//주문 후 남은 재고 수량을 상품의 재고 값으로 할당
	}
	
	
}
