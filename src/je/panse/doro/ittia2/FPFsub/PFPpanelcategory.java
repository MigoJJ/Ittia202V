package je.panse.doro.ittia2.FPFsub;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import je.panse.doro.ittia2.FPF;
import je.panse.doro.singlebeam.EntryDir;

public class PFPpanelcategory extends FPF {
    public static String panelcategory(int index) {
        String returnta = null;
        switch (index) {
            case 0:
                returnta = ReturncategoryString.newcategoryMenu(returnta);
                break;
            case 1:
                returnta = ReturncategoryString.ncmObj(returnta);
                break;
            case 2:
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(EntryDir.cpfPath));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        textAreas[index].append(line + "\n");
                    }
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                returnta = ReturncategoryString.ncmLab(returnta);
                break;
            default:
                break;
        }
        return returnta;
    }
}
