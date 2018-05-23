package example.jpa;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service(value="service")
public class EmployeeServiveImpl implements EmployeeService {
	@Autowired
	private EmployeeRepo repo;

	@Transactional
	public Employee createEmployee(Employee e) {
		// TODO Auto-generated method stub
		Employee e1 = repo.save(e);
		return e1;
		
	}

	@Transactional
	public Employee findEmployee(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
		
	}

}
