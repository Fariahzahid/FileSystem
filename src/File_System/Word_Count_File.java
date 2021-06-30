package File_System;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Word_Count_File {
	
	public int getWordCount(String filepath) {
		String[] words=null;    
	      int wordCount=0;     
	      FileReader filereader = null;
		try {
			filereader = new FileReader(filepath);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}    //Creation of File Reader object
	      BufferedReader bufferreader = new BufferedReader(filereader);    //Creation of BufferedReader object
	      String textinfile;
	      try {
			while((textinfile=bufferreader.readLine())!=null)    //Reading Content from the file
			  {
			     words=textinfile.split(" ");   //Split the word using space
			     wordCount=wordCount+words.length;   //increase the word count for each word
			  }
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
		return wordCount;
		
	}

}
