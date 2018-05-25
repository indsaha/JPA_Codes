package com.cg.WalletSpringApp;

import org.hibernate.service.spi.InjectService;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@ComponentScan
public class Controller {
    

	@Autowired
	private WalletService service;

	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public Customer createAccount(Customer customer){
		Customer c = service.createAccount(customer);
		System.out.println(customer);
		return c;
	}

	@RequestMapping(value="/show", method=RequestMethod.POST)
	public Customer show(String mobile){
		System.out.println(mobile);
		return service.showBalance(mobile);
	}

	@RequestMapping(value="/d", method=RequestMethod.POST)
	public boolean deposit(String mobile, float amount){
		System.out.println(mobile+"  "+amount);
		return service.deposit(mobile, amount);
	}
	
	@RequestMapping(value="/withdraw", method=RequestMethod.POST)
	public boolean withdraw(String mobile, float amount){
		System.out.println(mobile+"  "+amount);
		return service.withdraw(mobile, amount);
	}

	/*@RequestMapping(value="/f", method=RequestMethod.GET)
	public Customer fundTransfer(){
		service.createAccount("Renu", "9604744104",new BigDecimal(5000));
		return service.fundTransfer("9850276767", "9604744104", new BigDecimal(1500));
	}*/

}