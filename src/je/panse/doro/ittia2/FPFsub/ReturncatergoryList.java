package je.panse.doro.ittia2.FPFsub;

import java.io.IOException;
import je.panse.doro.fourgate.ccpipmh.EMRCC;
import je.panse.doro.fourgate.ccpipmh.EMRPMH;
import je.panse.doro.fourgate.objective.BMICalculator;
import je.panse.doro.ittia2.FPF;

public class ReturncatergoryList extends FPF{
	public static String returncategorylist(int index, int numInput, String taString) throws IOException {
		String A = ReturncategoryString.newcategoryMenu(null);
		String B = ReturncategoryString.ncmObj(null);
		String C = ReturncategoryString.ncmLab(null);
		String D = ReturncategoryString_t2line.ncmChief(null);
			
		
		switch (numInput) {
			case 1:
				if (textAreas[index].getText().contains("[ New Category ]")) {
					EMRCC.main(null);
					textAreas[2].setText("");
					PFPpanelcategory.panelcategory(2);
					
				} else if (textAreas[index].getText().contains("[ Objective Findings ]")) {
					//					textAreas[index].setText(D);
					BMICalculator.main(null);
					textAreas[2].setText("");
					PFPpanelcategory.panelcategory(2);
				}
				break;
			case 2:
				if (textAreas[index].getText().contains("[ New Category ]")) {
					EMRPMH.main(null);
					textAreas[2].setText("");
					PFPpanelcategory.panelcategory(2);
					
				} 
			case 4:
				if (textAreas[index].getText().contains("[ New Category ]")) {
    				textAreas[index].setText(B);
				} else if (textAreas[index].getText().contains("[ Objective Findings ]")) {
					textAreas[index].setText(D);
				}
				break;
			case 5:
				if (textAreas[index].getText().contains("[ New Category ]") || textAreas[index].getText().contains("[ Objective Findings ]")) {
					textAreas[index].setText(C);
				}
				break;
			case 9:
			case 99:
				textAreas[index].setText(A);
				break;
			default:
				textAreas[index].setText(A);
				break;
		}
		
		return textAreas[index].getText().trim();
    }
}

