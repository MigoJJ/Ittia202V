package je.panse.doro.commoncode.item_administratus.file;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedReader;

public class ChartplateCreator {
	public static void chartplateCreator() {
        String currentUsersDir = System.getProperty("user.dir");
        String homeDir = currentUsersDir + "/src/je/panse/doro";
        String workingDir = homeDir + "/datatext/samsara";
        List<String> filenames = Arrays.asList("3CC", "3PI", "3PMH", "3ROS", "5SUJ", "6OBJ", "7LAB", "8ASS", "9PLAN", "10COMMENT");
        File chartplateFile = new File(workingDir + "/chartplate"); // Change the file name and path as per your requirements
        
        try {
            FileWriter writer = new FileWriter(chartplateFile);
            for (String filename : filenames) {
                File file = new File(workingDir + "/" + filename);
                if (file.exists() && file.isFile()) {
                    writer.write("=== " + filename + " ===\n");
                    writer.write(readFileContents(file) + "\n\n");
                }
            }
            writer.close();
            System.out.println("Chartplate created successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static String readFileContents(File file) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
