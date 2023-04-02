package je.panse.doro.commoncode;

import java.io.IOException;

public class Readacronym {
    public static String readSentence(String args) throws IOException {
    	String[] words = args.split(" "); // Split the string into an array of words
    	String retword="";
    	for (String word : words) {
    	    if (word.contains(":")) {
    	        word = word.replace(":", "");
    	        word = DiseaseCode.code_select(word);
    	    	System.out.print("word = DiseaseCode.code_select(word); " + word);
    	    }
    	    retword = (retword + word +" "); 
    	}
		return "\t" + retword ;
	    
    }
}
