package java_overload;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import javax.naming.spi.DirStateFactory.Result;

public class Main {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayList<Integer> listNumber = new ArrayList<Integer>();
		listNumber.add(15);
		listNumber.add(12);
		listNumber.add(97);
		listNumber.add(96);
		listNumber.add(2515);

		System.out.println("Smallest number in list: " + findSmallestNumber(listNumber));
		System.out.println("Smallest number: " + findSmallestNumber(15, 12));

		int month;
		do {
			System.out.print("Plase enter the month: ");
			month = scanner.nextInt();
		} while (month < 1 || month > 12);
//		getDayOfMonth(month);
		printTriangle(month);
		printEquilateralTriangle(month);
		printEmptyEquilateralTriangle(month);
		totalNumber(3456);
	}

	public static int findSmallestNumber(int a, int b) {
		return a <= b ? a : b;
	}

	public static int findSmallestNumber(ArrayList<Integer> listNumber) {
		// Collections.sort(listNumber);
		// return listNumber.get(0);
		// or
		Collections.sort(listNumber, Collections.reverseOrder());
		return listNumber.get(listNumber.size() - 1);
	}

	public static void getDayOfMonth(int month) {
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println("This month have 31 day");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println("This month have 30 day");
			break;
		case 2:
			System.out.print("Plase enter the year you want to check: ");
			int year = scanner.nextInt();
			System.out.println("This month have " + (checkFullYear(year) ? 29 : 28) + " day");
			break;
		}
	}

	public static boolean checkFullYear(int year) {
		if (year % 400 == 0 || (year % 100 != 0 && year % 4 == 0))
			return true;
		return false;
	}

	public static void printTriangle(int height) {
		for (int i = 1; i <= height; i++) {
			for (int j = 1; j <= i; j++) {
				int numberPrint = i % 2 == 0 ? (j % 2 == 0 ? 1 : 0) : (j % 2 == 0 ? 0 : 1);
				System.out.print(numberPrint);
			}
			System.out.println();
		}
	}

	public static void printEquilateralTriangle(int height) {
		for (int i = 0; i < height; i++) {
			for (int j = 1; j < height; j++) {
				System.out.print(j >= height - i ? " * " : "   ");
			}
			System.out.print(" * ");
			for (int j = height + 1; j <= height * 2 - 1; j++) {
				System.out.print(j > height + i ? "   " : " * ");
			}
			System.out.println();
		}
	}

	public static void printEmptyEquilateralTriangle(int height) {
		System.out.println();
		System.out.println();
		for (int i = 0; i < height; i++) {
			if (i == 0) {
				for (int j = 1; j <= height * 2 - 1; j++) {
					System.out.print(j == height ? " * " : "   ");
				}
			} else if (i == height - 1) {
				for (int j = 1; j <= height * 2 - 1; j++) {
					System.out.print(" * ");
				}
			} else {
				for (int j = 1; j < height; j++) {
					System.out.print(j == height - i ? " * " : "   ");
				}
				System.out.print("   ");
				for (int j = height + 1; j <= height * 2 - 1; j++) {
					System.out.print(j == height + i ? " * " : "   ");
				}
			}
			System.out.println();
		}
	}

	public static void totalNumber (int number) {
		if (number < 10) {
			System.out.println("\n" + number);
			return;
		}
			
		int result = 0;
		while (number > 0) {
			result += number % 10;
			number = number / 10;
		}
		System.out.println("\n" + result);
	}
}
