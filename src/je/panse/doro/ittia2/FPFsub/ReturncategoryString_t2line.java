package je.panse.doro.ittia2.FPFsub;

public class ReturncategoryString_t2line {
	static String returnta = null;
	public static String ncmChief(String args) {
		returnta = ("[ Chief Complaint ] \r\n"
				+ "------------------------------\r\n"
				+ "	1.  Chief complaint\r\n"
				+ "	2.  Onset\r\n"
				+ "	3.  Year/Month/Days\r\n"
				+ "	10. Disease follow-up\r\n"
				+ "------------------------------\r\n"
				+ "9 chief 99 New 999 Clear&Quit\n");
		return returnta;
	}
}