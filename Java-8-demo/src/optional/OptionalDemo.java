package optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalDemo {

	public static void main(String[] args) {
		
		List<Employee> employeeList = createEmployeeList();
        //Optional<Employee> employee = findEmployee(employeeList,"Adam");
        Optional<Employee> employee = findEmployee(employeeList,"John");
        if(employee.isPresent()) {
        	System.out.println(employee.get());
        } else {
        	System.out.println("Employee not found");
        }
        
        
        //You can return default value in case there is no value in Optional using orElse method.
        Employee emp = employee.orElse(new Employee("Dummy", 0));
        System.out.println(emp.getName());
        
        //You can use orElseThrow to throw exception in case Optional is empty.
        //It is similar to get() method but in this case, you can choose to throw any Exception rathar than NoSuchMethodException.
        Employee employee1 = employee.orElseThrow(() -> new RuntimeException("Employee not found"));
        System.out.println(employee1.getName());
	}
	
	public static Optional<Employee> findEmployee(List<Employee> employeeList,String name) {
        for(Employee e:employeeList) {
            if(e.getName().equalsIgnoreCase(name)) {
            	//You can create Optional from non-null value using static factory method "of"
            	//If employee is null then above method will throw NullPointerException
                return Optional.of(e);
                
                //You can create Optional from null or non null value using static factory method "ofNullable"
                //Optional<Employee> optCar = Optional.ofNullable(employee);
            }
        }
        return Optional.empty();
    }
	
	public static List<Employee> createEmployeeList() {
        List<Employee> employeeList=new ArrayList<>();
 
        Employee e1=new Employee("John",21);
        Employee e2=new Employee("Martin",22);
        Employee e3=new Employee("Mary",31);
        Employee e4=new Employee("Stephan",18);
        Employee e5=new Employee("Gary",26);
 
        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);
        employeeList.add(e4);
        employeeList.add(e5);
 
        return employeeList;
 
    }

}
