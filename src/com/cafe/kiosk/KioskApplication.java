package com.cafe.kiosk;

import com.cafe.kiosk.controller.KioskController;
import com.cafe.kiosk.repository.OrderRepository;
import com.cafe.kiosk.repository.OrderRepositoryImpl;
import com.cafe.kiosk.service.MenuService;
import com.cafe.kiosk.service.OrderService;
import com.cafe.kiosk.view.InputView;
import com.cafe.kiosk.view.OutputView;

public class KioskApplication {
	public static void main(String[] args) {
		OrderRepository orderRepository = new OrderRepositoryImpl();
		OrderService orderService = new OrderService(orderRepository);
		MenuService menuService = new MenuService();
		InputView inputView = new InputView();
		OutputView outputView = new OutputView(inputView);

		KioskController kioskController = new KioskController(orderService, menuService, outputView, inputView);
		kioskController.run();
	}
}
