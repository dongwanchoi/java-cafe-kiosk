package com.cafe.kiosk.repository;

import java.util.List;

import com.cafe.kiosk.domain.order.Order;

public interface OrderRepository {
	
	List<Order> ItemView(); //장바구니 상품 조회
	Order ItemSomePut(int id, int num); //장바구니 수량 변경
	Order ItemOpstionPut(); //장바구니 옵션 변경
	Order ItemAdd(); //장바구니 상품 추가
	void ItemDelete(int id); //장바구니 상품 삭제
	void ItemDeleteAll(); //장바구니 상품 삭제
	List<Order> payMent(); //결제
	
}
 