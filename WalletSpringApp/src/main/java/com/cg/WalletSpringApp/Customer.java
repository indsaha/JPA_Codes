package com.cg.WalletSpringApp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Customer {
	@Id
	private int id;
    private String name;
    private String mobileNumber;
    @OneToOne(cascade = CascadeType.ALL)
    private Wallet wallet;
   
    
    
    public Customer(int id, String name, String mobileNumber, Wallet wallet) {
    //public Customer(String name, String mobileNumber, Wallet wallet) {
         super();
		this.id = id;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.wallet = wallet;
		//this.transaction = transaction;
	}
	
    
	


	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public String getName()
    {
    	return name;
    }
    public void setName(String name)
    {
    	this.name = name;
    }
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public Wallet getWallet() {
		return wallet;
	}
	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String toString()
	{
		return name+" "+mobileNumber+" "+" "+wallet.getBalance();
	}
}
