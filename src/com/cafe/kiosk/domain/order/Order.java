package com.cafe.kiosk.domain.order;

public class Order {
	int id;
//	private MenuCategory menuCategory;
//	private MenuItem menuItem;
	private String menuCategory;
	private String menuItem;
	private long price;
	private int some;

	public Order(int id, String menuItem, String menuCategory, long price, int some) {
		this.id = id;
		this.menuCategory = menuCategory;
		this.menuItem = menuItem;
		this.price = price;
		this.some = some;
	}

	public Order() {
	}

	public void setOrder(Order orderItem) {
		this.id = orderItem.id;
		this.menuCategory = orderItem.menuCategory;
		this.menuItem = orderItem.menuItem;
		this.price = orderItem.price;
		this.some = orderItem.some;
	}

	public long getId() {
		return id;
	}

	public String getMenuCategory() {
		return menuCategory;
	}

	public String getMenuItem() {
		return menuItem;
	}

	public long getPrice() {
		return price;
	}

	public int getSome() {
		return some;
	}

	public void setSome(int some) {
		this.some = some;
	}

}
