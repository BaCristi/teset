package com.ibm.importer;

import com.ibm.common.RowMapper;
import com.ibm.resources.CD;
import com.ibm.resources.Category;
import com.ibm.resources.DVD;
import com.ibm.resources.Media;
import com.ibm.resources.PCGAME;

public class MediaImporter extends FileImporter<Media>{

	private RowMapper<Media> rowMapper = new PhoneRowMapper();
	
	private class PhoneRowMapper extends RowMapper<Media> {

		@Override
		protected Media doMap() {
			Media media = null;
			Category c =Category.valueOf(getRowCategory());
			
			switch(c){
				case CD:
					
					media = new CD();
					media.setId(nextLong());
					media.setTitle(nextString());
					media.setNote(nextString());
					media.setCategorie(Category.valueOf(nextString()));
					((CD)media).setInterpreter(nextString());
					((CD)media).setLength(nextInt());
					System.out.println(media);
					break;
					
				case DVD:
					
					media = new DVD();
					media.setId(nextLong());
					media.setTitle(nextString());
					media.setNote(nextString());
					media.setCategorie(Category.valueOf(nextString()));
					((DVD)media).setDirector (nextString());
					((DVD)media).setLength(nextInt());
					System.out.println(media);
					break;
					
				case PCGAME:
					
					media = new PCGAME();
					media.setId(nextLong());
					media.setTitle(nextString());
					media.setNote(nextString());
					media.setCategorie(Category.valueOf(nextString()));
					((PCGAME)media).setSystem (nextString());					 
					System.out.println(media);
					break;
				default: 
					System.out.println("Unknown category !");
			}		
			 
			return media;
		}

	}

	@Override
	protected RowMapper<Media> getRowMapper() {
		return rowMapper;
	}
}
