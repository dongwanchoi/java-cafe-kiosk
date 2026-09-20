package com.cafe.kiosk.service;

import java.util.List;

import com.cafe.kiosk.domain.order.Order;
import com.cafe.kiosk.repository.OrderRepository;
import com.cafe.kiosk.view.InputView;

public class OrderService {

	private OrderRepository orderRepository;

	public OrderService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	public List<Order> ItemView() { // 장바구니 상품 조회
		return orderRepository.ItemView();
	}

	public Order ItemSomePut(int id, int num) { // 장바구니 수량 변경
		return orderRepository.ItemSomePut(id, num);
	}

	public Order ItemOpstionPut() { // 장바구니 옵션 변경
		return null;
	}

	public Order ItemAdd() {// 장바구니 상품 추가
		return null;
	}

	public void ItemDelete(int id) { // 장바구니 상품 삭제
		orderRepository.ItemDelete(id);
	}

	public void ItemDeleteAll() { // 장바구니 상품 삭제
		orderRepository.ItemDeleteAll();
	}

	public int payMent() { // 결제하기
		int total = 0;
		for (Order orderItem : orderRepository.payMent()) {
			total += (orderItem.getPrice() * orderItem.getSome());
		}
		return total;
	}
}
