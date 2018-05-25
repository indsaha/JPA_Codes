package com.cg.WalletSpringApp;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Wallet {
       private float balance;
       @Id
       private int id;
       @OneToMany(cascade = CascadeType.ALL)
       @JoinColumn(name="Wallet_ID")
       private List<Transaction> transaction;
       

       
	public Wallet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Wallet(float balance, int id, List<Transaction> transaction) {
		super();
		this.balance = balance;
		this.id = id;
		this.transaction = transaction;
	}



	public float getBalance() {
		return balance;
	}

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public void setBalance(float balance) {
		this.balance = balance;
	}



	public List<Transaction> getTransaction() {
		return transaction;
	}



	public void setTransaction(List<Transaction> transaction) {
		this.transaction = transaction;
	}
}
