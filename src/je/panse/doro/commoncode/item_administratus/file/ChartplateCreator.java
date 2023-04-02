package je.panse.doro.commoncode.item_administratus.file;

import java.io.*;					
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import je.panse.doro.singlebeam.EntryDir;

public class ChartplateCreator {
	public static void chartplateCreator() {
    String currentUsersDir = System.getProperty("user.dir");
    String homeDir = currentUsersDir + "/src";
    String workingDir = homeDir + "/datatext/samsara";
    List<String> subsourceFiles = Arrays.asList("3CC", "3PI", "3ROS", "4PMH", "5SUJ", "6OBJ", "7LAB", "8ASS", "9PLAN", "10COMMENT");
    File chartplateFile = new File(EntryDir.workingDir + "/chartplate"); // Change the file name and path as per your requirements
    
    System.out.println(chartplateFile);
    if (!chartplateFile.exists() || chartplateFile.listFiles() == null || chartplateFile.listFiles().length == 0) {
        System.out.println("Error: chartplate directory is empty or does not exist.");
        return;
    }
    try {
      FileWriter writer = new FileWriter(chartplateFile);
      BufferedWriter bufferWriter = new BufferedWriter(writer);
      // Iterate through the files in the workingDir directory
      File dir = new File(workingDir);
      File[] directoryListing = dir.listFiles();

      if (directoryListing != null) {
          Arrays.sort(directoryListing, new Comparator<File>() {
              @Override
              public int compare(File f1, File f2) {
                  return f1.getName().compareToIgnoreCase(f2.getName());
              }
          });
          for (File file : directoryListing) {
              String filename = file.getName();
              if (subsourceFiles.contains(filename.toUpperCase())) {
                  FileReader reader = new FileReader(file);
                  BufferedReader bufferReader = new BufferedReader(reader);
                  String line;
                  while ((line = bufferReader.readLine()) != null) {
                      bufferWriter.write(line);
                      bufferWriter.newLine();
                  }
                  bufferReader.close();
              }
          }
          bufferWriter.close();
      } else {
          System.out.println("Directory is empty or does not exist.");
      }
      
      Arrays.sort(directoryListing, new Comparator<File>() {
    	  @Override
    	  public int compare(File f1, File f2) {
    	    return f1.getName().compareToIgnoreCase(f2.getName());
    	  }
    	});
      if (directoryListing != null) {
    	  for (File file : directoryListing) {
			  String filename = file.getName();
			  if (subsourceFiles.contains(filename.toUpperCase())) {
				  	FileReader reader = new FileReader(file);
				  	BufferedReader bufferReader = new BufferedReader(reader);
				  	String line;
				  	while ((line = bufferReader.readLine()) != null) {
				  		bufferWriter.write(line);
				  		bufferWriter.newLine();
			    }
			    bufferReader.close();
			  }
        	}
        bufferWriter.close();
      } else {
        System.out.println("Directory is empty.");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    File_RemoveDuplicateEmpty.main();
	
	}
}
