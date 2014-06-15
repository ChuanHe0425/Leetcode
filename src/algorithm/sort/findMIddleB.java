package algorithm.sort;

import java.util.Scanner;

public class findMIddleB {
	public static int getMidNum(int a, int b, int c) {

		return (a < b ? (b < c ? b : a < c ? c : a) : (b > c ? b : a > c ? c
		: a));
		}
	public static void main(String[] args) {

		final Scanner scanner = new Scanner(System.in);
		
	
		System.out.println("Input an integer:");
		int a = scanner.nextInt();
		
		System.out.println("Input an integer:");
		int b = scanner.nextInt();
		
		System.out.println("Input an integer:");
		int c = scanner.nextInt();
		
			
				System.out.println("Medium: " + b);
		
	}
}
