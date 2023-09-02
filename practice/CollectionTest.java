import java.util.Map;
import static java.util.Map.Entry;
import java.util.Iterator;

class CollectionTest{
	public static void main(String[] args){
		Map<Integer, Employee> map=EmployeeData.getMapOfEmployee();
		map.values().forEach(System.out::println);
		
		System.out.println("\n");
		
		for(Entry<Integer,Employee> emp : map.entrySet()){
			System.out.println(emp);
		}
		
		System.out.println("\n");
		
		Iterator<Entry<Integer,Employee>> itr=map.entrySet().iterator();
		while(itr.hasNext()){
			Entry<Integer, Employee> entry=itr.next();
			System.out.println("Key : "+entry.getKey()+", Value : "+entry.getValue());
		}
		
	}
}