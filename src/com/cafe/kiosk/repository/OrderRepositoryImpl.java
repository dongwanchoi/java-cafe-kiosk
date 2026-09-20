package com.cafe.kiosk.repository;

import java.util.ArrayList;
import java.util.List;

import com.cafe.kiosk.domain.order.Order;

public class OrderRepositoryImpl implements OrderRepository {

	private static final List<Order> orderItems = new ArrayList<>();

	public OrderRepositoryImpl() {
		this.orderItems.add(new Order(1, "아메리카노", "COFFEE", 3500, 1));
		this.orderItems.add(new Order(2, "라떼", "COFFEE", 4000, 1));
		this.orderItems.add(new Order(3, "에스프레소", "COFFEE", 3000, 2));
		this.orderItems.add(new Order(4, "디카페인 아메리카노", "NONCOFFEE", 3500, 3));
		this.orderItems.add(new Order(5, "디카페인 라떼", "NONCOFFEE", 4000, 4));
		this.orderItems.add(new Order(6, "디카페인 에스프레소", "NONCOFFEE", 3000, 5));
		this.orderItems.add(new Order(7, "토스트", "DESSERT", 4500, 6));
		this.orderItems.add(new Order(8, "조각케이크", "DESSERT", 5000, 7));
		this.orderItems.add(new Order(9, "크로플", "DESSERT", 4000, 8));
		this.orderItems.add(new Order(10, "크로플", "DESSERT", 4000, 8));
	}

	public List<Order> ItemView() { // 장바구니 상품 조회
		List<Order> orderItems = new ArrayList<>(this.orderItems);
		return orderItems;
	}

	public Order ItemSomePut(int id, int num) { // 장바구니 수량 변경
		for (Order orderItem : orderItems) {
			if (orderItem.getId() == id) {
				orderItem.setSome(num);
				return orderItem;
			}
		}
		return null;
	}

	public Order ItemOpstionPut() { // 장바구니 옵션 변경
		return null;
	}

	public Order ItemAdd() {// 장바구니 상품 추가
		return null;
	}

	public void ItemDelete(int id) { // 장바구니 상품 삭제
		System.out.println(id);
		orderItems.remove(id - 1);
	}

	public void ItemDeleteAll() { // 장바구니 상품 전체 삭제
		orderItems.removeAll(orderItems);
	}

	public List<Order> payMent() { // 결제
		return orderItems;
	}

}
