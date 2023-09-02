import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

class MenuDrivenEmployee {
	public static void main(String[] args) {
		Map<Integer, Employee> map = EmployeeData.getMapOfEmployee();
		try (Scanner scanner = new Scanner(System.in)) {
			boolean mainFlag = true;
			while (mainFlag) {
				System.out.println("\n Choose Option");
				System.out.println("1. Enter an employee");
				System.out.println("2. Delete Employee");
				System.out.println("3. View Employee");
				System.out.println("4. Stream Operations");
				System.out.println("5. Sorting");
				System.out.println("0. xxx-ExiT--xxx");
				switch (scanner.nextInt()) {
				case 1:
					System.out.println("Enter employee details");
					System.out.println("Enter employee id");
					Integer id = scanner.nextInt();
					if (map.containsKey(id)) {
						System.out.println("Employee Id : " + id + " already registered");
					} else {
						System.out.println("Enter employee name");
						String name = scanner.next();
						System.out.println("Enter employee salary");
						double salary = scanner.nextDouble();
						System.out.println("Enter employee age");
						int age = scanner.nextInt();
						map.put(id, new Employee(id, name, salary, age));
						System.out.println(name + " added successfully");
					}
					break;

				case 2:
					System.out.println("Enter employee id to delete");
					int empId = scanner.nextInt();
					if (map.containsKey(empId)) {
						map.remove(empId);
					} else {
						System.out.println("Employee Id : " + empId + " not found");
					}
					break;

				case 3:
					System.out.println("Employees List \n");
					map.forEach(
							(k, v) -> System.out.println("Employee ID : " + k + ", Employee Details : " + v + "\n"));
					break;

				case 4:
					boolean internalFlag = true;
					while (internalFlag) {
						System.out.println("Choose Option");
						System.out.println("1. Find Employee By Id");
						System.out.println("2. Find Employee By Name");
						System.out.println("3. Find Employee By First Character in Name");
						System.out.println("4. Find Employee b/w salary range");
						System.out.println("5. Find Employee b/w age range");
						System.out.println("6. Find Employee b/w id range");
						System.out.println("7. Find Employees whose salary below/above average salary");
						System.out.println("8. Find Employees Nth highest/lowest salary");
						System.out.println("0. xxx--ExiT--xxx");
						switch (scanner.nextInt()) {
						case 1:
							System.out.println("Enter employee id");
							int empid = scanner.nextInt();
							if (map.containsKey(empid)) {
								map.values().stream().filter(obj -> obj.getId() == empid).forEach(System.out::println);
							} else {
								System.out.println("Employee Not Present");
							}
							break;

						case 2:
							System.out.println("Enter employee name");
							String empname = scanner.next();
							List<Employee> empList = map.values().stream()
									.filter(obj -> obj.getName().toLowerCase().equals(empname.toLowerCase()))
									.collect(Collectors.toList());
							if (empList.size() > 0) {
								empList.forEach(System.out::println);
							} else {
								System.out.println("\nEmployee with name : " + empname + " is not present");
							}
							break;

						case 3:
							System.out.println("Enter char of name");
							char empChar = scanner.next().toLowerCase().charAt(0);
							List<Employee> list = map.values().stream()
									.filter(obj -> obj.getName().toLowerCase().charAt(0) == empChar)
									.collect(Collectors.toList());
							if (list.size() > 0) {
								list.forEach(System.out::println);
							} else {
								System.out.println("\nEmployee with char : " + empChar + " is not present");
							}
							break;

						case 4:
							System.out.println("Enter salary range to filter data");
							double lower = scanner.nextDouble();
							double upper = scanner.nextDouble();
							List<Employee> listSal = map.values().stream()
									.filter(obj -> obj.getSalary() >= lower && obj.getSalary() <= upper)
									.collect(Collectors.toList());
							if (listSal.size() > 0) {
								listSal.forEach(System.out::println);
							} else {
								System.out.println("\n No Employees In the Given Salary Range");
							}
							break;

						case 5:
							System.out.println("Enter age range to filter data");
							int lowerAge = scanner.nextInt();
							int upperAge = scanner.nextInt();
							List<Employee> listAge = map.values().stream()
									.filter(obj -> obj.getAge() >= lowerAge && obj.getAge() <= upperAge)
									.collect(Collectors.toList());
							if (listAge.size() > 0) {
								listAge.forEach(System.out::println);
							} else {
								System.out.println("\n No Employees In the Given Age Range");
							}
							break;

						case 6:
							System.out.println("Enter id range to filter data");
							int lowerId = scanner.nextInt();
							int upperId = scanner.nextInt();
							List<Employee> listId = map.values().stream()
									.filter(obj -> obj.getId() >= lowerId && obj.getId() <= upperId)
									.collect(Collectors.toList());
							if (listId.size() > 0) {
								listId.forEach(System.out::println);
							} else {
								System.out.println("\n No Employees In the Given ID Range");
							}
							break;

						case 7:
							double avgSal = map.values().stream().mapToDouble(obj -> obj.getSalary()).average()
									.getAsDouble();
							// System.out.println(avgSal);
							System.out.println("Choose to Show Salary according to selected option");
							System.out.println("Please Write Option below/above");
							String opt = scanner.next();
							if (opt.toLowerCase().equals("below")) {
								map.values().stream().filter(obj -> obj.getSalary() <= avgSal)
										.forEach(System.out::println);
							} else if (opt.toLowerCase().equals("above")) {
								map.values().stream().filter(obj -> obj.getSalary() >= avgSal)
										.forEach(System.out::println);
							} else {
								System.out.println("Invalid Option Written....Please Chose From below/above");
							}
							break;

						case 8:
							System.out.println("Choose b/w Nth highest or lowest salary");
							System.out.println("Please Write Option highest/lowest");
							String option = scanner.next();
							Set<Double> set = new TreeSet<>();
							map.values().stream().forEach(obj -> set.add(obj.getSalary()));
							if (option.toLowerCase().equals("highest")) {
								System.out.println("Enter value of Nth highest to get employee data");
								int nthHighest = scanner.nextInt();
								List<Double> listMax = set.stream().sorted((e1, e2) -> Double.compare(e2, e1))
										.collect(Collectors.toList());								
								if(nthHighest<=set.size() && nthHighest > 0){
									map.values().stream().filter(obj -> obj.getSalary() == listMax.get(nthHighest - 1))
										.forEach(System.out::println);
								}else{
									System.out.println("No Such Nth Highest Range");
								}
							} else if (option.toLowerCase().equals("lowest")) {
								System.out.println("Enter value of Nth lowest to get employee data");
								int nthLowest = scanner.nextInt();
								List<Double> listMin = set.stream().sorted((e1, e2) -> Double.compare(e1, e2))
										.collect(Collectors.toList());								
								if(nthLowest<=set.size() && nthLowest > 0){
									map.values().stream().filter(obj -> obj.getSalary() == listMin.get(nthLowest - 1))
										.forEach(System.out::println);
								}else{
									System.out.println("No Such Nth Lowest Range");
								}
							} else {
								System.out.println("Invalid Option Written....Please Choose From highest/lowest");
							}
							break;

						case 0:
							internalFlag = false;
							break;

						default:
							System.out.println("Invalid Option Selected...Try Again !!!");
						}
					}
					break;

				case 5:
					boolean sortingFlag = true;
					List<Employee> lists = map.values().stream().collect(Collectors.toList());
					while (sortingFlag) {
						System.out.println("Choose Option");
						System.out.println("1. Sort Employee By ID");
						System.out.println("2. Sort Employee By position");
						System.out.println("3. Sort Employee By age");
						System.out.println("4. Sort Employee By salary");
						System.out.println("0. xxx--ExiT--xxx");
						switch (scanner.nextInt()) {
						case 1:
							System.out.println("In descending Order of ID");
							// Collections.sort(lists,new IdComparatorDesc());
							Collections.sort(lists, new Comparator<Employee>() {
								@Override
								public int compare(Employee e1, Employee e2) {
									return Integer.compare(e2.getId(), e1.getId());
								}
							});
							lists.forEach(System.out::println);
							break;

						case 2:
							System.out.println("Enter position of character in name to sort");
							int pos = scanner.nextInt() - 1;
							lists.sort((emp1, emp2) -> Character.compare(emp2.getName().charAt(pos),
									emp1.getName().charAt(pos)));
							lists.forEach(System.out::println);
							break;

						case 3:
							System.out.println("In descending Order of age");
							// Collections.sort(lists,(emp1,emp2)->Integer.compare(emp2.getAge(),emp1.getAge()));
							// lists.forEach(System.out::println);
							map.entrySet().stream().sorted(
									(emp1, emp2) -> Integer.compare(emp2.getValue().getAge(), emp1.getValue().getAge()))
									.forEach(System.out::println);
							break;

						case 4:
							System.out.println("In descending Order of salary");
							map.values().stream()
									.sorted((emp1, emp2) -> Double.compare(emp2.getSalary(), emp1.getSalary()))
									.forEach(System.out::println);
							break;

						case 0:
							sortingFlag = false;
							break;

						default:
							System.out.println("Invalid Option Selected...Try Again !!!");
						}
					}
					break;

				case 0:
					mainFlag = false;
					break;

				default:
					System.out.println("Invalid Option Selected...Try Again !!!");

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}