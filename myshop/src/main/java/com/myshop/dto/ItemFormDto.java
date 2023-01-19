package com.myshop.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.*;

import org.modelmapper.ModelMapper;

import com.myshop.constant.ItemSellStatus;
import com.myshop.entity.Item;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemFormDto {
	
	private Long id;
	
	@NotBlank(message = "상품명은 필수 입력 값입니다.")
	private String itemNm;
	
	@NotNull(message = "가격은 필수 입력 값입니다.")
	private int price;

	@NotNull(message = "재고는 필수 입력 값입니다")
	private int stockNumber;
	
	@NotBlank(message = "상세 설명은 필수 입력 값입니다.")
	private String itemDetail;
	
	private ItemSellStatus itemSellStatus;	//상품 판매 상태
	
	private List<ItemImgDto> itemImgDtoList = new ArrayList<>();	//상품 이미지 정보를 저장하는 list
	
	private List<Long> itemImgIds = new ArrayList<>();	//상품 이미지 아이디를 저장 -> 수정시에 이미지 아이디를 담아 둘 용도.
	
	private static ModelMapper modelMapper = new ModelMapper();
	
	public Item createItem() {
		return modelMapper.map(this, Item.class);
	}
 
	public static ItemFormDto of(Item item) {
		return modelMapper.map(item, ItemFormDto.class);
	}
}
