package je.panse.doro.fourgate.ccpipmh;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import je.panse.doro.singlebeam.EntryDir;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class EMRCC extends JFrame implements ActionListener {
    private JTextArea inputArea1, inputArea2, outputArea;
    private JButton clearButton, saveButton, saveAndQuitButton;

    public EMRCC() throws IOException {
        // set up the JFrame
        setTitle("EMR Interface");
        setSize(500, 700);
        setResizable(true); 
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create the input JTextAreas and label them
        inputArea1 = new JTextArea();
        inputArea1.setBackground(new Color(255, 255, 204)); // very light yellow
        inputArea2 = new JTextArea();
        inputArea2.setBackground(new Color(255, 255, 153)); // light yellow
        // create the output JTextArea and label it
        outputArea = new JTextArea();
        outputArea.setBackground(new Color(255, 255, 130)); // dark yellow

        // set up scrolling and cursor to bottom for all JTextAreas
        inputArea1 = new JTextArea();
        inputArea1.setPreferredSize(new Dimension(inputArea1.getPreferredSize().width, 100));
        inputArea1.setBorder(BorderFactory.createTitledBorder("CC>"));
        inputArea1.setBackground(new Color(255, 255, 204)); // very light yellow
        inputArea1.setLineWrap(true);
        inputArea1.setWrapStyleWord(true);
        JScrollPane inputScroll1 = new JScrollPane(inputArea1);
        inputScroll1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        inputScroll1.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
            public void adjustmentValueChanged(AdjustmentEvent e) {
                inputArea1.select(inputArea1.getCaretPosition()*1000,0);
            }
        });
            
        inputArea2 = new JTextArea();
        inputArea2.setBorder(BorderFactory.createTitledBorder("PI>"));
        inputArea2.setBackground(new Color(255, 255, 153)); // light yellow
        inputArea2.setLineWrap(true);
        inputArea2.setWrapStyleWord(true);
        JScrollPane inputScroll2 = new JScrollPane(inputArea2);
        inputScroll2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        inputScroll2.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
            public void adjustmentValueChanged(AdjustmentEvent e) {
                inputArea2.select(inputArea2.getCaretPosition()*1000,0);
            }
        });

        outputArea = new JTextArea();
        outputArea.setBorder(BorderFactory.createTitledBorder("TEMP edit>"));
        outputArea.setBackground(new Color(255, 204, 0)); // dark yellow
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);
        JScrollPane outputScroll = new JScrollPane(outputArea);
        outputScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        outputScroll.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
            public void adjustmentValueChanged(AdjustmentEvent e) {
                outputArea.select(outputArea.getCaretPosition()*1000,0);
            }
        });
     
        // create the buttons
        clearButton = new JButton("Clear");
        clearButton.addActionListener(this);
        saveButton = new JButton("Save");
        saveButton.addActionListener(this);
        saveAndQuitButton = new JButton("Save and Quit");
        saveAndQuitButton.addActionListener(this);

        // create a JPanel to hold the input JTextAreas
        JPanel inputPanel = new JPanel(new GridLayout(3, 1));
        inputPanel.add(inputArea1, BorderLayout.NORTH);
        inputPanel.add(inputArea2, BorderLayout.CENTER);
        inputPanel.add(outputArea, BorderLayout.CENTER);
        
        // create a JPanel to hold the output JTextArea and add it to a scroll pane
        JScrollPane scrollPane = new JScrollPane(outputArea);
        JPanel outputPanel = new JPanel(new BorderLayout());
        outputPanel.add(new JLabel("Output:"), BorderLayout.CENTER);
        outputPanel.add(scrollPane, BorderLayout.CENTER);
        outputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // create a JPanel to hold the buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(clearButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(saveAndQuitButton);

        // add the input and output panels to the JFrame
        add(inputPanel, BorderLayout.CENTER);
        add(outputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.PAGE_END);

       
        // show the JFrame
        setVisible(true);
        
     	// add a DocumentListener to inputArea1
        inputArea1.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                try {
					updateOutput();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
            public void removeUpdate(DocumentEvent e) {
                try {
					updateOutput();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
            public void insertUpdate(DocumentEvent e) {
                try {
					updateOutput();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
            private void updateOutput() throws IOException {
//                outputArea.setText(inputArea1.getText());
                outputArea.setText(inputArea1.getText() + "\n" + inputArea2.getText());
                outputArea.setCaretPosition(outputArea.getDocument().getLength());
                
                System.out.println(" outputArea.setCaretPosition(outputArea.getDocument().getLength());"+outputArea.getText());
                EMRCCabrreturn.diseaseCode(outputArea.getText());
                
            }
        });
        inputArea2.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                try {
					updateOutput();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
            public void removeUpdate(DocumentEvent e) {
                try {
					updateOutput();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
            public void insertUpdate(DocumentEvent e) {
                try {
					updateOutput();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
            private void updateOutput() throws IOException {
//                outputArea.setText(inputArea2.getText());
                outputArea.setText(inputArea1.getText() + "\n" + inputArea2.getText());
                outputArea.setCaretPosition(outputArea.getDocument().getLength());
                
                System.out.println(" outputArea.setCaretPosition(outputArea.getDocument().getLength());"+outputArea.getText());
                EMRCCabrreturn.diseaseCode(outputArea.getText());
                
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
        String filename = EntryDir.workingDir + "/3CC";
//        String input1 = inputArea1.getText();
//        String input2 = inputArea2.getText();
        String output = outputArea.getText();
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(filename, true));
//            writer.println("Input 1: " + input1);
//            writer.println("Input 2: " + input2);
            writer.println("Output: " + output);
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        if (quit) {
            System.exit(0);
        }
    }
    
    public static void main(String[] args) throws IOException {
        EMRCC emr = new EMRCC();
    }
}
