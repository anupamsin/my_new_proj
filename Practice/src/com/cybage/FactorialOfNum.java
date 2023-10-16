package com.cybage;

public class FactorialOfNum {

	public static void main(String[] args) {
		// factorial
		/* 
		 * factorial=num*(num-1)
		 */
		
		int num=10;
		long factorial=1;
		for(int i=1;i<=num;i++) {
			factorial=factorial*i;
		}
		
		System.out.println(factorial);
	}

}
