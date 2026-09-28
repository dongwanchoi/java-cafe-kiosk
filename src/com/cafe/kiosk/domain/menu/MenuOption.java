package com.cafe.kiosk.domain.menu;

import java.util.List;

public class MenuOption {

	private String optionName;
	private List<String> optionValues;
	private List<Long> additionalPrices;

	public MenuOption(String optionName, List<String> optionValues, List<Long> additionalPrices) {
		this.optionName = optionName;
		this.optionValues = optionValues;
		this.additionalPrices = additionalPrices;
	}

	public String getOptionName() {
		return optionName;
	}

	public List<String> getOptionValues() {
		return optionValues;
	}

	public long getAdditionalPrice(int index) {
		return additionalPrices.get(index);
	}

}
