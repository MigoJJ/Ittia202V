package ittia2.panelgil.panel3;

import java.io.IOException;	

import commoncode.item_administratus.file.ChartplateCreator;
import ittia2.FPF;
import singlebeam.EntryDir;
import java.io.FileWriter;

public class PresettextArea extends FPF{
	public static void writeToCategory(int index, String taString) throws IOException {
    	String filePath1 = EntryDir.workingDir + "/chartplate";
    	String filePath2 = EntryDir.workingDir + "/3CC";
    	String filePath3 = EntryDir.workingDir + "/6OBJ";
    	
        String input = textFields[index].getText();
        System.out.println("String input = textFields[index].getText().trim();" + input);
        if (taString.contains("[ New")) {
            input = textFields[0].getText().trim();
            writeFile(filePath1, input);
            textAreas[index].append(input + "\n");

        } else if (taString.contains("[ Objective Findings ]")) {
            writeFile(filePath2, input);
            textAreas[index].append(input + "\n");
        } else if (taString.contains("[ Laboratory Findings ]")) {
            writeFile(filePath3, input);
            textAreas[index].append(input + "\n");
        }
        ChartplateCreator.chartplateCreator();
    }
       
    private static void writeFile(String filePath, String text) throws IOException {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.append(text);
            System.out.println("String saved to file.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to file at " + filePath);
            throw e;
        }
        System.out.println("Writing text to file at " + filePath);
        System.out.println(text);
    }
}
