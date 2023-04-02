package je.panse.doro.fourgate;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import je.panse.doro.singlebeam.EntryDir;

public class BMICalculator2 extends JFrame implements ActionListener {
    // GUI components
    private JLabel weightLabel, heightLabel, waistLabel, bmiLabel;
    private JTextField weightField, heightField, waistField, bmiField;
    private JButton calculateButton;

    // Constructor
    public BMICalculator2() {
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
            PrintWriter writer = new PrintWriter(new FileWriter(EntryDir.workingDir +"/6OBJ",true));
            writer.println("BMI: " + Double.toString(parsedBmi) + " /kg/m2");
            String BMIres =("BMI: " + Double.toString(parsedBmi) + " /kg/m2");


            if (!waistField.getText().isEmpty()) {
                double waist = Double.parseDouble(waistField.getText());
                writer.println("Waist: " + Double.toString(waist) + " cm");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    	dispose();
    }

    // Main method
    public static void main(String[] args) {
        new BMICalculator2();

    }
}
