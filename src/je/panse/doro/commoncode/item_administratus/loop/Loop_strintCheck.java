package commoncode.item_administratus.loop;

public class Loop_strintCheck {

	public static boolean main(String args) {
		boolean argsb = Loop_strintCheck.isNumeric(args);
		return argsb;
	}
	public static boolean isNumeric(String str) {
		    if (str == null) {
		        return false;
		    }
		    try {
		        Double.parseDouble(str);
		        return true;
		    } catch (NumberFormatException nfe) {
		        return false;
		    }
		}
}