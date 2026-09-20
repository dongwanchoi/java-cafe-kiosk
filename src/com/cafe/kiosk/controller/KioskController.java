package com.cafe.kiosk.controller;

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
			InputView inputView) { // 생성자
		this.orderService = orderService;
		this.menuService = menuService;
		this.outputView = outputView;
		this.inputView = inputView;
	}

	public void run() {
		// 전체 로직 기능 구현
		orderMain();// 장바구니 기능 추가
	}

	//-----------------장바구니----------------------
	private void orderMain() {
		while (true) {
			ItemView();
			outputView.printOrder();
			int start = inputView.readNumber();
			switch (start) {
			case 1:
				ItemSomePut(); // 상품 수량 변경
				break;
			case 2:
				// 상품 옵션 변경
				break;
			case 3:
				ItemDelete(); // 상품 삭제
				break;
			case 4:
				ItemDeleteAll(); // 상품 전체 삭제
				break;
			case 5:
				// 상품 추가하기 > 주문하기와 동일 >카테고리 화면 보여주기
				break;
			case 6:
				payment();// 결제하기
				break;
			default:
				System.out.println("잘못입력함");
			}
		}
	}

	private void ItemView() { // 장바구니 상품 조회
		outputView.printOrderView(orderService.ItemView());
	}

	private void ItemSomePut() { // 장바구니 상품 수량 변경
		System.out.println("수량 변경할 상품 id를 입력하세요.");
		int id = inputView.readNumber();
		System.out.println("변경할 수량을 입력하세요.");
		int updateSome = inputView.readNumber();
		outputView.printItemSomePut(orderService.ItemSomePut(id, updateSome));
	}

	private void ItemOpstionPut() { // 장바구니 옵션 변경
		//메뉴 카테고리 미구현
	}

	private void ItemAdd() { // 장바구니 상품 추가
		//메뉴 추가기능 미구현
	}

	private void ItemDelete() { // 장바구니 상품 삭제
		System.out.println("수량 변경할 상품 id를 입력하세요.");
		int id = inputView.readNumber();
		orderService.ItemDelete(id);
		outputView.printItemDelete();
	}

	private void ItemDeleteAll() { // 상품 전체 삭제
		orderService.ItemDeleteAll();
	}
	////-----------------결제----------------------

	//-----------------결제----------------------
	private void payment() { //결제하기
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
				System.out.println("잘못입력하셨습니다. 결제를 취소합니다.");
			}
		    System.out.println("이용해주셔서 감사합니다. 맛있는 음료가 준비되면 호출해 드리겠습니다!\n");
		    return;
		}
	}

	private void paymentCard() { // 카드 결제
		orderService.ItemDeleteAll();
		System.out.println("신용카드 결제가 완료되었습니다.");
	}
	
	private void paymentCash(int totalPrice) { // 현금 결제
		System.out.println("현금을 입력하세요");;
		int cash = inputView.readNumber();
		if(cash < totalPrice) {
			System.out.println("금액이 부족합니다. 결제가 취소 됩니다.");
			return;
		}
		System.out.println("거스름돈 "+(cash - totalPrice)+ "원입니다. 결제가 완료되었습니다.");
		orderService.ItemDeleteAll();
	}
	////-----------------결제----------------------
	
}
