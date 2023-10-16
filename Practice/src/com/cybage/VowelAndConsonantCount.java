package com.cybage;

public class VowelAndConsonantCount {

	public static void main(String[] args) {
		String str = "Hello World";
		String vowelArr = "aeiou";
		char[] strCharArr = str.toCharArray();
		int vowelCounter = 0;
		int consonantCounter = 0;		
		
		for(char c : strCharArr) {
			if(Character.toLowerCase(c)>='a' && Character.toLowerCase(c)<='z') {
				if (vowelArr.indexOf(c)!=-1) {
					vowelCounter++;
				}else {
					consonantCounter++;
				}
			}
		}
		System.out.println("Vowels : " + vowelCounter + ", Consonant : " + consonantCounter);

	}

}
