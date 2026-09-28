package com.cafe.kiosk.service;

import java.util.ArrayList;
import java.util.List;

import com.cafe.kiosk.domain.menu.MenuCategory;
import com.cafe.kiosk.domain.menu.MenuItem;
import com.cafe.kiosk.repository.MenuRepository;

public class MenuService {

	private MenuRepository menuRepository;

	public MenuService() {
		this.menuRepository = new MenuRepository();
	}

	public List<MenuCategory> getMenuCategories() { // 메뉴 카테고리 조회
		return List.of(MenuCategory.values());
	}

	public List<MenuItem> getMenuItems(MenuCategory menuCategory) { // 카테고리에 따른 메뉴 조회
		List<MenuItem> menuItems = new ArrayList<>();

		for (MenuItem menuItem : menuRepository.getMenuItems()) {
			if (menuItem.getMenuCategory() == menuCategory) {
				menuItems.add(menuItem);
			}
		}
		return menuItems;
	}

	public MenuItem getMenuItem(int id) { // 메뉴 조회
		for (MenuItem menuItem : menuRepository.getMenuItems()) {
			if (menuItem.getId() == id) {
				return menuItem;
			}
		}
		return null;
	}

}
