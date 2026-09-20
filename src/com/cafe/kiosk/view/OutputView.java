package com.cafe.kiosk.view;

import java.util.List;

import com.cafe.kiosk.domain.menu.MenuCategory;
import com.cafe.kiosk.domain.menu.MenuItem;
import com.cafe.kiosk.domain.order.Order;

public class OutputView {

	private InputView inputView;

	public OutputView(InputView inputView) {
		this.inputView = inputView;
	}

	public void printMenuCategory(List<MenuCategory> menuCategorys) { // 카테고리 선택
		System.out.println("메뉴 카테고리를 선택하세요.");
		// 출력 기능 구현
	}

	public void printMenuItems(List<MenuItem> menuItems) { // 메뉴 선택
		System.out.println("상품을 선택하세요.");
		// 출력 기능 구현
	}
	
	
	//-----------------장바구니----------------------
	public void printOrder() { // 장바구니 메뉴 선택
		System.out.println("=========장바구니=========");
		System.out.println("* 전체 상품 조회");
		
		System.out.println("1. 상품 수량 변경");
		System.out.println("2. 상품 옵션 변경");
		System.out.println("3. 상품 삭제");
		System.out.println("4. 상품 전체 삭제");
		System.out.println("5. 상품 추가 하기");
		System.out.println("6. 결제하기");
		// 출력 기능 구현
	}

	public void printOrderView(List<Order> orderItems) { // 장바구니 상품 조회
		System.out.println("장바구니 상품조회 ============");
		for (Order orderItem : orderItems) {
			 System.out.printf("id: %-3d | 카테고리: %-12s | 상품: %-15s | 가격: %-6d | 수량: %-2d | 금액: %-7d%n",
		                orderItem.getId(),
		                orderItem.getMenuCategory(),
		                orderItem.getMenuItem(),
		                orderItem.getPrice(),
		                orderItem.getSome(),
		                (orderItem.getSome()*orderItem.getPrice()));
		}
	}

	public void printItemSomePut(Order orderItem) { // 장바구니 수량 변경
		System.out.println("============수정된 상품============");
		System.out.printf("id: %-3d | 카테고리: %-12s | 상품: %-15s | 가격: %-6d | 수량: %-2d%n",
                orderItem.getId(),
                orderItem.getMenuCategory(),
                orderItem.getMenuItem(),
                orderItem.getPrice(),
                orderItem.getSome());
				System.out.println();
	}

	public Order printItemOpstionPut() { // 장바구니 옵션 변경
		return null;
	}

	public Order printItemAdd() {// 장바구니 상품 추가
		return null;
	}

	public void printItemDelete() { // 장바구니 상품 삭제
		System.out.println("삭제 완료");
	}

	public void pirntPayMent() { // 결제
		System.out.println("결제하기");
	}
	
	public void pirntPayMentOpstion(int totalPrice) { // 장바구니 메뉴 선택
		System.out.println("=========장바구니=========");
		System.out.println("결제할 총 금액 : " +totalPrice);
		System.out.println("결제수단을 선택하세요.");
		System.out.println("1. 신용카드");
		System.out.println("2. 현금");
		System.out.println("0. 뒤로 가기");
	}
	////-----------------장바구니----------------------
}
