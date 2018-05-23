package example.jpa;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


public class EmployeeTest {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		
		EntityManager em = emf.createEntityManager();
		EmployeeService service = new EmployeeService(em);
		em.getTransaction().begin();
		
		Department dept1 = service.createDepartment(1, "StanC");
		Department dept2 = service.createDepartment(2, "RBC");
		Department dept3 = service.createDepartment(3, "Morgan");
		
		Address address1  = new Address(1, "Abhoynagar,Agartala");
		Employee emp = service.createEmployee(50948, "RK", 100000, address1);
		System.out.println("Persisted");
		
		List<Employee> empList1 = new ArrayList<Employee>();
		empList1.add(emp);
		service.setEmployeesOnDepartment(1, empList1);
		
		Address address2  = new Address(2, "Talewade, Pune");
		Employee emp2 = service.createEmployee(50949, "Renu", 90000, address2);
		//em.getTransaction().commit();
		Address address3  = new Address(3, "Talewade, Pune");
		Employee emp3 = service.createEmployee(50950, "Mrudula", 80000,address3);
		//em.getTransaction().commit();
		List<Employee> empList2 = new ArrayList<Employee>();
		empList2.add(emp2);
		empList2.add(emp3);
		service.setEmployeesOnDepartment(2, empList2);
		
		Address address4  = new Address(4, "Nigdi, Pune");
		Employee emp4 = service.createEmployee(50340, "Smith", 80000, address4);
		//em.getTransaction().commit();
		
		Address address5  = new Address(5, "Talewade, Pune");
		Employee emp5 = service.createEmployee(50952, "Jim", 80000, address5);
		//em.getTransaction().commit();
		List<Employee> empList3 = new ArrayList<Employee>();
		empList3.add(emp4);
		empList3.add(emp5);
		service.setEmployeesOnDepartment(3, empList3);
		
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

}
