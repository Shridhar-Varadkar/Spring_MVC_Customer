package com.mysql_mvc.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//@Entity(name = "customer_table")  used to change table name if you want
@Entity
public class Customer {

	  @Id  //for primary key
	 @GeneratedValue(strategy = GenerationType.AUTO) // to auto increment primary key
	 int id;
	 
	 //@Column(name="customer_name")  used to change column name if you want
	 @Column(nullable = false)
	 String name;
	 
	 @Column(nullable = false,unique = true)
	 String phone;

	 
	 public Customer() {}


	public Customer(int id, String name, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}
	 
	 
}
