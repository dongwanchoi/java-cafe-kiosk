package com.cafe.kiosk.view;

import java.util.List;

import com.cafe.kiosk.domain.menu.MenuCategory;
import com.cafe.kiosk.domain.menu.MenuItem;

public class OutputView {
	
	public void printMenuCategory(List<MenuCategory> menuCategorys) { //카테고리 선택
		System.out.println("메뉴 카테고리를 선택하세요.");
		//출력 기능 구현
	}
	
	public void printMenuItems(List<MenuItem> menuItems) { //메뉴 선택
		System.out.println("상품을 선택하세요.");
		//출력 기능 구현
	}
}
