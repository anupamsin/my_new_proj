package com.cybage;

import java.util.Arrays;
import java.util.stream.Collectors;

public class RemoveDuplicateWordsFromString {

	public static void main(String[] args) {
		String str = "  Who am I, I am    Anupam Singh";
		String[] arr = str.replaceAll(",", " ").strip().split("\\s+");
		System.out.println(Arrays.toString(arr));
		String strUpdated = Arrays.stream(arr).distinct().collect(Collectors.joining(" "));
		System.out.println(strUpdated);
	}

}
