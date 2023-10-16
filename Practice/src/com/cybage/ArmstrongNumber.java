package com.cybage;

public class ArmstrongNumber {
	public static void main(String[] args) {
		int num = 371, revNum = 0, remainder;
		int originalNum = num;
		while (num > 0) {
			remainder = num % 10;
			revNum += Math.pow(remainder, 3);
			num = num / 10;
		}
		if (originalNum == revNum) {
			System.out.println("Number is Armstrong");
		}else {
			System.out.println("Number is not Armstrong");
		}
	}
}
