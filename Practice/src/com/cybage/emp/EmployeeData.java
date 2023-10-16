package com.cybage.emp;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeData{
	
	public static List<Employee> getListOfEmployee(){
		List<Employee> list=new ArrayList<>();
		list.add(new Employee(1,"Anupam",12345.0,27));
		list.add(new Employee(2,"Priyanka",13245.0,26));
		list.add(new Employee(3,"Namita",12305.0,29));
		list.add(new Employee(4,"Ritesh",22345.0,25));
		list.add(new Employee(5,"Anoop",10345.0,23));
		list.add(new Employee(6,"Kajol",12323.0,19));
		list.add(new Employee(7,"Arpit",12987.0,20));
		list.add(new Employee(8,"Kiran",97856.0,35));
		list.add(new Employee(9,"Ram",56987.0,32));
		list.add(new Employee(10,"Priyam",10267.0,31));
		list.add(new Employee(11,"Arjun",97856.0,30));
		return list;
	}
	
	public static Map<Integer,Employee> getMapOfEmployee(){
		Map<Integer,Employee> map=getListOfEmployee().stream().collect(Collectors.toMap(Employee::getId,Employee::getEmployee));
		return map;
	}	
}