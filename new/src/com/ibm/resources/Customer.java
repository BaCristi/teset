package com.ibm.resources;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Customer  {
	private long idCustomer; 
	private String name;
	private String phone;
	
	public Customer(){
		
	}
	 
	public Customer(long idCustomer, String name, String phone) {
	
		this.idCustomer = idCustomer;
		this.name = name;
		this.phone = phone;
	}
	public long getIdCustomer() {
		return idCustomer;
	}
	public void setIdCustomer(long idCustomer) {
		this.idCustomer = idCustomer;
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
	
	@Override
	public String toString() {
		return idCustomer + "," + name + "," + phone;
	}
}
