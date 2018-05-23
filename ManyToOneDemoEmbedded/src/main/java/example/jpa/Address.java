package example.jpa;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Embeddable
public class Address {
    @Id
	private int id;
	private String line;
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(int id, String line) {
		super();
		this.id = id;
		this.line = line;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}
	
}
