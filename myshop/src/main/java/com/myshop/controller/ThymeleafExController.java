package com.myshop.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myshop.dto.ItemDto;

@Controller		//컨트롤러의 역할을하는 클래스를 정의
@RequestMapping(value="/thymeleaf")		//url 경로 지정
public class ThymeleafExController {
	
	@GetMapping(value="/ex01")
	public String thymeleafEx01(Model model) {
		model.addAttribute("data", "타임리프 예제 입니다.");
		
		return "thymeleafEx/thymeleafEx01";
	}
	
	@GetMapping(value="/ex02")
	public String thymeleafEx02(Model model) {
		ItemDto itemDto = new ItemDto();
		itemDto.setItemNm("테스트 상품");
		itemDto.setPrice(10000);
		itemDto.setItemDetail("테스트 상품 상세 설명");
		itemDto.setRegTime(LocalDateTime.now());
		
		model.addAttribute("itemDto",itemDto);
		
		return "thymeleafEx/thymeleafEx02";
	}
	
	@GetMapping(value="/ex03")
	public String thymeleafEx03(Model model) {
		List<ItemDto> itemDtoList = new ArrayList<>(); 
		
		for(int i=1; i<=10; i++) {
			ItemDto itemDto = new ItemDto();
			itemDto.setItemNm("테스트 상품" + i);
			itemDto.setPrice(10000 + i);
			itemDto.setItemDetail("테스트 상품 상세 설명" + i);
			itemDto.setRegTime(LocalDateTime.now());	
			
			itemDtoList.add(itemDto);
		}
		model.addAttribute("itemDtoList",itemDtoList);
		
		return "thymeleafEx/thymeleafEx03";
	}
	
	@GetMapping(value="/ex04")
	public String thymeleafEx04(Model model) {
		List<ItemDto> itemDtoList = new ArrayList<>(); 
		
		for(int i=1; i<=10; i++) {
			ItemDto itemDto = new ItemDto();
			itemDto.setItemNm("테스트 상품" + i);
			itemDto.setPrice(10000 + i);
			itemDto.setItemDetail("테스트 상품 상세 설명" + i);
			itemDto.setRegTime(LocalDateTime.now());	
			
			itemDtoList.add(itemDto);
		}
		model.addAttribute("itemDtoList",itemDtoList);
		
		return "thymeleafEx/thymeleafEx04";
	}
	
	@GetMapping(value="/ex05")
	public String thymeleafEx05(Model model) {
		
		return "thymeleafEx/thymeleafEx05";
	}
}
