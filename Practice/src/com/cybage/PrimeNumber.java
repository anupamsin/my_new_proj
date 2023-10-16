package com.cybage;

public class PrimeNumber {

	public static void main(String[] args) {
		int num = 38;
		int counter = 0;
		if (num <= 1) {
			System.out.println("Number is not prime");
		} else {
			for (int i = 2; i <= num; i++) {
				if (num % i == 0) {
					counter++;
				}
			}
			if (counter > 1) {
				System.out.println("Number is not prime");
			} else
				System.out.println("Number is prime");
		}

	}

}
