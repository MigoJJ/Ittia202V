package je.panse.doro.fourgate.objective;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import je.panse.doro.commoncode.item_administratus.file.SvaePresentCilp;
import je.panse.doro.commoncode.item_administratus.loop.CurrentDateAdd_date;

public class BMICalculator extends JFrame implements ActionListener {
    // GUI components
    private JLabel weightLabel, heightLabel, waistLabel, bmiLabel;
    private JTextField weightField, heightField, waistField, bmiField;
    private JButton calculateButton;

    // Constructor
    public BMICalculator() {
        // Set up the JFrame
        setTitle("BMI Calculator");
        setSize(1200, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set up the GUI components
        weightLabel = new JLabel("Weight (kg): ");
        weightField = new JTextField(10);
        BMITextFieldFormat(weightField);
        weightField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    heightField.requestFocus();
                }
            }
        });

        heightLabel = new JLabel("Height (m): ");
        heightField = new JTextField(10);
        BMITextFieldFormat(heightField);        
        heightField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    waistField.requestFocus();
                }
            }
        });

        waistLabel = new JLabel("Waist (cm): ");
        waistField = new JTextField(10);
        BMITextFieldFormat(waistField);
        waistField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    calculateButton.doClick();
                }
            }
        });

        bmiLabel = new JLabel("BMI: ");
        bmiField = new JTextField(10);
        bmiField.setFont(new Font("Arial", Font.PLAIN, 16));
        bmiField.setEditable(false);
        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(this);

        // Add the components to the JFrame
        setLayout(new FlowLayout());

        add(weightLabel);
        add(weightField);
        add(heightLabel);
        add(heightField);
        add(waistLabel);
        add(waistField);
        add(bmiLabel);
        add(bmiField);
        add(calculateButton);
        // Display the JFrame
        setVisible(true);
    }
    
    public void BMITextFieldFormat (JTextField nfield) {
    	nfield.setHorizontalAlignment(JTextField.CENTER);
    	nfield.setFont(new Font("Arial", Font.PLAIN, 16));
    	nfield.setHorizontalAlignment(JTextField.CENTER);
    	add(nfield, BorderLayout.CENTER);
    }

    // Action listener for the Calculate button
    public void actionPerformed(ActionEvent event) {
        // Get the weight and height values
        double weight = Double.parseDouble(weightField.getText());
        double height = Double.parseDouble(heightField.getText());
        // Calculate the BMI and display the result
        double bmi = weight / (height * height/10000);
        String formattedBmi = String.format("%.1f", bmi);
        double parsedBmi = Double.parseDouble(formattedBmi);
        bmiField.setText(formattedBmi);
        // Write the BMI to a file
		try {
			SaveEachfile("BMI:[ " + Double.toString(parsedBmi) + " ]/kg/m2   "
				+ "weight:[ " + weight + " ]kg    " 
				+ "height:[ " + height + " ]cm");
			if (!waistField.getText().isEmpty()) {
			double waist = Double.parseDouble(waistField.getText());
			SaveEachfile("Waist: " + Double.toString(waist) + " cm");
			}
			SaveEachfile(8,BMItoAssessment(parsedBmi));
		} catch (IOException e) {
		    System.out.println("Error writing to file: " + e.getMessage());
		}
    	dispose();
    }

    public static void SaveEachfile(String A) throws IOException {
    	SvaePresentCilp.saveToFile(6,"\t" + A);
    }
    public static void SaveEachfile(int targetfile, String A) throws IOException {
    	SvaePresentCilp.saveToFile(targetfile,"\t#  " + A);
    }
    
    private static String BMItoAssessment(double BMI) throws IOException {
		String bmicategory = "";
		String dateTime = CurrentDateAdd_date.defineTime("d");
		if (BMI < 18.5) {
		    bmicategory = "Underweight [ " + BMI+ " ]BMI ";
		} else if (BMI >= 18.5 && BMI < 25) {
		    bmicategory = "Healthy Weight[ " + BMI+ " ]BMI ";
		} else if (BMI >= 25 && BMI < 30) {
		    bmicategory = "Overweight Weight [ " + BMI+ " ]BMI ";
		} else if (BMI >= 30) {
		    bmicategory = "Obesity [ " + BMI+ " ]BMI ";
		}
       return bmicategory + dateTime;
    }
    
    
    // Main method
    public static void main(String[] args) {
        new BMICalculator();
    }
}
