package fourgate.ccpipmh;

import javax.swing.*;	
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import commoncode.item_administratus.file.SvaePresentCilp;
import singlebeam.EntryDir;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class EMRCC extends JFrame implements ActionListener, DocumentListener {
    private JTextField[] textFields;
    private JTextArea textArea;

    public EMRCC() {
        // Set up the window
        setTitle("Electronic Medical Record Interface");
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the text fields
        String[] labels = {"Chief Complaint : ",
                "Onset : (days/ months/ years ago) : ",
                "Duration : (days/ months/ years) : ",
                "State of Health (Excellent/Good/Fair/Poor) : "};

        textFields = new JTextField[labels.length];
        JPanel textFieldsPanel = new JPanel(new GridLayout(labels.length, 2));
        for (int i = 0; i < labels.length; i++) {
            JLabel label = new JLabel(labels[i]);
            label.setHorizontalAlignment(SwingConstants.RIGHT);
            textFieldsPanel.add(label);
            JTextField textField = new JTextField();
            textField.getDocument().addDocumentListener(this); // Add a DocumentListener
            textFields[i] = textField;
            textFields[i].setHorizontalAlignment(JTextField.CENTER);

            final int index = i;
            textFields[i].addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        int next = index + 1;
                        if (next < textFields.length) {
                            textFields[next].requestFocus();
                        } else {
                            textArea.requestFocus();
                        }
                    }
                }
            });

            textFieldsPanel.add(textField);
        }

        // Create the text area
        JLabel textAreaLabel = new JLabel("< Chief complaint Chart Plate >");
	//        textArea = new JTextArea(5, 20);
	        textArea = new JTextArea();
	        textArea.setPreferredSize(new Dimension(200, 200));
	        textArea.setEditable(true);
	        JScrollPane scrollPane = new JScrollPane(textArea);
		        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		        JPanel textAreaPanel = new JPanel(new BorderLayout());
		        textAreaPanel.add(textAreaLabel, BorderLayout.NORTH);
		        textAreaPanel.add(scrollPane, BorderLayout.CENTER);

        // Create the buttons
        JButton saveAndQuitButton = new JButton("Save and Quit");
	        saveAndQuitButton.addActionListener(this);
	        saveAndQuitButton.setPreferredSize(new Dimension(150, 50));
	        JButton clearDataButton = new JButton("Clear Data and Restart");
	        clearDataButton.addActionListener(this);
	        JPanel buttonsPanel = new JPanel(new GridLayout(1, 2));
	        buttonsPanel.add(saveAndQuitButton);
	        buttonsPanel.add(clearDataButton);

        // Add everything to the window
        Container contentPane = getContentPane();
        contentPane.add(textFieldsPanel, BorderLayout.CENTER);
        contentPane.add(textAreaPanel, BorderLayout.NORTH);
        contentPane.add(buttonsPanel, BorderLayout.SOUTH);
        
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("Save and Quit")) {
            // Save the data and quit
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(EntryDir.workingDir+ "/3CC",true));
//                for (JTextField textField : textFields) {
//                    writer.write(textField.getText());
//                    writer.newLine();
//                }
                writer.write(textArea.getText());
                writer.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error saving data", "Error", JOptionPane.ERROR_MESSAGE
                        );
            }

        } else if (command.equals("Clear Data and Restart")) {
            // Clear the text fields and text area
            for (JTextField textField : textFields) {
                textField.setText("");
            }
        }
		try {
			SvaePresentCilp.saveToFile(0,"\t" + textArea.getText());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
       textArea.setText("");
		dispose();
    }

    public void insertUpdate(DocumentEvent e) {
        // Update the text area with the new values
        String newText = "";
        for (JTextField textField : textFields) {
            newText += textField.getText() + "\n";
        }
        textArea.setText(newText);
    }

    public void removeUpdate(DocumentEvent e) {
        // Do nothing
    }

    public void changedUpdate(DocumentEvent e) {
        // Do nothing
    }
    
    public static void main(String[] args) {
        EMRCC emr = new EMRCC();
        emr.setVisible(true);
    }
}
