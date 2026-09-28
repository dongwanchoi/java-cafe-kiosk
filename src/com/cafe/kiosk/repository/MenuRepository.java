package com.cafe.kiosk.repository;

import java.util.ArrayList;
import java.util.List;

import com.cafe.kiosk.domain.menu.MenuCategory;
import com.cafe.kiosk.domain.menu.MenuItem;
import com.cafe.kiosk.domain.menu.MenuOption;

public class MenuRepository {

	private List<MenuItem> menuItems = new ArrayList<>();

	public MenuRepository() {

		// 커피
		menuItems.add(new MenuItem(1, "아메리카노", MenuCategory.COFFEE, 3500,
				List.of(new MenuOption("사이즈", List.of("일반", "L"), List.of(0L, 500L)),
						new MenuOption("얼음량", List.of("일반", "많이", "적게"), List.of(0L, 0L, 0L)),
						new MenuOption("당도", List.of("일반", "더달게", "덜달게"), List.of(0L, 0L, 0L)))));

		menuItems.add(new MenuItem(2, "라떼", MenuCategory.COFFEE, 4000,
				List.of(new MenuOption("사이즈", List.of("일반", "L"), List.of(0L, 500L)),
						new MenuOption("얼음량", List.of("일반", "많이", "적게"), List.of(0L, 0L, 0L)),
						new MenuOption("당도", List.of("일반", "더달게", "덜달게"), List.of(0L, 0L, 0L)))));

		menuItems.add(new MenuItem(3, "에스프레소", MenuCategory.COFFEE, 3000, List.of()));

		// 논커피
		menuItems.add(new MenuItem(4, "디카페인 아메리카노", MenuCategory.NONCOFFEE, 3500,
				List.of(new MenuOption("사이즈", List.of("일반", "L"), List.of(0L, 500L)),
						new MenuOption("얼음량", List.of("일반", "많이", "적게"), List.of(0L, 0L, 0L)),
						new MenuOption("당도", List.of("일반", "더달게", "덜달게"), List.of(0L, 0L, 0L)))));

		menuItems.add(new MenuItem(5, "디카페인 라떼", MenuCategory.NONCOFFEE, 4000,
				List.of(new MenuOption("사이즈", List.of("일반", "L"), List.of(0L, 500L)),
						new MenuOption("얼음량", List.of("일반", "많이", "적게"), List.of(0L, 0L, 0L)),
						new MenuOption("당도", List.of("일반", "더달게", "덜달게"), List.of(0L, 0L, 0L)))));

		menuItems.add(new MenuItem(6, "디카페인 에스프레소", MenuCategory.NONCOFFEE, 3000, List.of()));

		// 디저트
		menuItems.add(new MenuItem(7, "토스트", MenuCategory.DESSERT, 4500, List.of()));
		menuItems.add(new MenuItem(8, "조각케이크", MenuCategory.DESSERT, 5000, List.of()));
		menuItems.add(new MenuItem(9, "크로플", MenuCategory.DESSERT, 4000, List.of()));
	}

	public List<MenuItem> getMenuItems() {
		return new ArrayList<>(menuItems);
	}

}
