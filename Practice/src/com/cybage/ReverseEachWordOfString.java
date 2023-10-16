package com.cybage;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReverseEachWordOfString {

	public static void main(String[] args) {
		String str="My name is Anupam";
		String[] strArr=str.split("\\s+");		
		String revWholeStr="";
		for(String st : strArr) {
			revWholeStr=revWholeStr + reverseStrArr(st)+" ";
		}
		System.out.println(revWholeStr);
		String rev="Anupam";
		String s=Stream.of(rev).map(word->new StringBuilder(word).reverse()).collect(Collectors.joining(""));
		System.out.println(s);
	}

	private static String reverseStrArr(String st) {
		String revArrStr="";
		for(int i=st.length()-1;i>=0;i--) {
			revArrStr=revArrStr+st.charAt(i);
		}
		return revArrStr;
	}

}
