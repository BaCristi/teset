package com.ibm.resources;

public class PCGAME extends Media {

	private String system;
	
	public PCGAME(){
		
	}
	 
	public PCGAME(long id, String title, String note, Category categorie, String system) {
		super(id, title, note, categorie);
		this.system = system;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	@Override
	public String toString() {
		return getId() + "," + getTitle() + "," + getNote()
				+ "," + getCategorie() + "," + system + "";
	}

	 
	
	
}
