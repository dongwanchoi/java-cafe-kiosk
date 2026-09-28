package com.cafe.kiosk.controller;

import java.util.ArrayList;
import java.util.List;

import com.cafe.kiosk.domain.menu.MenuCategory;
import com.cafe.kiosk.domain.menu.MenuItem;
import com.cafe.kiosk.domain.menu.MenuOption;
import com.cafe.kiosk.domain.order.Order;
import com.cafe.kiosk.service.MenuService;
import com.cafe.kiosk.service.OrderService;
import com.cafe.kiosk.view.InputView;
import com.cafe.kiosk.view.OutputView;

public class KioskController {

	private InputView inputView;
	private OutputView outputView;
	private MenuService menuService;
	private OrderService orderService;

	public KioskController(OrderService orderService, MenuService menuService, OutputView outputView,
			InputView inputView) {
		this.orderService = orderService;
		this.menuService = menuService;
		this.outputView = outputView;
		this.inputView = inputView;
	}

	public void run() {
		System.out.println("카페키오스크");
		System.out.println("1.주문하기 2.장바구니");
		int start = inputView.readNumber();
		switch (start) {
		case 1:
			ItemAdd();
		case 2:
			orderMain();
			break;
		default:
			System.out.println("잘못입력 종료.");
		}
	}
	// ----------------- 장바구니 ----------------------
	private void orderMain() {
		while (true) {
			ItemView();
			outputView.printOrder();
			int start = inputView.readNumber();
			switch (start) {
			case 1:
				ItemAdd();
				break;
			case 2:
				ItemSomePut();
				break;
			case 3:
				ItemDelete();
				break;
			case 4:
				ItemDeleteAll();
				break;
			case 5:
				payment();
				break;
			case 0:
				System.out.println("종료합니다.");
				System.exit(0);
			default:
				System.out.println("잘못입력하셨습니다.");
			}
		}
	}

	private void ItemValidation() { // 상품 있는지 검사
		List<Order> orderItems = orderService.ItemView();
		if (orderItems.size() == 0) {
			System.out.println("상품이 없습니다. 메뉴로 돌아갑니다.");
			return;
		}
	}

	private void ItemView() { // 장바구니 상품 조회
		outputView.printOrderView(orderService.ItemView());
	}

	private void ItemSomePut() { // 장바구니 수량 변경
		ItemValidation();
		System.out.println("수량 변경할 상품 id를 입력하세요.");
		int id = inputView.readNumber();
		System.out.println("변경할 수량을 입력하세요.");
		int updateSome = inputView.readNumber();
		outputView.printItemSomePut(orderService.ItemSomePut(id, updateSome));
	}

	private void ItemAdd() { // 장바구니 상품 추가
		// ---------------- 카테고리 선택 ----------------
		List<MenuCategory> menuCategories = menuService.getMenuCategories();
		outputView.printMenuCategory(menuCategories);
		int categoryNumber = inputView.readNumber();
		if (categoryNumber == 0)
			return;
		
		if (categoryNumber < 1 || categoryNumber > menuCategories.size()) {
			System.out.println("잘못된 카테고리 번호입니다.");
			return;
		}
		MenuCategory menuCategory = menuCategories.get(categoryNumber - 1);
		// ---------------- 메뉴 선택 ----------------
		List<MenuItem> menuItems = menuService.getMenuItems(menuCategory);
		outputView.printMenuItems(menuItems);
		int menuNumber = inputView.readNumber();
		if (menuNumber == 0)
			return;

		if (menuNumber < 1 || menuNumber > menuItems.size()) {
			System.out.println("잘못된 메뉴 번호입니다.");
			return;
		}

		MenuItem menuItem = menuItems.get(menuNumber - 1);
		// ---------------- 옵션 선택 ----------------
		List<String> options = new ArrayList<>();
		long optionPrice = 0;
		for (MenuOption menuOption : menuItem.getMenuOptions()) {
			outputView.printMenuOption(menuOption);
			int optionNumber = inputView.readNumber();
			if (optionNumber < 1 || optionNumber > menuOption.getOptionValues().size()) {
				System.out.println("잘못된 옵션 번호입니다.");
				return;
			}
			String optionValue = menuOption.getOptionValues().get(optionNumber - 1);
			long additionalPrice = menuOption.getAdditionalPrice(optionNumber - 1);
			options.add(menuOption.getOptionName() + ": " + optionValue);
			optionPrice += additionalPrice;
		}

		// ---------------- 수량 입력 ----------------
		System.out.println("수량을 입력하세요.");
		int quantity = inputView.readNumber();
		if (quantity < 1) {
			System.out.println("수량은 1개 이상 입력해주세요.");
			return;
		}

		// ---------------- 장바구니 선택 ----------------
		System.out.println("=========장바구니=========");
		System.out.println("1. 장바구니 담기");
		System.out.println("2. 취소");

		int choice = inputView.readNumber();

		if (choice == 2) {
			System.out.println("상품 추가를 취소합니다.");
			return;
		}

		if (choice != 1) {
			System.out.println("잘못입력하셨습니다.");
			return;
		}

		// ---------------- Order 생성 ----------------
		long price = menuItem.getPrice() + optionPrice;
		Order order = new Order(0, menuItem, menuCategory, price, quantity, options);
		// ---------------- 장바구니 추가 ----------------
		orderService.ItemAdd(order);
		System.out.println("장바구니에 상품이 추가되었습니다.");
	}

	private void ItemDelete() { // 상품 삭제
		ItemValidation();
		System.out.println("삭제할 상품 id를 입력하세요.");
		int id = inputView.readNumber();
		orderService.ItemDelete(id);
		outputView.printItemDelete();
	}

	private void ItemDeleteAll() { // 상품 전체 삭제
		orderService.ItemDeleteAll();
	}
	// ----------------- 결제 ----------------------
	private void payment() { // 결제하기
		ItemValidation();
		while (true) {
			int totalPrice = orderService.payMent();
			outputView.pirntPayMentOpstion(totalPrice);
			int choice = inputView.readNumber();
			switch (choice) {
			case 1:
				paymentCard();
				break;
			case 2:
				paymentCash(totalPrice);
				break;
			case 0:
				System.out.println("결제를 취소하고 이전 화면으로 돌아갑니다.");
				return;
			default:
				System.out.println("잘못입력하셨습니다.");
				continue;
			}
			return;
		}
	}

	private void paymentCard() { // 카드 결제
		ItemValidation();
		orderService.ItemDeleteAll();
		System.out.println("신용카드 결제가 완료되었습니다.");
		System.out.println("이용해주셔서 감사합니다. 맛있는 음료가 준비되면 호출해 드리겠습니다!\n");
	}

	private void paymentCash(int totalPrice) { // 현금 결제
		ItemValidation();
		System.out.println("현금을 입력하세요.");
		int cash = inputView.readNumber();
		if (cash < totalPrice) {
			System.out.println("금액이 부족합니다. 결제가 취소됩니다.");
			return;
		}
		System.out.println("거스름돈 " + (cash - totalPrice) + "원입니다. 결제가 완료되었습니다.");
		orderService.ItemDeleteAll();
		System.out.println("이용해주셔서 감사합니다. 맛있는 음료가 준비되면 호출해 드리겠습니다!\n");
	}
}
