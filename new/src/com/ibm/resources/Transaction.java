package com.ibm.resources;

import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Transaction {
	 private Date transactionDate; 
	 private long idCustomer;
	 private long idMedia;
	 private String transactionType; 
	 String date1;

	public Transaction(Date transactionDate, long idCustomer, long idMedia, String transactionType) {
		SimpleDateFormat sf = new SimpleDateFormat("MMMM d. yyyy");
		this.transactionDate =transactionDate;
		date1 =sf.format(transactionDate);
		this.idCustomer = idCustomer;
		this.idMedia = idMedia;
		this.transactionType = transactionType;
	}
	public long getIdCustomer() {
		return idCustomer;
	}
	public void setIdCustomer(long idCustomer) {
		this.idCustomer = idCustomer;
	}
	public long getIdMedia() {
		return idMedia;
	}
	public void setIdMedia(long idMedia) {
		this.idMedia = idMedia;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	 @Override
	public String toString() {
		 
		return  date1+ "," + idCustomer + "," + idMedia
				+ "," + transactionType ;
	}
	 
}
