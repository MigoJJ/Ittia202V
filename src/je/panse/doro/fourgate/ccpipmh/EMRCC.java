package je.panse.doro.fourgate.ccpipmh;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class EMRCC extends JFrame implements ActionListener {
    private JTextArea inputArea1, inputArea2, outputArea;
    private JButton clearButton, saveButton, saveAndQuitButton;
    
    public EMRCC() {
        // set up the JFrame
        setTitle("EMR Interface");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // create the input JTextAreas and label them
        inputArea1 = new JTextArea();
        inputArea1.setBorder(BorderFactory.createTitledBorder("CC>"));
        inputArea1.setBackground(new Color(255, 255, 204)); // very light yellow
        inputArea2 = new JTextArea();
        inputArea2.setBorder(BorderFactory.createTitledBorder("PI>"));
        inputArea2.setBackground(new Color(255, 255, 153)); // light yellow
        
        // create the output JTextArea and label it
        outputArea = new JTextArea();
        outputArea.setBorder(BorderFactory.createTitledBorder("TEMP edit>"));
        outputArea.setBackground(new Color(255, 204, 0)); // dark yellow
        
        // create the buttons
        clearButton = new JButton("Clear");
        clearButton.addActionListener(this);
        saveButton = new JButton("Save");
        saveButton.addActionListener(this);
        saveAndQuitButton = new JButton("Save and Quit");
        saveAndQuitButton.addActionListener(this);
        
        // create a JPanel to hold the input JTextAreas
        JPanel inputPanel = new JPanel(new GridLayout(3, 1));
        inputPanel.add(inputArea1);
        inputPanel.add(inputArea2);

        // create a JPanel to hold the output JTextArea and add it to a scroll pane
        JScrollPane scrollPane = new JScrollPane(outputArea);
        JPanel outputPanel = new JPanel(new BorderLayout());
        outputPanel.add(new JLabel(BorderLayout.CENTER));
        outputPanel.add(scrollPane, BorderLayout.CENTER);
        outputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // create a JPanel to hold the buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(clearButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(saveAndQuitButton);
        
        // add the input and output panels to the JFrame
        add(inputPanel, BorderLayout.NORTH);
        add(outputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.PAGE_END);
        
        // show the JFrame
        setVisible(true);
        
     // add a DocumentListener to inputArea1
        inputArea1.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                updateOutput();
            }
            public void removeUpdate(DocumentEvent e) {
                updateOutput();
            }
            public void insertUpdate(DocumentEvent e) {
                updateOutput();
            }
            private void updateOutput() {
                outputArea.setText(inputArea1.getText());
            }
        });
        inputArea2.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                updateOutput();
            }
            public void removeUpdate(DocumentEvent e) {
                updateOutput();
            }
            public void insertUpdate(DocumentEvent e) {
                updateOutput();
            }
            private void updateOutput() {
                outputArea.setText(inputArea2.getText());
            }
        });

    }
    
    // handle button clicks
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clearButton) {
            inputArea1.setText("");
            inputArea2.setText("");
            outputArea.setText("");
        } else if (e.getSource() == saveButton) {
            saveToFile(false);
        } else if (e.getSource() == saveAndQuitButton) {
            saveToFile(true);
            System.exit(0);
        }
    }
    // save the input text to a file
    private void saveToFile(boolean quit) {
        String filename = "emr_data.txt";
        String input1 = inputArea1.getText();
        String input2 = inputArea2.getText();
        String output = outputArea.getText();
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(filename, true));
            writer.println("Input 1: " + input1);
            writer.println("Input 2: " + input2);
            writer.println("Output: " + output);
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        if (quit) {
            System.exit(0);
        }
    }
    
    public static void main(String[] args) {
        EMRInterface emr = new EMRInterface();
    }
}
