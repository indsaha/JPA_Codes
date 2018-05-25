package com.cg.WalletSpringApp;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import org.springframework.data.annotation.Id;
@Entity
public class Transaction {
    @javax.persistence.Id
    //@GeneratedValue
	private int id;
    private Date date;
    private String description;
    private float amount;
    private float availableBalance;
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Transaction(int id, Date date, String description, float amount, float availableBalance) {
		super();
		this.id = id;
		this.date = date;
		this.description = description;
		this.amount = amount;
		this.availableBalance = availableBalance;
	}
/*	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
*/	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public float getAvailableBalance() {
		return availableBalance;
	}
	public void setAvailableBalance(float availableBalance) {
		this.availableBalance = availableBalance;
	}
	
	public String toString()
	{
		return " ID:"+ id +" Date: " + date + " Description: " + description + " Amount: " + amount + " Balance: " + availableBalance;
	}
    
    
        
}
