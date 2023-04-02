package je.panse.doro.fourgate.ccpipmh;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import je.panse.doro.commoncode.item_administratus.file.SvaePresentCilp;
import je.panse.doro.singlebeam.EntryDir;

public class EMRPMH extends JFrame implements ActionListener {

    private JTextArea pmhxTextArea;
    private ArrayList<JCheckBox> checkBoxList;

    public EMRPMH() {
        super("Medical History");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create a panel to hold the checkboxes
        Font font = new Font("Arial", Font.PLAIN, 16);
        JPanel pmhxPanel = new JPanel();
        pmhxPanel.setLayout(new GridLayout(0, 3)); // Set the layout to a grid with 3 columns

        // Create the checkboxes and add them to the panel
        checkBoxList = new ArrayList<JCheckBox>();
        String[] checkboxLabels = { "Diabetes Mellitus", "HTN", "Dyslipidemia\n", "Cancer", "Operation",
                "Thyroid Disease\n", "Asthma", "Tuberculosis", "Pneumonia\n", "Chronic/Acute Hepatitis", "GERD",
                "Gout\n", "Arthritis", "Hearing Loss", "CVA\n", "Depression", "Cognitive Disorder\n", "Allergy\n",
                "Food", "Injection", "Medication" };
        for (String label : checkboxLabels) {
            JCheckBox checkbox = new JCheckBox(label);
            checkbox.setFont(font);
            checkBoxList.add(checkbox);
            pmhxPanel.add(checkbox);
        }

        // Create a scrollable text area to display the medical history
        pmhxTextArea = new JTextArea(20, 40);
	    pmhxTextArea.setText("");
        pmhxTextArea.setEditable(true);
        pmhxTextArea.setFont(font);

        JScrollPane pmhxScrollPane = new JScrollPane(pmhxTextArea);

        // Create a panel to hold the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        JButton saveShowButton = new JButton("Save and Show");
        JButton clearButton = new JButton("Clear and Restart");
        JButton saveQuitButton = new JButton("Save and Quit");
        buttonPanel.add(saveShowButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(saveQuitButton);

        // Add everything to the main frame
        add(pmhxPanel, BorderLayout.NORTH);
        add(pmhxScrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Register action listeners for the buttons
        saveShowButton.addActionListener(this);
        clearButton.addActionListener(this);
        saveQuitButton.addActionListener(this);

        // Display the frame
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if (e.getActionCommand().equals("Save and Show")) {

            StringBuilder sb = new StringBuilder();
            sb.append("Past Medical History:\n");
            for (JCheckBox checkbox : checkBoxList) {
                if (checkbox.isSelected()) {
                    sb.append("☑ ");
                } else {
                    sb.append("☐ ");
                }
                sb.append(checkbox.getText());
                sb.append("\t");
            }
            sb.append("\n---------------------------------\n");
            pmhxTextArea.append(sb.toString());

            try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(EntryDir.workingDir+ "/3PMH"));
				//BufferedWriter writer = new BufferedWriter(new FileWriter(EntryDir.workingDir+ "/4PMH",true));
				// Write the contents of the text area to the file
				writer.write(pmhxTextArea.getText());
				// Close the writer
				writer.close();
				// Show a message to the user indicating that the save was successful
				JOptionPane.showMessageDialog(null, "File saved successfully.");
        	} catch (IOException ex) {
        	    // Show an error message to the user indicating that the save failed
        	    JOptionPane.showMessageDialog(null, "Error saving file: " + ex.getMessage());
        	}
			} else if (e.getActionCommand().equals("Clear and Restart")) {
			    pmhxTextArea.setText("");
			    for (JCheckBox checkbox : checkBoxList) {
			        checkbox.setSelected(false);
			    }
				dispose();
			    
			} else if (e.getActionCommand().equals("Save and Quit")) {
			    // TODO: Implement save and quit functionality
			    JOptionPane.showMessageDialog(this, "Save and Quit not yet implemented.");
				dispose();
				try {
					SvaePresentCilp.saveToFile(2,"\t" + pmhxTextArea.getText());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			    }
			}
    public static void main(String[] args) throws IOException {
        EMRPMH gui = new EMRPMH();
//        gui.actionPerformed(new ActionEvent(gui, 0, "Save and Show"));
    }
}