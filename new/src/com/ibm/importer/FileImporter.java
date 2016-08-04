package com.ibm.importer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import com.ibm.common.CsvImporter;
import com.ibm.common.RowMapper;
import com.ibm.resources.Media;
 

public abstract class FileImporter<T> {
	private CsvImporter<T> csvImporter;

	public List<T> importFile(Reader fileReader) throws IOException {
		ArrayList<String> list = new ArrayList<>();
		String thisLine = "";
		BufferedReader br = new BufferedReader(fileReader);
		while ((thisLine = br.readLine()) != null) {
			list.add(thisLine);
			
		}
		//System.out.println(list);
		csvImporter = new CsvImporter<T>(list, getRowMapper());
		List<T> objectList = new ArrayList<>();
		//System.out.println(list );
		while (csvImporter.hasNext()) {			
			objectList.add(csvImporter.next());
			
		}
	
		return objectList;
	}

	protected abstract RowMapper<T> getRowMapper();
}
