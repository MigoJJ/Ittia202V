package je.panse.doro.fourgate.ccpipmh;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import je.panse.doro.commoncode.item_administratus.file.SvaePresentCilp;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class EMRPI extends JFrame {
    
    private JTextField inputField;
    private JTextArea outputArea;

    public EMRPI() {
        setTitle("Input Output Frame");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel inputLabel = new JLabel("Input:");
        inputLabel.setBounds(10, 10, 80, 25);
        add(inputLabel);

        inputField = new JTextField(20);
        inputField.setBounds(100, 10, 250, 25);
        add(inputField);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(360, 10, 80, 25);
        add(submitButton);

        outputArea = new JTextArea();
        outputArea.setBounds(10, 50, 450, 400);
        add(outputArea);

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                if (!input.equals("")) {
                    outputArea.append(input + "\n");
                    inputField.setText("");
                }else {
	    				try {
							SvaePresentCilp.saveToFile(1,"\t" + outputArea.getText());
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}	
                	dispose();
                }
            }
        });

        inputField.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {}
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String input = inputField.getText();
                    if (!input.equals("")) {
                        outputArea.append(input + "\n");
                        inputField.setText("");
                    }
                }
            }
            public void keyReleased(KeyEvent e) {}
        });
    }

    public static void main(String[] args) {
    	EMRPI frame = new EMRPI();
        frame.setVisible(true);
    }
}
