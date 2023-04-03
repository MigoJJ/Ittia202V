package je.panse.doro.singlebeam;

import javax.swing.*;	
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class EntryIttia2 extends JFrame implements ActionListener {
    private ArrayList<JButton> buttons = new ArrayList<JButton>();
    public EntryIttia2() {
	    super("My JFrame with Buttons");
	    setSize(300, 300);
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLayout(new GridLayout(6, 1));
	
	    String[] buttonNames = {"Log In", "Prologue", "Version Information", "Rescue", "Ittia Start", "Quit"};
	
	    for (int i = 0; i < buttonNames.length; i++) {
	        JButton button = new JButton(buttonNames[i]);
	        button.addActionListener(this);
	        button.setBackground(Color.ORANGE); // Set the background color to ORANGE
	        buttons.add(button);
	        add(button);
	    }
	    setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		String buttonText = button.getText();
		System.out.println("Button \"" + buttonText + "\" was pressed.");
		
		try {
			ButtonPress(buttonText);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		dispose();
    }
    
    private void ButtonPress(String buttonText) throws IOException {
		try {
			if (buttonText.equals("Prologue")) {
			    Runtime.getRuntime().exec("gedit " + EntryDir.homeDir + "/datatext/singlebeam/Prologue");
				} else if (buttonText.equals("Version Information")) {
				    Runtime.getRuntime().exec("gedit " + EntryDir.homeDir + "/datatext/singlebeam/Version_Information");
				} else if (buttonText.equals("Ittia Start")) {
				        	Runtime.getRuntime().exec("java -cp "+ EntryDir.currentUsersDir +"/bin je.panse.doro.singlebeam.EntryDir");
				} else if (buttonText.equals("Rescue")) {
				    	Runtime.getRuntime().exec("java -cp "+ EntryDir.currentUsersDir +"/bin je.panse.doro.ittia2.FPF");
			} else {
				dispose();
			}
		} catch (IOException ex) {
		    ex.printStackTrace();
		}
    }
    
    public static void main(String[] args) {
    	EntryIttia2 myFrame = new EntryIttia2();
    }
}