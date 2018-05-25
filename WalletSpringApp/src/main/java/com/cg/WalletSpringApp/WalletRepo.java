package com.cg.WalletSpringApp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface WalletRepo extends JpaRepository<Customer, Integer>{
	@Query(value = "select c from Customer c where c.mobileNumber like ?1")
	public Customer findOne(String mobile); 
	/*@Query(value = "select T from CUSTOMER C JOIN FETCH C.TRANSACTION T where c.mobileNumber like ?1")
	public Transaction findTransaction(String mobile); */

}
