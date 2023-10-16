package com.cybage;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class TimeMenu {
	public static void main(String[] args) {
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
		String time=dateFormat.format(LocalDate.now().toString());
		System.out.println(time);
	}
}
