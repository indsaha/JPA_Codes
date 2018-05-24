package service;

import java.util.List;

import beans.Customer;
import beans.Transaction;

public interface WalletService {
       public Customer createAccount(int id, String name, String mobile, float amount);
	  // public Customer createAccount(String name, String mobile, float amount);
       public List<Transaction> showTransactions();
       public Customer showBalance(String mobile);
       public boolean deposit(String mobile, float amount);
       public boolean withdraw(String mobile, float amount);
       
}
