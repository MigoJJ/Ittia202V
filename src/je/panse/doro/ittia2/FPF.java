package je.panse.doro.ittia2;

import java.awt.*;	
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;
import je.panse.doro.commoncode.CallStringInt;
import je.panse.doro.ittia2.FPFsub.PFPpanelcategory;

public class FPF extends JFrame{
    public static JTextArea[] textAreas;
    public static JTextField[] textFields;
    
    public FPF() {
        // Set frame properties
        setTitle("ittia2 Frame");
        setSize(1200, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Initialize textFields and textAreas arrays
        textFields = new JTextField[4];
        textAreas = new JTextArea[4];
        // Create Panels
        JPanel panel1 = createPanel("CCPIPMH", 0);
        JPanel panel2 = createPanel("SUJOBJ", 1);
        JPanel panel3 = createPanel("TEMP", 2);
        JPanel panel4 = createPanel("ASSESSPLAN", 3);
        // Add panels to the frame
        setLayout(new GridLayout(2, 2));
        add(panel1);
        add(panel2);
        add(panel3);
        add(panel4);
        // Show the frame
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel createPanel(String name, int index) {
		Color lightGray = new Color(211, 211, 211); // RGB value for light gray
		Color skyBlue = new Color(135, 206, 235); // RGB value for sky blue
		// Create panel
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(BorderFactory.createTitledBorder(name));
		// Create components
		textAreas[index] = new JTextArea(); // Initialize the textArea at the given index
			textAreas[index].setText("");
			textAreas[index].append(PFPpanelcategory.panelcategory(index));
			textAreas[index].setCaretPosition(textAreas[index].getDocument().getLength());
			textAreas[index].setBackground(lightGray);
			panel.add(textAreas[index], BorderLayout.CENTER);
			JScrollPane scrollPane = new JScrollPane(textAreas[index]);
			panel.add(scrollPane, BorderLayout.CENTER);

		textFields[index] = new JTextField();
			Font font = textFields[index].getFont();
			Font newFont = new Font(font.getName(), font.getStyle(), 16);
			textFields[index].setPreferredSize(new Dimension(textFields[index].getPreferredSize().width, 40));
			textFields[index].addActionListener(new TextFieldListener(index));
			textFields[index].setFont(newFont);
			textFields[index].setBackground(skyBlue);
			textFields[index].setHorizontalAlignment(JTextField.CENTER);
			panel.add(textFields[index], BorderLayout.NORTH);
			
        JPanel buttonPanel = new JPanel(new GridLayout(1, 7));
        for (int i = 1; i <= 7; i++) {
            final int buttonIndex = i;
            JButton button = new JButton("Button " + i);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Action to perform when button is clicked
                    String text = "Button " + buttonIndex + " clicked in " + name + " panel\n";
                    textAreas[index].append(text);
                }
            });
            buttonPanel.add(button);
        }
        panel.add(buttonPanel, BorderLayout.SOUTH);
        return panel;
    	}

	    public static void main(String[] args) {
	    	new FPF();
	    }
    
    public class TextFieldListener implements ActionListener {
        private int index;
        public TextFieldListener(int index) {
            this.index = index;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
				String text = textFields[index].getText();
				String texta = textAreas[index].getText();
				try {
					text = CallStringInt.replaceStr(index,text);
					textAreas[index].setText("");
					textAreas[index].append(text + "\n");
					textFields[index].setText("");
				} catch (IOException e1) {
					e1.printStackTrace();
				}

        }
    }
}