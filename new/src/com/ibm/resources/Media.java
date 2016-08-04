package com.ibm.resources;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.print.attribute.standard.MediaSize;



public abstract class Media {

	private long id; 
	private String title; 
	private String note;	
	private Category categorie;
	protected static long count=0;
	
	public Media(){
		 
	}
	public Media(long id, String title, String note, Category categorie) {
		this.id = id;
		this.title = title;
		this.note = note;
		this.categorie = categorie;
		
	}
	 
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Category getCategorie() {
		return categorie;
	}
	public void setCategorie(Category categorie) {
		this.categorie = categorie;
	}
	@Override
	public String toString() {
		return "Media [id=" + id + ", title=" + title + ", note=" + note + ", categorie=" + categorie + "]";
	}

}


