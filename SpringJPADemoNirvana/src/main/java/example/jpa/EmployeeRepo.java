package example.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{
	
	@Query(value = "select e from Employee e JOIN FETCH e.department WHERE e.id = ?1 ")
	public Employee findById(int id);
}
