package com.cafe.kiosk.domain.menu;

import java.util.List;

public class MenuItem { // 메뉴 상품
	private int id;
	private String name;
	private MenuCategory menuCategory;
	private long price;
	private List<MenuOption> menuOptions;

	public MenuItem(int id, String name, MenuCategory menuCategory, long price, List<MenuOption> menuOptions) {
		this.id = id;
		this.name = name;
		this.menuCategory = menuCategory;
		this.price = price;
		this.menuOptions = menuOptions;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public MenuCategory getMenuCategory() {
		return menuCategory;
	}

	public long getPrice() {
		return price;
	}

	public List<MenuOption> getMenuOptions() {
		return menuOptions;
	}

}
