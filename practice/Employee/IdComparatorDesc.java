import java.util.Comparator;

class IdComparatorDesc implements Comparator<Employee>{
	@Override
	public int compare(Employee e1,Employee e2){
		return Integer.compare(e2.getId(),e1.getId());
	}
}