package repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import beans.Customer;

public interface WalletRepo extends JpaRepository<Customer, Integer>{
	@Query(value = "select c from Customer c where c.mobileNumber like ?1")
	public Customer findOne(String mobile); 

}
