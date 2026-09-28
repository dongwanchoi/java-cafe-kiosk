package com.cafe.kiosk.view;

import java.util.Scanner;

public class InputView { // 사용자 입력 값 받기

	private final Scanner scanner = new Scanner(System.in);

	public int readNumber() {
		return scanner.nextInt();
	}
}
