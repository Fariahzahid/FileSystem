package File_System;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Mean_Word_Length {
	
	public String getMeanWordLength(String filepath,double wordCount ) {
        double meanWordLength=0;
        String twodecimal; 
        double characters=0;

	      FileReader filereader = null;
		try {
			filereader = new FileReader(filepath);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}    
	      BufferedReader bufferreader = new BufferedReader(filereader);    
	      String textinfile;
	      try {
			while((textinfile=bufferreader.readLine())!=null)    
			  {
				String []charWords=textinfile.split("");
		        for (int j=0;j<charWords.length;j++) {
		        	characters++;
		        }
		        meanWordLength=characters/wordCount;  
			  }
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	      
	     twodecimal = String.format("%.3f",meanWordLength);
		return twodecimal;
		
		
		
		
	}

}
