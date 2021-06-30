package File_System;
import java.io.FileWriter;
import java.io.IOException;

public class Write_File {
	
	public int fileWriter(String filepath, String contentTextArea) {
		
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

}
