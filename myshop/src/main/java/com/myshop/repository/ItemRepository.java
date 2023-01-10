package com.myshop.repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myshop.constant.ItemSellStatus;
import com.myshop.entity.Item;

//JpaRepository : 기본적인 CRUD 및 페이징 처리를 위한 메소드가 정의 되어있다.
//JpaRepository<사용할 엔티티 클래스, 기본키 타입>{
public interface ItemRepository extends JpaRepository<Item, Long>{
	
	//select * from item where item_nm = ?
	List<Item> findByItemNm(String itemNm);
	
	//select * from item where item_nm = ? or item_Deatil = ?
	List<Item> findByItemNmOrItemDetail(String itemNm, String itemDetail);
	
	//select * from item where price < ? 
	List<Item> findByPriceLessThan(Integer price);
	
	//select * from item where price < ? order by price desc 
	List<Item> findByPriceLessThanOrderByPriceDesc(Integer price);
	
	//QUIZ
	//1
	List<Item> findByItemNmAndItemSellStatus(String ItemNm, ItemSellStatus iss);
	
	//2
	List<Item> findByPriceBetween(int price, int price2);
	
	//3
	List<Item> findByRegTimeAfter(LocalDateTime regTime);
	
	//4
	List<Item> findByItemSellStatusIsNotNull();
	
	//5
	List<Item> findByItemDetailEndingWith(String ItemDeatil);
	
}
