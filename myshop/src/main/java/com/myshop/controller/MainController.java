package com.myshop.controller;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.myshop.dto.ItemSearchDto;
import com.myshop.dto.MainItemDto;
import com.myshop.service.ItemService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {
	private final ItemService itemService;

	@GetMapping(value="/")
	public String main(ItemSearchDto itemSearchDto, Optional<Integer> page, Model model ){
		Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 6);		//한 페이지당 가져올 아이템 개수
		Page<MainItemDto> items = itemService.getMainItemPage(itemSearchDto, pageable) ;
		
		model.addAttribute("items", items);
		model.addAttribute("itemSearchDto", itemSearchDto);
		model.addAttribute("maxPage", 5);
		
		return "main";
	}
}
