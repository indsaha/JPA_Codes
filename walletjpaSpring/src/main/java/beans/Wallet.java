package beans;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Wallet {
       private float balance;
       @Id
       private int id;

       
	public Wallet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Wallet(float balance, int id) {
		super();
		this.balance = balance;
		this.id = id;
	}



	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}
}
