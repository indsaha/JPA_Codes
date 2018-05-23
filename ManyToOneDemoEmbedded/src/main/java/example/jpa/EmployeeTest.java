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
		Employee emp = service.createEmployee(50948, "RK", 100000, address1, dept1);
		
		Address address2  = new Address(2, "Talewade, Pune");
		Employee emp2 = service.createEmployee(50949, "Renu", 90000, address2, dept1);
		
		Address address3  = new Address(3, "Talewade, Pune");
		Employee emp3 = service.createEmployee(50950, "Mrudula", 80000,address3, dept2);
		
		Address address4  = new Address(4, "Nigdi, Pune");
		Employee emp4 = service.createEmployee(50340, "Smith", 80000, address4, dept3);
		
		Address address5  = new Address(5, "Talewade, Pune");
		Employee emp5 = service.createEmployee(50952, "Jim", 80000, address5, dept3);
		
		em.getTransaction().commit();
		System.out.println("Persisted");
		em.close();
		emf.close();
	}

}
