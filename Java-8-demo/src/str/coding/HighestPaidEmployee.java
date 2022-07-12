package str.coding;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HighestPaidEmployee {
	
	public static void main(String[] args) {
		
		List<Employee> employee = Stream.of(
				new Employee(1,"avinash1","dev1",5000L),
				new Employee(1,"avinash2","dev1",51000L),
				new Employee(1,"avinash3","dev1",5002L),
				new Employee(1,"avinash4","dev4",5000L)
				).collect(Collectors.toList());
		
		Comparator<Employee> comparebysalary = Comparator.comparing(Employee::getSalary);
		
		Map<String, Optional<Employee>> empmap = employee.stream()
				.collect(Collectors.groupingBy(
						Employee::getDept, 
						Collectors.reducing(BinaryOperator.maxBy(comparebysalary))));
		
		empmap.forEach((k,v) -> System.out.println(v.get().toString()));
		
	}

}
