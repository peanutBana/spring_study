package com.myshop.repository;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;

import com.myshop.dto.ItemSearchDto;
import com.myshop.entity.Item;

//사용자 정의 인터페이스 작성
public interface ItemRepositoryCustom {
	Page<Item> getAdminItemPage(ItemSearchDto itemSearchDto, Pageable pageable);
	
	
}	
