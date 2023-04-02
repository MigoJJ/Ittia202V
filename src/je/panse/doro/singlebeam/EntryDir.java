package je.panse.doro.singlebeam;

import je.panse.doro.commoncode.DirCopy;	
import je.panse.doro.ittia2.FPF;

public class EntryDir {
	
	public static final String currentUsersDir = System.getProperty("user.dir");
	public static final String currentUsersHomeDir = System.getProperty("user.home");
//	public static final String homeDir = currentUsersDir + "/src/je/panse/doro";
	public static final String homeDir = currentUsersDir + "/src/je/panse/doro";
	public static String workingDir = homeDir + "/datatext/samsara";
	public static String backupDir = homeDir + "/datatext/tripikata";
	public static String sourceDir = homeDir + "/datatext/knots/hana";
	public static String cpfPath = workingDir + "/chartplate";
	public static String backupFilePath = backupDir + "/somefile.txt";	

	public static void main(String[] args) {
    	DirCopy.main(null);
    	System.out.println("workingDir >>  " + workingDir);
    	System.out.println("cpfPath  >> " + cpfPath);
    	FPF.main(args);
	}
}
