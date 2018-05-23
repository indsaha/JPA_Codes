package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import beans.Customer;
import beans.Wallet;
import repo.WalletRepo;
@Service(value = "service")
public class WalletServiceImpl implements WalletService{
	@Autowired
	private WalletRepo repo;
	
	/*	public WalletServiceImpl(WalletRepo repo) {
		super();
		this.repo = repo;
	}*/

	@Transactional
	public Customer createAccount(int id, String name, String mobile, float amount) {
		// Method to create new account
		Customer customer = new Customer();
		Wallet wallet = new Wallet(amount, id);
		customer.setId(id);
		customer.setCustomerName(name);
		customer.setMobileNumber(mobile);
		/*wallet.setBalance(amount);
		*/
		customer.setWallet(wallet);
		repo.save(customer);
		return customer;
	}

	
	public Customer showBalance(String mobile) {
		// method to show balance
		return repo.findOne(mobile);
	}

	public boolean deposit(String mobile, float amount) {
		// Updates customer with changes in wallet
		Customer customer;
		customer = repo.findOne(mobile);
		Wallet wallet = customer.getWallet();
		wallet.setBalance(amount+wallet.getBalance());
		repo.save(customer);
		return true;
	}

	public boolean withdraw(String mobile, float amount) {
		Customer customer;
		customer = repo.findOne(mobile);
		Wallet wallet = customer.getWallet();
		if(wallet.getBalance() >= amount)
			{
			wallet.setBalance(wallet.getBalance()-amount);
			repo.save(customer);
			return true;
			}
		//else
		return false;
	}
	
	

}
