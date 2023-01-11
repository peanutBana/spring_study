package com.myshop.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.myshop.constant.ItemSellStatus;
import com.myshop.entity.Item;

@SpringBootTest
@TestPropertySource(locations="classpath:application-test.properties")
class ItemRepositoryTest {

	@Autowired
	ItemRepository itemRepository;
	
//	public void createItemTest() {
//		Item item = new Item();
//		item.setItemNm("테스트 상품");
//		item.setPrice(10000);
//		item.setItemDetail("테스트 상품 상세 설명");
//		item.setItemSellStatus(ItemSellStatus.SELL);
//		item.setStockNumber(100);
//		item.setRegTime(LocalDateTime.now());
//		item.setUpdateTime(LocalDateTime.now());
//		
//		Item savedItem = itemRepository.save(item);		//data insert
//
//		
//	}
	
	public void createItemTest() {
			
		for(int i=1; i<=10; i++) {
			Item item = new Item();
			item.setItemNm("테스트 상품" + i);
			item.setPrice(10000 + i);
			item.setItemDetail("테스트 상품 상세 설명" + i);
			item.setItemSellStatus(ItemSellStatus.SELL);
			item.setStockNumber(100);
			item.setRegTime(LocalDateTime.now());
			item.setUpdateTime(LocalDateTime.now());
			
			Item savedItem = itemRepository.save(item);		//data insert
		}
	}
	
//	@Test
//	@DisplayName("상품명 조회 테스트")
//	public void findByItemNmTest() {
//		this.createItemTest();    //item 테이블에 insert
//		List<Item> itemList = itemRepository.findByItemNm("테스트 상품1");
//		for(Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	}
//	
//	@Test
//	@DisplayName("상품명, 상품상세설명 or 테스트")
//	public void findByItemNmOrItemDetail() {
//		this.createItemTest();    //item 테이블에 insert
//		List<Item> itemList = itemRepository.findByItemNmOrItemDetail("테스트 상품1", "테스트 상품 상세 설명5");
//		for(Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	}
//	
//	@Test
//	@DisplayName("상품가격 N원보다 작은 item")
//	public void findByPriceLessThan() {
//		this.createItemTest();    //item 테이블에 insert
//		List<Item> itemList = itemRepository.findByPriceLessThan(10005);
//		for(Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	}
//	
//	@Test
//	@DisplayName("상품가격 내림차순")
//	public void findByPriceLessThanOrderByPriceDesc() {
//		this.createItemTest();    //item 테이블에 insert
//		List<Item> itemList = itemRepository.findByPriceLessThanOrderByPriceDesc(10005);
//		for(Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	}
	
	
	//Quiz
	
	@Test
	@DisplayName("Quiz1")
	public void findByItemNmAndItemSellStatus() {
		this.createItemTest();    //item 테이블에 insert
		List<Item> itemList = itemRepository.findByItemNmAndItemSellStatus("테스트 상품1", ItemSellStatus.SELL);
		for(Item item : itemList) {
			System.out.println(item.toString());
		}
	}
	
	@Test
	@DisplayName("Quiz2")
	public void findByPriceBetween() {
		this.createItemTest();    //item 테이블에 insert
		List<Item> itemList = itemRepository.findByPriceBetween(10004, 10008);
		for(Item item : itemList) {
			System.out.println(item.toString());
		}
	}
	
	@Test
	@DisplayName("Quiz3")
	public void findByRegTimeAfter() {
		this.createItemTest();    //item 테이블에 insert
		List<Item> itemList = itemRepository.findByRegTimeAfter(LocalDateTime.of(2023,1,1,12,12,44));
		for(Item item : itemList) {
			System.out.println(item.toString());
		}
	}
	
	@Test
	@DisplayName("Quiz4")
	public void findByItemSellStatusIsNotNull() {
		this.createItemTest();    //item 테이블에 insert
		List<Item> itemList = itemRepository.findByItemSellStatusIsNotNull();
		for(Item item : itemList) {
			System.out.println(item.toString());
		}
	}
	
	@Test
	@DisplayName("Quiz5")
	public void findByItemDetailEndingWith() {
		this.createItemTest();    //item 테이블에 insert
		List<Item> itemList = itemRepository.findByItemDetailEndingWith("설명1");
		for(Item item : itemList) {
			System.out.println(item.toString());
		}
	}

}
