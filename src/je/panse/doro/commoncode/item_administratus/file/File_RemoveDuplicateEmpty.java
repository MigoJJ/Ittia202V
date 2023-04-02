package commoncode.item_administratus.file;

import javax.swing.*;

import ittia2.FPFsub.PFPpanelcategory;
import singlebeam.EntryDir;
import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class File_RemoveDuplicateEmpty extends EntryDir{
	public static void main() {
    	File selectedFile = new File(EntryDir.workingDir + "/chartplate");
    	File outputFile = new File(EntryDir.workingDir + "/chartplatetmp");	
        try {
            BufferedReader reader = new BufferedReader(new FileReader(selectedFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
            Set<String> uniqueLines = new HashSet<>();
            String line;
            while ((line = reader.readLine()) != null) {
                // Remove empty lines
                if (line.trim().length() == 0) {
                    continue;
                }
                // Remove duplicate lines
                if (uniqueLines.contains(line)) {
                    continue;
                }
                writer.write(line + System.lineSeparator());
                uniqueLines.add(line);
            }
            reader.close();
            writer.close();
//            JOptionPane.showMessageDialog(null, "File processed successfully.");
        } catch (IOException ex) {
//            JOptionPane.showMessageDialog(null, "An error occurred while processing the file.");
        }
       renameChartplate();

    }

    public static void renameChartplate() {
        File chartplateFile = new File(EntryDir.workingDir + "/chartplate");
        File chartplatetmpFile = new File(EntryDir.workingDir + "/chartplatetmp");
        // Remove chartplate file (if it exists)
        if (chartplateFile.exists()) {
            chartplateFile.delete();
        }
        // Rename chartplatetmp to chartplate
        if (chartplatetmpFile.exists()) {
            chartplatetmpFile.renameTo(chartplateFile);
        }
    }
}
