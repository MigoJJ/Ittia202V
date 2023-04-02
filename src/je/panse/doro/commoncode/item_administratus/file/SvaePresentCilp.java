package je.panse.doro.commoncode.item_administratus.file;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import je.panse.doro.ittia2.FPF;
import je.panse.doro.singlebeam.EntryDir;

public class SvaePresentCilp extends FPF{
	public static void saveToFile(int targetfileindex, String args) throws IOException {
		String[] files = { "3CC", "3PI", "3PMH", "3ROS", "4PMH", "5SUJ", "6OBJ", "7LAB", "8ASS", "9PLAN", "10COMMENT" };
		String filePath = EntryDir.workingDir+ "/" + files[targetfileindex];
		FileWriter fw = new FileWriter(filePath, true);
			fw.write(args +"\n");
			fw.close();
		writeString();
	}
	
	public static void writeString() throws IOException{
		ChartplateCreator.chartplateCreator();
		BufferedReader reader = new BufferedReader(new FileReader(EntryDir.cpfPath));
			String line;
			textAreas[2].setText("");
			while ((line = reader.readLine()) != null) {
					textAreas[2].append(line + "\n");
		}
		reader.close();
		saveToClipboard();
   	}
		
    public static void saveToClipboard() throws IOException {
	    StringSelection stringSelection = new StringSelection(textAreas[2].getText());
	    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	    clipboard.setContents(stringSelection, null);
    }
}
