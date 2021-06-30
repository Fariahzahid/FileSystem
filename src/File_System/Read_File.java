package File_System;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Read_File {

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
}
