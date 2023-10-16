package com.cybage;

public class PalindromeStringNNum {

	public static void main(String[] args) {
		String str="Madam";
		System.out.println(str);
		String revStr="";
		for(int i=str.length()-1;i>=0;i--) {
			revStr+=str.charAt(i);
		}		
		if(str.equalsIgnoreCase(revStr)) {
			System.out.println("String is Palindrome");
		}else {
			System.out.println("String is not palindrome");
		}
		
		int num=5335;
		int originalNum=num;
		System.out.println(num);
		int revNumer=0, remainder;
		while(num!=0) {
			remainder=num%10;  // 1001%10=1   100%10=0  10%10=0 1%10=1
			revNumer=revNumer*10+remainder; // revNum=1 revNum=10 revNum=100 revNum=1001
			num=num/10; // 100 10 1 0			
		}
		if(originalNum==revNumer) {
			System.out.println("Number is palindrome");
		}else {
			System.out.println("Number is not palindrome");
		}
	}

}
