package example.jpa;


import javax.persistence.*;
@Entity
public class Employee {

	@Id private int id;
	private String name;
	private int salary;
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn (name="DEPT_ID")
	private Department department;

	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Employee(int id, String name, int salary, Address address, Department department) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.address = address;
		this.department = department;
	}


		public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Employee(int id){
		this.id=id;	
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

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	@Override
	public String toString() {
		return "Employee [department=" + department + ", id=" + id + ", name="
				+ name + ", salary=" + salary + "]";
	}
	
}
