import java.awt.TextArea;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

public class File_Management_Functionality {
	
	
	protected Map<String, String> getFileData() {

		JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Text Files", "txt");
        
        chooser.setFileFilter(filter);
        
        int returnVal = chooser.showOpenDialog(null);
        String filename = chooser.getSelectedFile().getName();
        String filepath = chooser.getSelectedFile().getAbsolutePath();
        if(returnVal == JFileChooser.APPROVE_OPTION) {
        	
            System.out.println("You chose to open this file: " +
                    chooser.getSelectedFile().getName() +chooser.getSelectedFile().getAbsolutePath());
        }
        Map<String, String> result = new HashMap<>();
        result.put("filename",filename);
        result.put("filepath", filepath);
        
        return result;    
        
	}
	
	protected int fileWriter(String filepath, String contentTextArea) {
		
		try {
		      FileWriter fileWriter = new FileWriter(filepath);
		      fileWriter.write(contentTextArea);
		      fileWriter.close();
		      System.out.println("Successfully wrote to the file.");
		      return 1;
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		      return 0;
		    }
		
    }
	
	protected int removeContent(String filepath) {
		
		try {
			FileChannel.open(Paths.get(filepath), StandardOpenOption.WRITE).truncate(0).close();
			return 1;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
		
	}
	
	protected int getWordCount(String filename, String filepath) {
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
	
	protected double getMeanWordLength(String filepath,double wordCount ) {
        double meanWordLength=0;
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
		return meanWordLength;
		
		
		
		
	}
	
	protected int countLinesNew(String filepath) throws IOException {
		InputStream is = new BufferedInputStream(new FileInputStream(filepath));
	    try {
	        byte[] character = new byte[1024];
	        int countlines = 0;
	        int readcharacters = 0;
	        boolean endline = false;
	        while ((readcharacters = is.read(character)) != -1) {
	            for (int i = 0; i < readcharacters; ++i) {
	                if (character[i] == '\n')
	                    ++countlines;
	            }
	            endline = (character[readcharacters - 1] != '\n');
	        }
	        if(endline) {
	            ++countlines;
	        } 
	        return countlines;
	    } finally {
	        is.close();
	    }
	}
	


}
