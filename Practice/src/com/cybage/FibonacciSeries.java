package com.cybage;

import java.util.Arrays;

public class FibonacciSeries {

	public static void main(String[] args) {
		/*
		 *  10 num tak fibonacci
		 *  10=0,1,1,2,3,5,8,13,21,34
		 *  0+1=1->1+1=2->2+1=3....n so on
		 */
		System.out.println("Enter length to which you want to generate fibonacci");
		int length=10;
		System.out.println("Length of Fibonacci : "+length);
		int firstNum=0;
		int secondNum=1;
		int[] intArr=new int[length];
		for(int i=1;i<=length;i++) {
			intArr[i-1]=firstNum;
			int nextNum=firstNum+secondNum;
			firstNum=secondNum;
			secondNum=nextNum;
		}
		
		System.out.println(Arrays.toString(intArr));
	}

}
