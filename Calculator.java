package lab.assignments;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {

    JTextField num1Field, num2Field, resultField;
    JButton addButton, subtractButton;

    Calculator() {
        setTitle("Simple Calculator");
        setSize(350, 250);
        setLayout(new GridLayout(4, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new JLabel("First Number:"));
        num1Field = new JTextField();
        add(num1Field);

        add(new JLabel("Second Number:"));
        num2Field = new JTextField();
        add(num2Field);

        addButton = new JButton("Add");
        subtractButton = new JButton("Subtract");

        add(addButton);
        add(subtractButton);

        add(new JLabel("Result:"));
        resultField = new JTextField();
        resultField.setEditable(false);
        add(resultField);

        // Register buttons with ActionListener
        addButton.addActionListener(this);
        subtractButton.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());

            if (e.getSource() == addButton) {
                resultField.setText(String.valueOf(num1 + num2));
            } 
            else if (e.getSource() == subtractButton) {
                resultField.setText(String.valueOf(num1 - num2));
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                this,
                "Please enter valid numbers.",
                "Invalid Input",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}