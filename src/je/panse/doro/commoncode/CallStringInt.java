package je.panse.doro.commoncode;

import java.io.IOException;
import je.panse.doro.commoncode.item_administratus.file.SvaePresentCilp;
import je.panse.doro.ittia2.FPF;
import je.panse.doro.ittia2.FPFsub.ReturncatergoryList;

public class CallStringInt extends FPF {
	public static String replaceStr(int index, String args) throws IOException {
		String input = args;
		String taString = textAreas[index].getText().trim();
		try {
			int numInput = Integer.parseInt(input);
			taString = ReturncatergoryList.returncategorylist(index,numInput,taString);
			return taString;
		} catch (NumberFormatException ex) {
			// replace from acronym to original
			String strinput = Readacronym.readSentence(input);
			SvaePresentCilp.saveToFile(index,strinput);
		   return strinput;
		}
   	}
}