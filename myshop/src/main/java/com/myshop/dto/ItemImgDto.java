package com.myshop.dto;

import org.modelmapper.ModelMapper;

import com.myshop.entity.ItemImg;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemImgDto {
	private Long id;
	
	private String imgName;
	
	private String oriImgName;
	
	private String imgUrl;		
	
	private String repimgYn;
	
	private static ModelMapper modelMapper = new ModelMapper();
	
	public static ItemImgDto of(ItemImg itemImg) {
		return modelMapper.map(itemImg, ItemImgDto.class);
	}
	
}
