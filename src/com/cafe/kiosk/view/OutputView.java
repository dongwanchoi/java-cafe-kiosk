package com.cafe.kiosk.view;

import java.util.List;

import com.cafe.kiosk.domain.menu.MenuCategory;
import com.cafe.kiosk.domain.menu.MenuItem;
import com.cafe.kiosk.domain.menu.MenuOption;
import com.cafe.kiosk.domain.order.Order;

public class OutputView {

	private InputView inputView;

	public OutputView(InputView inputView) {
		this.inputView = inputView;
	}

	//-----------------메뉴 선택----------------------
	public void printMenuCategory(List<MenuCategory> menuCategories) { // 메뉴 카테고리 선택
		System.out.println("=========메뉴 카테고리=========");
		for (int i = 0; i < menuCategories.size(); i++) {
			System.out.println((i + 1) + ". " + menuCategories.get(i));
		}
		System.out.println("0. 주문 완료");
	}

	public void printMenuItems(List<MenuItem> menuItems) { // 메뉴 선택
		System.out.println("=========메뉴=========");
		for (int i = 0; i < menuItems.size(); i++) {
			MenuItem menuItem = menuItems.get(i);
			System.out.printf("%d. %-20s %d원%n",
					i + 1,
					menuItem.getName(),
					menuItem.getPrice());
		}
		System.out.println("0. 이전 화면");
	}
	
	public void printMenuOption(MenuOption menuOption) { // 메뉴 옵션 선택
		System.out.println("========= " + menuOption.getOptionName() + " =========");
		for (int i = 0; i < menuOption.getOptionValues().size(); i++) {
			String optionValue = menuOption.getOptionValues().get(i);
			long additionalPrice = menuOption.getAdditionalPrice(i);
			if (additionalPrice > 0) {
				System.out.println((i + 1) + ". " + optionValue + " (+" + additionalPrice + "원)");
			} else {
				System.out.println((i + 1) + ". " + optionValue);
			}
		}
	}
	////-----------------메뉴 선택----------------------
	
	//-----------------장바구니----------------------
	public void printOrder() { // 장바구니 메뉴 선택
		System.out.println("=========장바구니=========");
		System.out.println("1. 상품 추가");
		System.out.println("2. 상품 수량 변경");
		System.out.println("3. 상품 삭제");
		System.out.println("4. 상품 전체 삭제");
		System.out.println("5. 결제하기");
		System.out.println("0. 종료");
	}

	public void printOrderView(List<Order> orderItems) { // 장바구니 상품 조회
		for (Order orderItem : orderItems) {
			System.out.printf("id: %-3d | 카테고리: %-12s | 상품: %-10s | 옵션: %-15s | 가격: %-6d | 수량: %-2d | 금액: %-7d%n",
		                orderItem.getId(),
		                orderItem.getMenuCategory(),
		                orderItem.getMenuItem().getName(),
		                orderItem.getOptions(),
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
                orderItem.getMenuItem().getName(),
                orderItem.getPrice(),
                orderItem.getSome());
				System.out.println();
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
