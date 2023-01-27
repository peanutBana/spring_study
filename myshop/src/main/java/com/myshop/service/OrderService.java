package com.myshop.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myshop.dto.OrderDto;
import com.myshop.dto.OrderHistDto;
import com.myshop.dto.OrderItemDto;
import com.myshop.entity.Item;
import com.myshop.entity.ItemImg;
import com.myshop.entity.Member;
import com.myshop.entity.Order;
import com.myshop.entity.OrderItem;
import com.myshop.repository.ItemImgRepository;
import com.myshop.repository.ItemRepository;
import com.myshop.repository.MemberRepository;
import com.myshop.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service //service 클래스의 역할
@Transactional //서비스 클래서에서 로직을 처리하다가 에러가 발생하면 로직을 수행하기 이전 상태로 되돌려 준다. 
@RequiredArgsConstructor
public class OrderService {
	private final ItemRepository itemRepository;
	private final MemberRepository memberRepository;
	private final OrderRepository orderRepositorty;
	private final ItemImgRepository itemImgRepositorty;
	
	public Long order(OrderDto orderDto, String email) {
		Item item = itemRepository.findById(orderDto.getItemId())
                .orElseThrow(EntityNotFoundException::new);
		
		Member member = memberRepository.findByEmail(email);
		
		List<OrderItem> orderItemList = new ArrayList<>(); 
		OrderItem orderItem = OrderItem.createOrderItem(item, orderDto.getCount());
		orderItemList.add(orderItem);
		
		Order order = Order.createOrder(member, orderItemList);
		orderRepositorty.save(order);
		
		return order.getId();
	}
	
	@Transactional(readOnly = true)
	public Page<OrderHistDto> getOrderList(String email, Pageable pageable) {
		
		List<Order> orders = orderRepositorty.findOrders(email, pageable); //주문 목록
		Long totalCount= orderRepositorty.countOrder(email); //총 주문 목록 갯수
		
		List<OrderHistDto> orderHistDtos = new ArrayList<>();
		
		for (Order order : orders) {
			OrderHistDto orderHistDto = new OrderHistDto(order);
			List<OrderItem> orderItems = order.getOrderItems();
			
			for (OrderItem orderItem : orderItems) {
				//상품의 대표 이미지
				ItemImg itemImg = itemImgRepositorty.findByItemIdAndRepimgYn(orderItem.getItem().getId(), "Y");
				OrderItemDto orderItemDto = new OrderItemDto(orderItem, itemImg.getImgUrl());
				orderHistDto.addOrderItemDto(orderItemDto);
			}
			
			orderHistDtos.add(orderHistDto);
		}
		
		return new PageImpl<OrderHistDto>(orderHistDtos, pageable, totalCount);
	}
	
}