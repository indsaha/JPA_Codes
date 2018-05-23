package example.jpa;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class EmployeeTest {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("beamconfig.xml");
		EmployeeService Service = ctx.getBean("service", EmployeeService.class);
		
		/*EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		
		EntityManager em = emf.createEntityManager();
		EmployeeService service = new EmployeeService(em);*/
		//em.getTransaction().begin();
		
		Department dept1 = Service.createDepartment(1, "StanC");
		Department dept2 = Service.createDepartment(2, "RBC");
		Department dept3 = Service.createDepartment(3, "Morgan");
		
		Address address1  = new Address(1, "Garia,Kolkata");
		Employee emp = Service.createEmployee(50948, "Indra", 100000, address1, dept1);
		
		Address address2  = new Address(2, "Talewade, Pune");
		Employee emp2 = Service.createEmployee(50949, "Menu", 90000, address2, dept2);
		
		Address address3  = new Address(3, "Talewade, Pune");
		Employee emp3 = Service.createEmployee(50950, "Mrudula", 80000,address3, dept2);
		/*
		Address address4  = new Address(4, "Nigdi, Pune");
		Employee emp4 = service.createEmployee(50340, "Smith", 80000, address4, dept3);
		
		Address address5  = new Address(5, "Talewade, Pune");
		Employee emp5 = service.createEmployee(50952, "Jim", 80000, address5, dept3);
		*/
		//em.getTransaction().commit();
		System.out.println("Persisted");
		/*em.close();
		emf.close();*/
	}

}
