package File_System;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Remove_Content_File {
	
	public int removeContent(String filepath) {
		
		try {
			FileChannel.open(Paths.get(filepath), StandardOpenOption.WRITE).truncate(0).close();
			return 1;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

}
