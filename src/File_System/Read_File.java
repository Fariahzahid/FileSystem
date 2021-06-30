package File_System;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Read_File {

	//Read File from the user selection
	protected Map<String, String> getFileData() {

		JFileChooser choosefile = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Text Files", "txt");
        
        choosefile.setFileFilter(filter);
        
        int returnvalue = choosefile.showOpenDialog(null);
        String filename = choosefile.getSelectedFile().getName();
        String filepath = choosefile.getSelectedFile().getAbsolutePath();

        Map<String, String> result = new HashMap<>();
        result.put("filename",filename);
        result.put("filepath", filepath);
        
        return result;    
        
	}
}
