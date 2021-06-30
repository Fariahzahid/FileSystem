package File_System;
import java.io.FileWriter;
import java.io.IOException;

public class Write_File {
	
	public int fileWriter(String filepath, String contentTextArea) {
		
		try {
		      FileWriter fileWriter = new FileWriter(filepath);
		      fileWriter.write(contentTextArea);
		      fileWriter.close();
		      return 1;
		    } catch (IOException e) {
		      e.printStackTrace();
		      return 0;
		    }
		
    }

}
