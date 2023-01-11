package com.myshop.repository;

import static org.assertj.core.api.Assertions.offset;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.TestPropertySource;
import org.thymeleaf.util.StringUtils;

import com.myshop.constant.ItemSellStatus;
import com.myshop.entity.Item;
import com.myshop.entity.QItem;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

@SpringBootTest
@TestPropertySource(locations="classpath:application-test.properties")
class ItemRepositoryTest {

	@Autowired
	ItemRepository itemRepository;
	
	@PersistenceContext		//영속성 context를 사용하기 위해 선언
	EntityManager em;		//엔티티 메니저 불러옴
	
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
	
	public void createItemTest2() {
		
		for(int i=1; i<=5; i++) {
			Item item = new Item();
			item.setItemNm("테스트 상품" + i);
			item.setPrice(10000 + i);
			item.setItemDetail("테스트 상품 상세 설명" + i);
			item.setItemSellStatus(ItemSellStatus.SELL);
			item.setStockNumber(100);
			item.setRegTime(LocalDateTime.now());
			item.setUpdateTime(LocalDateTime.now());
			
		}
		
		for(int i=6; i<=10; i++) {
			Item item = new Item();
			item.setItemNm("테스트 상품" + i);
			item.setPrice(10000 + i);
			item.setItemDetail("테스트 상품 상세 설명" + i);
			item.setItemSellStatus(ItemSellStatus.SOLD_OUT);
			item.setStockNumber(0);
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
//	@Test
//	@DisplayName("상품명, 상품상세설명 or 테스트")
//	public void findByItemNmOrItemDetail() {
//		this.createItemTest();    //item 테이블에 insert
//		List<Item> itemList = itemRepository.findByItemNmOrItemDetail("테스트 상품1", "테스트 상품 상세 설명5");
//		for(Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	@Test
//	@DisplayName("상품가격 N원보다 작은 item")
//	public void findByPriceLessThan() {
//		this.createItemTest();    //item 테이블에 insert
//		List<Item> itemList = itemRepository.findByPriceLessThan(10005);
//		for(Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	}
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
//	@Test
//	@DisplayName("Quiz1")
//	public void findByItemNmAndItemSellStatus() {
//		this.createItemTest();    //item 테이블에 insert
//		List<Item> itemList = itemRepository.findByItemNmAndItemSellStatus("테스트 상품1", ItemSellStatus.SELL);
//		for(Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	}
//	//	@DisplayName("Quiz2")
//	public void findByPriceBetween() {
//		this.createItemTest();    //item 테이블에 insert
//		List<Item> itemList = itemRepository.findByPriceBetween(10004, 10008);
//		for(Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	}
//	@Test
//	@DisplayName("Quiz3")
//	public void findByRegTimeAfter() {
//		this.createItemTest();    //item 테이블에 insert
//		List<Item> itemList = itemRepository.findByRegTimeAfter(LocalDateTime.of(2023,1,1,12,12,44));
//		for(Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	}
//	@Test
//	@DisplayName("Quiz4")
//	public void findByItemSellStatusIsNotNull() {
//		this.createItemTest();    //item 테이블에 insert
//		List<Item> itemList = itemRepository.findByItemSellStatusIsNotNull();
//		for(Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	}
//	@Test
//	@DisplayName("Quiz5")
//	public void findByItemDetailEndingWith() {
//		this.createItemTest();    //item 테이블에 insert
//		List<Item> itemList = itemRepository.findByItemDetailEndingWith("설명1");
//		for(Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	}
	
	
//	@Test
//	@DisplayName("@Query를 이용한 상품 조회 테스트")
//	public void findByItemDetail() {
//		this.createItemTest();
//		List<Item> itemList = itemRepository.findByItemDetail("테스트 상품 상세 설명");
//		for(Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	}
//	
//	@Test
//	@DisplayName("@NativeQuery를 이용한 상품 조회 테스트")
//	public void findByItemDetailByNative() {
//		this.createItemTest();
//		List<Item> itemList = itemRepository.findByItemDetailByNative("테스트 상품 상세 설명");
//		for(Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	}
	
//	@Test
//	@DisplayName("Quiz2-1")
//	public void findByPrice() {
//		this.createItemTest();
//		List<Item> itemList = itemRepository.findByPrice(10005);
//		for(Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	}
//	
//	@Test
//	@DisplayName("Quiz2-2")
//	public void findByItemNmAndItemSellStatus() {
//		this.createItemTest();
//		List<Item> itemList = itemRepository.findByItemNmAndItemSellStatus("테스트 상품1", ItemSellStatus.SELL);
//		for(Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	}
	
//	@Test
//	@DisplayName("querydsl 조회 테스트2")
//		public void queryDslTest2() {
//			this.createItemTest2();
//			BooleanBuilder b = new BooleanBuilder(); 
//			QItem item = QItem.item;
//			Pageable page = PageRequest.of(0, 2);
//			
//			String itemDetail = "테스트 상품 상세 설명";
//			int price = 100003;
//			String itemSellStat = "SELL";
//			
//			b.and(item.itemDetail.like("%"+itemDetail+"%"));
//			b.and(item.price.gt(price));
//			
//			if(StringUtils.equals(itemSellStat, ItemSellStatus.SELL)) {
//				b.and(item.itemSellStatus.eq(ItemSellStatus.SELL));
//			}
//			
//			Pageable page  = PageRequest.of(0,5);	//of(조회할 페이지의 번호, 한 페이지당 조회할 데이터의 개수)
//			Page<Item> itemPageResult = itemRepository.find
//		}
//	@Test
//	@DisplayName("querydsl 조회 테스트")
//		public void queryDslTest() {
//			this.createItemTest2();
//			JPAQueryFactory qf = new JPAQueryFactory(em); 
//			QItem qItem = QItem.item;
//			Pageable page = PageRequest.of(0, 2);	
//			
//			//select * from item where itemSellStatus = 'SELL'
//			JPAQuery<Item> query = qf.selectFrom(qItem)
//									 .where(qItem.itemSellStatus.eq(ItemSellStatus.SELL))
//								     .where(qItem.itemDetail.like("%테스트 상품 상세 설명%"))
//								     .where(qItem.price.gt(10003))
//									 .offset(page.getOffset())
//									 .limit(page.getPageSize());
//			
//			List<Item> itemList = query.fetch();
//			for(Item item : itemList) {
//				System.out.println(item.toString());
//		}	
//	}
	
	//Quiz3
	@Test
	@DisplayName("Quiz3-1")
	public void queryDslQuiz1() {
		this.createItemTest2();
		JPAQueryFactory qf = new JPAQueryFactory(em); 
		QItem qItem = QItem.item;
		
		JPAQuery<Item> query = qf.selectFrom(qItem).where(qItem.itemNm.eq("테스트 상품1")).where(qItem.itemSellStatus.eq(ItemSellStatus.SELL));
		
		List<Item> itemList = query.fetch();
		for(Item item : itemList) {
			System.out.println(item.toString());
		}
	}
	
	@Test
	@DisplayName("Quiz3-2")
	public void queryDslQuiz2() {
		this.createItemTest2();
		JPAQueryFactory qf = new JPAQueryFactory(em); 
		QItem qItem = QItem.item;
		
		JPAQuery<Item> query = qf.selectFrom(qItem).where(qItem.price.between(10004, 10008));
		
		List<Item> itemList = query.fetch();
		for(Item item : itemList) {
			System.out.println(item.toString());
	
		}
	}
	@Test
	@DisplayName("Quiz3-3")
	public void queryDslQuiz3() {
		this.createItemTest2();
		JPAQueryFactory qf = new JPAQueryFactory(em); 
		QItem qItem = QItem.item;
		
		JPAQuery<Item> query = qf.selectFrom(qItem).where(qItem.regTime.after(LocalDateTime.of(2023,1,1,12,12,44)));
		
		List<Item> itemList = query.fetch();
		for(Item item : itemList) {
			System.out.println(item.toString());
		}
	}
	
	@Test
	@DisplayName("Quiz3-4")
	public void queryDslQuiz4() {
		this.createItemTest2();
		JPAQueryFactory qf = new JPAQueryFactory(em); 
		QItem qItem = QItem.item;
		
		JPAQuery<Item> query = qf.selectFrom(qItem).where(qItem.itemSellStatus.isNotNull());
		
		List<Item> itemList = query.fetch();
		for(Item item : itemList) {
			System.out.println(item.toString());
		}
	}
	
	@Test
	@DisplayName("Quiz3-5")
	public void queryDslQuiz5() {
		this.createItemTest2();
		JPAQueryFactory qf = new JPAQueryFactory(em); 
		QItem qItem = QItem.item;
		
		JPAQuery<Item> query = qf.selectFrom(qItem).where(qItem.itemDetail.endsWith("설명1"));
		
		List<Item> itemList = query.fetch();
		for(Item item : itemList) {
			System.out.println(item.toString());
		}
	}
}
