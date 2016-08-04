package com.ibm.resources;

public class DVD extends Media {
	private String director; 
	private int length;
	public DVD(){
		
	}
	 
	public DVD(long id, String title, String note, Category categorie, String director, int length) {
		super(id, title, note, categorie);
		this.director = director;
		this.length = length;
	}
	 
	public String getDirector() {
		return director;
	}
	
	public void setDirector(String director) {
		this.director = director;
	}
	
	public int getLength() {
		return length;
	}
	
	public void setLength(int length) {
		this.length = length;
	}
	
	@Override
	public String toString() {
		return getId() + "," + getTitle() + "," + getNote() + ","
				+ getCategorie() + "," + director + "," + length;
	}
	 


}
