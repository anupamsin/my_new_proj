package com.cybage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EvenLengthWordsFromAString {

	public static void main(String[] args) {
		String str="Hey Buddy what are you doing I am anupam";
		String[] strArray=str.split("\\s+");
		List<String> evenStr=new ArrayList<>();
		System.out.println(Arrays.toString(strArray));
		for(int i=0;i<=strArray.length-1;i++) {
			if(strArray[i].length()%2==0) {
				evenStr.add(strArray[i]);
			}
		}
		System.out.println(Arrays.toString(evenStr.toArray()));
	}

}
