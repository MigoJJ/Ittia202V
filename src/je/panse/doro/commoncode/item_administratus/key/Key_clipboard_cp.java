package commoncode.item_administratus.key;

import java.io.BufferedReader;		
import java.io.FileReader;
import java.io.IOException;
import singlebeam.EntryDir;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;

public class Key_clipboard_cp extends EntryDir{
	public static void main(String[] args) {
		String filePath = (homeDir + workingDir + "/chartplate");
		String fileContent = "";
		StringBuilder contentBuilder = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) 
		{
		    String sCurrentLine;
		    while ((sCurrentLine = br.readLine()) != null){
		        contentBuilder.append(sCurrentLine).append("\n");
		    }
		} catch (IOException e)	{
		    e.printStackTrace();
		}
		fileContent = contentBuilder.toString();
		Tttc(fileContent);
	}

   public static void Tttc(String Cc) {
		StringSelection data = new StringSelection(Cc);
		Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
		cb.setContents(data, data);
		try {
		     Transferable t = cb.getContents(null);
		     if (t.isDataFlavorSupported(DataFlavor.stringFlavor))
		        System.out.println(t.getTransferData(DataFlavor.stringFlavor));
		} catch (UnsupportedFlavorException | IOException ex) {
		     System.out.println("");
		}
   	}
}

