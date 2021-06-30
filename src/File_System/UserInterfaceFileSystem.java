package File_System;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class UserInterfaceFileSystem {

	//initialization of variable
	private JFrame frame;
	private JTextArea textArea;
	private JButton select_file,word_count,write_file,remove_text;
	public JLabel file_name_label, lblReadingFile, lblSelected,select_file_label,imagelabel,lblStatisticsOfFile
	,word_count_label,line_count_label,mean_length_label,word_label,line_label,mean_label;
	private JScrollPane scrollPane;
	public String filename,filepath,textAreaContent;
	private JButton showfilebutton;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInterfaceFileSystem window = new UserInterfaceFileSystem();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public UserInterfaceFileSystem() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame("File System");
		frame.setBounds(100, 100, 660, 705);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Object creation for classes to get data
		Read_File readfile = new Read_File();
		Write_File writefile = new Write_File();
		Remove_Content_File removecontent = new Remove_Content_File();
		Word_Count_File wordcountfile = new Word_Count_File();
		Line_Count_File linecountfile = new Line_Count_File();
		Mean_Word_Length meanwordlength = new Mean_Word_Length();

		
		//Add action listeners to button
		select_file = new JButton("Select File");
		select_file.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Map<String, String> result = new HashMap<>();								
				result = readfile.getFileData();
				filename = result.get("filename");
				filepath = result.get("filepath");
				
				select_file_label.setText(filename);
		            
		            try {
		            	//read file in the Text Area
		            	FileReader filereader = new FileReader(filepath);
		            	BufferedReader bufferreader = new BufferedReader(filereader);
		            	scrollPane.setVisible(true);
		            	textArea.setVisible(true);
		            	textArea.read(bufferreader,null);
		            	bufferreader.close();
		            	textArea.requestFocus();	            	
		            }catch(Exception message) {
	            	JOptionPane.showMessageDialog(null, message);
		            }
		        }

		});
		select_file.setBounds(488, 165, 131, 49);
		frame.getContentPane().add(select_file);
		
		showfilebutton = new JButton("Show File");
		showfilebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(filepath!= null) {
					try {
		            	FileReader filereader = new FileReader(filepath);
		            	BufferedReader bufferreader = new BufferedReader(filereader);
		            	scrollPane.setVisible(true);
		            	textArea.setVisible(true);
		            	textArea.read(bufferreader,null);
		            	bufferreader.close();
		            	textArea.requestFocus();	            	
		            }catch(Exception message) {
	            	JOptionPane.showMessageDialog(null, message);
		            }
				}
				else {
					JOptionPane.showMessageDialog(null, "Please select the file first.", 
                            "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		showfilebutton.setBounds(488, 255, 131, 49);
		frame.getContentPane().add(showfilebutton);
		
		
		word_count = new JButton("Show Statistics");
		word_count.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(filename==null) {
					JOptionPane.showMessageDialog(null, "Please select the file first.", 
                            "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else {
				
						textArea.setVisible(false);
						scrollPane.setVisible(false);
						
						int wordcount = wordcountfile.getWordCount(filepath);
						long linecount = 0;
						try {
							linecount = linecountfile.countLinesNew(filepath);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						String meanWordLength = meanwordlength.getMeanWordLength(filepath, wordcount);
					    word_label.setText("Word Count = ");
					    word_count_label.setText(String.valueOf(wordcount));
					    
					    line_label.setText("Line Count = ");
					    line_count_label.setText(String.valueOf(linecount));
					    
					    mean_label.setText("Mean Word Length = ");
					    mean_length_label.setText(meanWordLength);
					    
				}		      
			}
		});
		word_count.setBounds(488, 353, 131, 49);
		frame.getContentPane().add(word_count);
		
		write_file = new JButton("Write File");
		write_file.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(filename==null) {
					JOptionPane.showMessageDialog(null, "Please select the file first.", 
                            "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else {
					textArea.setVisible(true);
					scrollPane.setVisible(true);
					textAreaContent = textArea.getText();
					int success = writefile.fileWriter(filepath, textAreaContent);
					if(success == 1) {
						JOptionPane.showMessageDialog(null, "Successfully write to file.", 
	                            "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
						try {
			            	FileReader filereader = new FileReader(filepath);
			            	BufferedReader bufferreader = new BufferedReader(filereader);
			            	scrollPane.setVisible(true);
			            	textArea.setVisible(true);
			            	textArea.read(bufferreader,null);
			            	bufferreader.close();
			            	textArea.requestFocus();	            	
			            }catch(Exception message) {
		            	JOptionPane.showMessageDialog(null, message);
			            }
					}
					else {
						JOptionPane.showMessageDialog(null, "Writing to file is unsucessfull.", 
	                            "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				}

				
			}
		});
		write_file.setBounds(488, 445, 131, 49);
		frame.getContentPane().add(write_file);
		
		remove_text = new JButton("Remove Text");
		remove_text.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(filename==null) {
					JOptionPane.showMessageDialog(null, "Please select the file first.", 
                            "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else {
					int remove = removecontent.removeContent(filepath);
					if(remove==1) {
						JOptionPane.showMessageDialog(null, "Content Remove Successully.", 
	                            "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
						try {
			            	FileReader filereader = new FileReader(filepath);
			            	BufferedReader bufferreader = new BufferedReader(filereader);
			            	scrollPane.setVisible(true);
			            	textArea.setVisible(true);
			            	textArea.read(bufferreader,null);
			            	bufferreader.close();
			            	textArea.requestFocus();	            	
			            }catch(Exception message) {
		            	JOptionPane.showMessageDialog(null, message);
			            }
						
					}
					else {
						JOptionPane.showMessageDialog(null, "Content not removed", 
	                            "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				}

			}
		});
		remove_text.setBounds(488, 547, 131, 49);
		frame.getContentPane().add(remove_text);
		
		//Label 
		lblReadingFile = new JLabel("READING FILE SYSTEM");
		lblReadingFile.setFont(new Font("Calibri", Font.BOLD, 25));
		lblReadingFile.setBounds(143, 41, 297, 49);
		frame.getContentPane().add(lblReadingFile);
		
		imagelabel = new JLabel("");
		Image image = new ImageIcon(this.getClass().getResource("/Doc-Man.png")).getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT);
		imagelabel.setIcon(new ImageIcon(image));
		imagelabel.setBounds(43, 11, 98, 95);
		frame.getContentPane().add(imagelabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 167, 430, 469);
		scrollPane.setVisible(false);
		frame.getContentPane().add(scrollPane);
	    scrollPane.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
	    
	    textArea = new JTextArea();
	    scrollPane.setViewportView(textArea);
	    textArea.setVisible(false);
	    textArea.setLineWrap(true);
	    textArea.setWrapStyleWord(true);
	    
		lblSelected = new JLabel("Selected File : ");
		lblSelected.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSelected.setBounds(43, 121, 91, 23);
		frame.getContentPane().add(lblSelected);
		
		select_file_label = new JLabel("New label");
		select_file_label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		select_file_label.setBounds(155, 121, 213, 23);
		frame.getContentPane().add(select_file_label);
		
		lblStatisticsOfFile = new JLabel("Statistics of File  ");
		lblStatisticsOfFile.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblStatisticsOfFile.setBounds(43, 173, 163, 23);
		frame.getContentPane().add(lblStatisticsOfFile);
		
		word_count_label = new JLabel("New label");
		word_count_label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		word_count_label.setBounds(227, 235, 213, 23);
		frame.getContentPane().add(word_count_label);
		
		line_count_label = new JLabel("New label");
		line_count_label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		line_count_label.setBounds(227, 298, 213, 23);
		frame.getContentPane().add(line_count_label);
		
		mean_length_label = new JLabel("New label");
		mean_length_label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mean_length_label.setBounds(227, 364, 213, 23);
		frame.getContentPane().add(mean_length_label);
		
		word_label = new JLabel("Selected File : ");
		word_label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		word_label.setBounds(43, 235, 163, 23);
		frame.getContentPane().add(word_label);
		
		line_label = new JLabel("Selected File : ");
		line_label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		line_label.setBounds(43, 298, 163, 23);
		frame.getContentPane().add(line_label);
		
		mean_label = new JLabel("Selected File : ");
		mean_label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mean_label.setBounds(43, 364, 163, 23);
		frame.getContentPane().add(mean_label);
		
		
	
		
	}
}
