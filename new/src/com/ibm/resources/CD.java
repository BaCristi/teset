package com.ibm.resources;

public class CD extends Media {
	private String interpreter;
	private int length;
	
	public CD(){
		
	}
	public CD(long id, String title, String note, Category categorie, String interpreter, int length) {
		super(id, title, note, categorie);
		this.interpreter = interpreter;
		this.length = length;
	} 
	public String getInterpreter() {
		return interpreter;
	}


	public void setInterpreter(String interpreter) {
		this.interpreter = interpreter;
	}


	public int getLength() {
		return length;
	}


	public void setLength(int length) {
		this.length = length;
	}
	@Override
	public String toString() {
		return  getId() + "," + getTitle() + "," + getNote()
				+ "," + getCategorie() + "," + interpreter + "," + length + "";
	}

 
	

	

}
