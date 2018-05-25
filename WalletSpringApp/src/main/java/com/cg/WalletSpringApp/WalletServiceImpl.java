package com.cg.WalletSpringApp;

import java.util.ArrayList;
import java.util.Date;


import javax.annotation.Resource;

import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import antlr.collections.List;


@Service(value = "service")
public class WalletServiceImpl implements WalletService{
	@Autowired
	private WalletRepo repo;
	static int transCount; 
	private java.util.List<Transaction> transactions = new ArrayList<>();

	
	/*	public WalletServiceImpl(WalletRepo repo) {
		super();
		this.repo = repo;
	}*/

	/*@Transactional
	public Customer createAccount(int id, String name, String mobile, float amount) {
	//public Customer createAccount(String name, String mobile, float amount) {	
		// Method to create new account
		Customer customer = new Customer();
		//Wallet wallet = new Wallet(amount, customer.getId());
		Wallet wallet = new Wallet();
		wallet.setBalance(amount);
		wallet.setId(id);
		transCount++;
		Transaction transaction = new Transaction(transCount, new Date(), "Created", 0, wallet.getBalance());
		transactions.add(transaction);
	    wallet.setTransaction(transactions);
		customer.setId(id);
		customer.setCustomerName(name);
		customer.setMobileNumber(mobile);
		wallet.setBalance(amount);
		
		customer.setWallet(wallet);
		repo.save(customer);
		return customer;
	}*/
	
	@Transactional
	public Customer createAccount(Customer customer) {
		Wallet wallet = new Wallet();
		wallet.setBalance(customer.getWallet().getBalance());
		wallet.setId(customer.getId());
		transCount++;
		Transaction transaction = new Transaction(transCount, new Date(), "Created", 0, wallet.getBalance());
		transactions.add(transaction);
	    wallet.setTransaction(transactions);
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
		float transactionAmount = amount+wallet.getBalance(); 
		wallet.setBalance(transactionAmount);
		transCount++;
		Transaction transaction = new Transaction(transCount, new Date(), "Deposit", amount, wallet.getBalance());
		transactions.add(transaction);
		wallet.setTransaction(transactions);
		repo.save(customer);
		return true;
	}

	public boolean withdraw(String mobile, float amount) {
		Customer customer;
		customer = repo.findOne(mobile);
		Wallet wallet = customer.getWallet();
		if(wallet.getBalance() >= amount)
			{
			float transactionAmount = wallet.getBalance()-amount;
			wallet.setBalance(transactionAmount);
			transCount++;
			Transaction transaction = new Transaction(transCount, new Date(), "Withdrawal", amount, wallet.getBalance());
			transactions.add(transaction);
			wallet.setTransaction(transactions);
			repo.save(customer);
			return true;
			}
		//else
		return false;
	}


	@Override
	public java.util.List<Transaction> showTransactions() {
		return transactions;
		
	}


	
	

}
