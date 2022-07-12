package str.coding;

public class Employee {
	
	private int id;
	private String name;
	private String dept;
	private Long salary;
	
	public Employee() {
	}
	
	public Employee(int id, String name, String dept, Long salary) {
		super();
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public Long getSalary() {
		return salary;
	}
	public void setSalary(Long salary) {
		this.salary = salary;
	}
	
	
	@Override
	public String toString() {
		return this.getName();
	}

}
