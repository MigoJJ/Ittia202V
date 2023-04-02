package je.panse.doro.commoncode.item_administratus.loop;

import java.util.*;				
import java.text.*;

public class CurrentDateAdd_date {
	public static String save_time;

	public static String defineTime(String df) {
		  Date dNow = new Date( );
	      SimpleDateFormat ft = new SimpleDateFormat ("E'요일'  yyyy.MM.dd 'at' hh:mm:ss a zzz");
	      
	      if (df == "y") {
		      ft = new SimpleDateFormat ("yyyy");
	      }
	      else if (df == "m") {
		      ft = new SimpleDateFormat ("yyyy.MM");
	      }
	      else if (df == "d") {
	    	  ft = new SimpleDateFormat ("yyyy.MM.dd");
	      }
	      else {
	    	  ft =  new SimpleDateFormat ("yyyy.MM.dd E  hh:mm a ");  
	      }
	      save_time = ft.format(dNow);
	      System.out.println("Current Date: " + ft.format(dNow));
	      return save_time;
	}

	public static String main(String args) {
		String dateinput = args;
		CurrentDateAdd_date add_date = new CurrentDateAdd_date();
		String rcd = add_date.defineTime(dateinput);
		System.out.println("Returned Current Date: " + rcd);		
	   return rcd;
	}
}