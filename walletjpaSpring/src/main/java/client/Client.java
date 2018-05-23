package client;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.support.GenericXmlApplicationContext;

import beans.Customer;
import repo.WalletRepo;
import service.WalletService;
import service.WalletServiceImpl;

public class Client {
	public static void main(String[] args)
	{

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("beanconfig.xml");
		WalletService service = ctx.getBean("service",WalletService.class);
		
		
		service.createAccount(1, "RK", "9674632276", 10000);
		service.createAccount(2, "Indranil", "2437656777", 9000);
		service.createAccount(3, "SaiRam", "7664545666", 7000);
		service.createAccount(4, "Pragya", "1212121223", 5000);
		service.createAccount(5, "Teena", "9674645454", 7000);
		
		System.out.println(service.showBalance("2437656777"));
		service.deposit("2437656777", 10000);
		// after depositing amount 
		System.out.println(service.showBalance("2437656777"));
		System.out.println();
		
		System.out.println(service.showBalance("1212121223"));
	    boolean b = service.withdraw("1212121223", 4000);
	    if(b == false)
        {
	    	System.out.println("Invalid amount, Wallet balance insufficient");
	    }
	    System.out.println(service.showBalance("1212121223"));
	    
	    System.out.println(service.showBalance("9674645454"));
	    b = service.withdraw("9674645454", 9000);
	    if(b == false)
        {
	    	System.out.println("Invalid amount, Wallet balance insufficient");
	    }
	    System.out.println(service.showBalance("9674645454"));
	    System.out.println("Done");
		}

}