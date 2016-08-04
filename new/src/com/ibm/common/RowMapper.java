package com.ibm.common;

import com.ibm.resources.Category;

public abstract class RowMapper<T> {
	private Row row;
	private int currentColumnIndex = 0;

	public final T map(Row row) {
		this.row = row;
		T instance = doMap();
		return instance;
	}

	public String nextString() {
		if (currentColumnIndex >= row.getColums().length) {
			throw new RuntimeException("Too few columns");
		}
	
		return row.getColumn(currentColumnIndex++);
	}

	public String getRowCategory(){		 
		return row.getColumn(3);
	}
	public int nextInt(){
		if(currentColumnIndex>=row.getColums().length){
			throw new RuntimeException("Too few columns" );
		}
		int temp = Integer.parseInt(row.getColumn(currentColumnIndex++));
		return temp;
	}
	public Long nextLong(){
		currentColumnIndex=0;
		if(currentColumnIndex>=row.getColums().length){
			throw new RuntimeException("Too few columns" );
		}
		long temp = Long.parseLong(row.getColumn(currentColumnIndex++));
		return temp;
	}

	protected abstract T doMap();
}
