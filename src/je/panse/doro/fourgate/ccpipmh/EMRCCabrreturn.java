package je.panse.doro.fourgate.ccpipmh;

import java.io.IOException;

import javax.swing.JTextArea;

import je.panse.doro.commoncode.DiseaseCode;

public class EMRCCabrreturn {

	public static void diseaseCode(String outputArea) throws IOException {
		String[] words = outputArea.split(" ");

	    for (String word : words) {
	    	
	        System.out.println(word);

	    	word.replace(":","");
	       word = DiseaseCode.code_select(word);
	        System.out.println(word);

	        
	        
	        
	        
	    }
				
	}
}
