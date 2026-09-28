package com.cafe.kiosk.repository;

import java.util.ArrayList;
import java.util.List;

import com.cafe.kiosk.domain.order.Order;

public class OrderRepositoryImpl implements OrderRepository {

	private static final List<Order> orderItems = new ArrayList<>();

	public OrderRepositoryImpl() {
	}

	@Override
	public List<Order> ItemView() { // 장바구니 상품 조회
		return new ArrayList<>(orderItems);
	}

	@Override
	public Order ItemSomePut(int id, int num) { // 장바구니 수량 변경
		for (Order orderItem : orderItems) {
			if (orderItem.getId() == id) {
				orderItem.setSome(num);
				return orderItem;
			}
		}
		return null;
	}

	@Override
	public Order ItemAdd(Order order) { // 장바구니 상품 추가
		for (Order orderItem : orderItems) { // 같은 메뉴 + 같은 옵션인지 확인
			if (orderItem.getMenuItem() == order.getMenuItem() && orderItem.getOptions().equals(order.getOptions())) {
				orderItem.setSome(orderItem.getSome() + order.getSome()); // 같은 상품이면 수량만 합침
				return orderItem;
			}
		}
		// 새로운 장바구니 상품이면 id 부여
		order = new Order(orderItems.size() + 1, order.getMenuItem(), order.getMenuCategory(), order.getPrice(), order.getSome(), order.getOptions());
		orderItems.add(order);
		return order;
	}

	@Override
	public void ItemDelete(int id) { // 장바구니 상품 삭제
		for (Order orderItem : orderItems) {
			if (orderItem.getId() == id) {
				orderItems.remove(orderItem);
				return;
			}
		}
	}

	@Override
	public void ItemDeleteAll() { // 장바구니 상품 전체 삭제
		orderItems.clear();
	}

	@Override
	public List<Order> payMent() { // 결제
		return new ArrayList<>(orderItems);
	}
}
