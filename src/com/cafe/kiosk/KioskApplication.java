package com.cafe.kiosk;

import com.cafe.kiosk.controller.KioskController;
import com.cafe.kiosk.service.MenuService;
import com.cafe.kiosk.view.InputView;
import com.cafe.kiosk.view.OutputView;

public class KioskApplication {
	public static void main(String[] args) {
        MenuService menuService = new MenuService();
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        
        KioskController kioskController = new KioskController(menuService,outputView, inputView);
        kioskController.run();
    }
}
