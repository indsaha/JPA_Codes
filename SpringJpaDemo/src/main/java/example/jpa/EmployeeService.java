package example.jpa;
import javax.persistence.*;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "service")
public class EmployeeService {

	@PersistenceContext
	protected EntityManager em;
	
	/*public EmployeeService(EntityManager em){
		this.em=em;
	}*/
	@Transactional
	public Employee createEmployee(int id,String name,int salary, Address address, Department department){
		
		Employee emp = new Employee(id);
		emp.setAddress(address);
		emp.setName(name);
		emp.setSalary(salary);
		emp.setDepartment(department);
		em.merge(emp);
		return emp;
	}
	public Department createDepartment(int id, String name){
			Department dept = new Department(id,name);
			//em.merge(dept);
			return dept;
	}

	public Department findDepartment(int id){
		return em.find(Department.class, id);
}


}
	

