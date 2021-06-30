package File_System;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Line_Count_File {
	
	
	public int countLinesNew(String filepath) throws IOException {
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
