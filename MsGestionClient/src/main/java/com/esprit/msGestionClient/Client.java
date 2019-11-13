package com.esprit.msGestionClient;


import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Clients")
public class Client implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5985387818059358595L;
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String email;
	@OneToMany
	private List<Contact> Contacts;
	
	
	public Client(int id, String name, String email, List<Contact> contacts) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		Contacts = contacts;
	}
	public List<Contact> getContacts() {
		return Contacts;
	}
	public void setContacts(List<Contact> contacts) {
		Contacts = contacts;
	}
	public Client(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Client(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", email=" + email + ", Contacts=" + Contacts + "]";
	}
	
	
	

}