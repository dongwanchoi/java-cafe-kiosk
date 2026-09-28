package com.cafe.kiosk.domain.order;

import java.util.List;

import com.cafe.kiosk.domain.menu.MenuCategory;
import com.cafe.kiosk.domain.menu.MenuItem;

public class Order {
	int id;
	private MenuCategory menuCategory;
	private MenuItem menuItem;
	private long price;
	private int some;
	private List<String> options;

	public Order(int id, MenuItem menuItem, MenuCategory menuCategory, long price, int some, List<String> options) {
		this.id = id;
		this.menuItem = menuItem;
		this.menuCategory = menuCategory;
		this.price = price;
		this.some = some;
		this.options = options;
	}

	public Order() {
	}

	public void setOrder(Order orderItem) {
		this.id = orderItem.id;
		this.menuCategory = orderItem.menuCategory;
		this.menuItem = orderItem.menuItem;
		this.price = orderItem.price;
		this.some = orderItem.some;
		this.options = orderItem.options;
	}

	public int getId() {
		return id;
	}

	public MenuCategory getMenuCategory() {
		return menuCategory;
	}

	public MenuItem getMenuItem() {
		return menuItem;
	}

	public long getPrice() {
		return price;
	}

	public int getSome() {
		return some;
	}

	public List<String> getOptions() {
		return options;
	}

	public void setSome(int some) {
		this.some = some;
	}

}
