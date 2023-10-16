package com.cybage.emp;

class Employee{
	private Integer id;
	private String name;
	private double salary;
	private int age;
	
	public Employee(Integer id, String name, double salary, int age){
		this.id=id;
		this.name=name;
		this.salary=salary;
		this.age=age;
	}
	
	public Integer getId(){
		return id;
	}
	
	public String getName(){
		return name;
	}
	
	public double getSalary(){
		return salary;
	}
	
	public int getAge(){
		return age;
	}
	
	public void setId(Integer id){
		this.id=id;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public void setSalary(double salary){
		this.salary=salary;
	}
	
	public void setAge(int age){
		this.age=age;
	}
	
	@Override
	public String toString(){
		return "ID : "+ id + ", Name : "+ name + ", Salary : "+ salary + ", Age : "+age;
	}

	public Employee getEmployee() {
		return new Employee(id,name,salary,age);
	}
}