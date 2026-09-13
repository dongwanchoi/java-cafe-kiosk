package com.cafe.kiosk.controller;

import com.cafe.kiosk.service.MenuService;
import com.cafe.kiosk.view.InputView;
import com.cafe.kiosk.view.OutputView;

public class KioskController {
	
	private InputView inputView = new InputView();
	private OutputView outputView = new OutputView();
	private MenuService menuService = new MenuService();

	public KioskController(MenuService menuService, OutputView outputView, InputView inputView) { //생성자
		this.menuService = menuService;
		this.outputView = outputView;
		this.inputView = inputView;
	}

	public void run() {
		//전체 로직 기능 구현
	}
}
