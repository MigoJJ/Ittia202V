package je.panse.doro.singlebeam;

import je.panse.doro.commoncode.DirCopy;	
import je.panse.doro.ittia2.FPF;

public class EntryDir {
	
	public static final String currentUsersDir = System.getProperty("user.dir");
	public static final String currentUsersHomeDir = System.getProperty("user.home");
	public static final String homeDir = currentUsersDir + "/src/je/panse/doro";
//	public static final String homeDir = currentUsersDir;
	public static String workingDir = homeDir + "/datatext/samsara";
	public static String backupDir = homeDir + "/datatext/tripikata";
	public static String sourceDir = homeDir + "/datatext/knots/hana";
	
	public static String cpfPath = workingDir + "/chartplate";
	public static String backupFilePath = backupDir + "/somefile.txt";	

	public static void main(String[] args) {
    	DirCopy.main(null);
    	
    	System.out.println("currentUsersDir = System.getProperty(user.dir)" + currentUsersDir);
    	System.out.println("currentUsersHomeDir = System.getProperty(user.dir)" + currentUsersHomeDir);
    	System.out.println("homeDir = System.getProperty(user.dir)" + homeDir);
    	System.out.println("workingDir = System.getProperty(user.dir)" + workingDir);
    	System.out.println("/home/woon/chatGPT/ITTIAVersion202/Ittia202V/src/je/panse/doro/datatext/samsara/chartplate");
    	    	
    	FPF.main(args);
	}
}
