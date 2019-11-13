package com.esprit.msGestionClient;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Contacts")
public class Contact implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int id;
	private String value;
	private String type;

	

	

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}



	@Override
	public String toString() {
		return "Contact [id=" + id + ", value=" + value + ", type=" + type +  "]";
	}

	public Contact(int id, String value, String type) {
		super();
		this.id = id;
		this.value = value;
		this.type = type;
	}

	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}