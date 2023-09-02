class TestData{
	public static void main(String[] args){
		EmployeeData.getListOfEmployee().forEach(System.out::println);
		System.out.println("\n");
		EmployeeData.getMapOfEmployee().forEach((k,v)->System.out.println("Key : "+k + ", Value : "+v));
	}
}