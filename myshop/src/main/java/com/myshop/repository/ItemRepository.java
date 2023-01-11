package com.myshop.repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
	
//	List<Item> findByItemNmAndItemSellStatus(String ItemNm, ItemSellStatus iss);
//	List<Item> findByPriceBetween(int price, int price2);
//	List<Item> findByRegTimeAfter(LocalDateTime regTime);
//	List<Item> findByItemSellStatusIsNotNull();
//	List<Item> findByItemDetailEndingWith(String ItemDeatil);
	
//	@Query("select i from Item i where i.itemDetail like %:itemDetail% order by i.price desc")
//	List<Item> findByItemDetail(@Param("itemDetail")String itemDetail);
	
	@Query("select i from Item i where i.itemDetail like %?1% order by i.price desc")
	List<Item> findByItemDetail(String itemDetail);
	
	@Query(value="select * from item i where i.item_detail like %:itemDetail% order  by i.price desc", nativeQuery=true)
	List<Item> findByItemDetailByNative(@Param("itemDetail")String itemDetail);
	
}
