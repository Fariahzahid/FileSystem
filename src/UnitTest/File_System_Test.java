package UnitTest;

import File_System.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.After;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
 
public class File_System_Test {
 
  @TempDir
  Path tempDir;

  
  @SuppressWarnings("deprecation")
@Test
  public void WordCountTest() throws IOException {
	  String path = "C:\\Users\\faria\\Desktop\\testone.txt";

	  File myObj = new File(path);

	  myObj.createNewFile();
	  
	  FileWriter myWriter = new FileWriter(path);
      myWriter.write("Files in Java might be tricky, but it is fun enough!");
      myWriter.close();
	  Word_Count_File wordcount = new Word_Count_File();

	  int expectedvalue = 11;
	  int value = wordcount.getWordCount(path);
	  int actualvalue = value;
	  assertEquals(expectedvalue,actualvalue);
	  myObj.delete();
	  }
  
  
  @Test
  public void LineCountTest() throws IOException {
	  String path = "C:\\Users\\faria\\Desktop\\testone.txt";

	  File myObj = new File(path);

	  myObj.createNewFile();
	  
	  FileWriter myWriter = new FileWriter(path);
      myWriter.write("Files in Java might be tricky, but it is fun enough!");
      myWriter.close();
	  Line_Count_File linecount = new Line_Count_File();
	  int expectedvalue = 1;
	  int value = linecount.countLinesNew(path);
	  int actualvalue = value;
	  assertEquals(expectedvalue,actualvalue);
	  myObj.delete();
	  }
  
  
  @Test
  public void MeanWordLengthTest() throws IOException {
	  String path = "C:\\Users\\faria\\Desktop\\testone.txt";

	  File myObj = new File(path);

	  myObj.createNewFile();
	  
	  FileWriter myWriter = new FileWriter(path);
      myWriter.write("Files in Java might be tricky, but it is fun enough!");
      myWriter.close();
	  Mean_Word_Length meanwordlength = new Mean_Word_Length();
	  Word_Count_File wordcount = new Word_Count_File();
	  int wordcountone = wordcount.getWordCount(path);
	  
	  double expectedvalue = 4.727;
	  String value = meanwordlength.getMeanWordLength(path, wordcountone);
	  double valueconvert = Double.parseDouble(value);
	  double actualvalue = valueconvert;
	  
	  assertEquals(expectedvalue,0,actualvalue);
	  myObj.delete();
	  }
  
  
  @Test
  public void WriteContentTest() throws IOException {
	  String path = "C:\\Users\\faria\\Desktop\\testone.txt";

	  File myObj = new File(path);
	  myObj.createNewFile();
      String write = "Files in Java might be tricky, but it is fun enough!";
	  Write_File writeOnFile = new Write_File();	  
	  int writeonfilebool = writeOnFile.fileWriter(path, write);
  
	  int expectedvalue = 1;
	  int actualvalue = writeonfilebool;
  
	  assertEquals(expectedvalue,actualvalue);
	  myObj.delete();
	  }
  
  @Test
  public void RemoveContentTest() throws IOException {
	  String path = "C:\\Users\\faria\\Desktop\\testone.txt";

	  File myObj = new File(path);
	  myObj.createNewFile();
      String write = "Files in Java might be tricky, but it is fun enough!";
	  Remove_Content_File removecontent = new Remove_Content_File();	  
	  int removeboll = removecontent.removeContent(path);
  
	  int expectedvalue = 1;
	  int actualvalue = removeboll;
  
	  assertEquals(expectedvalue,actualvalue);
	  myObj.delete();
	  }
}
