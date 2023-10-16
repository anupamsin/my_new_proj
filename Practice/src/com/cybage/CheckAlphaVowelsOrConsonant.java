package com.cybage;

public class CheckAlphaVowelsOrConsonant {
	public static void main(String[] args) {
		char alpha = 'e';
		char[] charArray = { 'a', 'e', 'i', 'o', 'u' };
		boolean counter=false;
		for (char c : charArray) {
			if (Character.toLowerCase(alpha) == c) {
			counter=true;				
			}
		}
		if(counter) {
			System.out.println(alpha + " is vowel");
		}else {
			System.out.println(alpha + " is consonant");
		}
	}
}
