package je.panse.doro.commoncode.item_administratus.key;

import java.util.Scanner;

public class Key_replaceWord {
	public static String main(String oriText) {
		Scanner sc= new Scanner(System.in);  
		System.out.print(".............Enter a string............: \n");  
		String str= sc.nextLine();               
		String foriText = oriText.replace("[   ]", "[ " + str +" ]");
		System.out.print("You have entered:repText>>> "+ foriText +"\n\n");  
		return foriText;
	}
}