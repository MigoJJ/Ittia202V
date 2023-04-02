package ittia2.FPFsub;

public class ReturncategoryString {
	static String returnta = null;

	public static String newcategoryMenu(String args) {
		returnta = ("[ New Category ] \r\n"
				+ "------------------------------\r\n"
				+ "	1.   Chief complaint\r\n"
				+ "		11. Present illness\r\n"
				+ "		12. Symptom\r\n"
				+ "		13. ROS \r\n"
				+ "	2.   Past Medical History\r\n"
				+ "\r\n"
				+ "	3.   Subjective Complaint\r\n"
				+ "	4.   Objective Findings\r\n"
				+ "	5.   Laboratory Test\r\n"
				+ "\r\n"
				+ "	6.   Assessment \r\n"
				+ "	7.   Plan\r\n"
				+ "	\r\n"
				+ "	10.   Disease follow-up\r\n"
				+ "------------------------------\r\n"
				+ "9 chief 99 New 999 Clear&Quit\n");
		return returnta;
	}
	
	public static String ncmObj(String args) {
		returnta = ("[ Objective Findings ]\n"
				+ "-------------------------------	  \n"
				+ "		1. 	BMI  \n"
				+ "		2.	BP\n"
				+ "		\n"
				+ "		3. 	GFS CFS\n"
				+ "		\n"
				+ "		4.	Chest PA\n"
				+ "		5.	EKG\n"
				+ "				\n"
				+ "		6.	USG\n"
				+ "		7.	DEXA\n"
				+ "-------------------------------	  \n"
				+ "9 chief 99 New 999 Clear&Quit ");
		return returnta;
	}
	
	public static String ncmLab(String args) {
		returnta = ("[ Laboratory Findings ]\n"
				+ "-------------------------------	  \n"
				+ "		1.	glucose HbA1c \n"
				+ "		2.	TFT\n"
				+ "		3.	Lipid Battery\n"
				+ "		\n"
				+ "		4.	Cr eGFR +A/C\n"
				+ "		5.	25-OH-Vitamin-D\n"
				+ "	\n"
				+ "		6.	CBC\n"
				+ "		\n"
				+ "		7.	Lp(a)   APoB\n"
				+ "		\n"
				+ "		8.	GOT GPT GGT\n"
				+ "	   \n"
				+ "-------------------------------	  \n"
				+ "9 chief 99 New 999 Clear&Quit \n");
	
		return returnta;
	}
}