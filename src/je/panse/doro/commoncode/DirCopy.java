package commoncode;

import java.io.File;			
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import commoncode.item_administratus.file.ChartplateCreator;
import singlebeam.EntryDir;

public class DirCopy {
    public static void main(String[] args) {
        try {
            // Copy files from sourceDir to workingDir
            File sourceDirectory = new File(EntryDir.sourceDir);
            File workingDirectory = new File(EntryDir.workingDir);
            File backupDirectory = new File(EntryDir.backupDir);
            
            // Make sure directories exist
            if (!sourceDirectory.exists() || !workingDirectory.exists() || !backupDirectory.exists()) {
                System.out.println("One or more directories does not exist");
                return;
            }
            
            for (String fileName : sourceDirectory.list()) {
                File sourceFile = new File(sourceDirectory.getAbsolutePath() + "/" + fileName);
                File destinationFile = new File(workingDirectory.getAbsolutePath() + "/" + fileName);
                Files.copy(sourceFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            }
            
            ChartplateCreator.chartplateCreator();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
