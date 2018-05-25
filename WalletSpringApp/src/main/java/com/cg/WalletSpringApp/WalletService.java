package com.cg.WalletSpringApp;

import java.util.List;

public interface WalletService {
       public Customer createAccount(Customer customer);
	  // public Customer createAccount(String name, String mobile, float amount);
       public List<Transaction> showTransactions();
       public Customer showBalance(String mobile);
       public boolean deposit(String mobile, float amount);
       public boolean withdraw(String mobile, float amount);
       
}
