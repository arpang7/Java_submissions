package lab.assignments;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeRegistrationForm extends JFrame implements ActionListener {
    private JTextField idField, nameField, salaryField;
    private JComboBox<String> deptBox;
    private JButton submitButton, clearButton;

    public EmployeeRegistrationForm() {
        setTitle("Employee Registration");
        setSize(400, 260);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2, 10, 10));

        // Employee ID
        add(new JLabel("  Employee ID:"));
        idField = new JTextField();
        add(idField);

        // Employee Name
        add(new JLabel("  Employee Name:"));
        nameField = new JTextField();
        add(nameField);

        // Department
        add(new JLabel("  Department:"));
        String[] departments = {"Human Resources", "Engineering", "Finance", "Marketing", "Operations"};
        deptBox = new JComboBox<>(departments);
        add(deptBox);

        // Salary
        add(new JLabel("  Salary ($):"));
        salaryField = new JTextField();
        add(salaryField);

        // Buttons
        submitButton = new JButton("Submit Details");
        clearButton = new JButton("Clear");
        submitButton.addActionListener(this);
        clearButton.addActionListener(this);
        add(submitButton);
        add(clearButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String empId = idField.getText().trim();
            String name = nameField.getText().trim();
            String dept = (String) deptBox.getSelectedItem();
            String salaryText = salaryField.getText().trim();

            // Field validation
            if (empId.isEmpty() || name.isEmpty() || salaryText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "All fields are required.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Numeric check for salary
            try {
                double salary = Double.parseDouble(salaryText);

                String details = "=== Employee Details ===\n\n"
                        + "Employee ID: " + empId + "\n"
                        + "Name: " + name + "\n"
                        + "Department: " + dept + "\n"
                        + String.format("Salary: $%,.2f", salary);

                JOptionPane.showMessageDialog(this, details, "Submission Confirmation", JOptionPane.INFORMATION_MESSAGE);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid numeric salary.", "Invalid Number", JOptionPane.ERROR_MESSAGE);
            }

        } else if (e.getSource() == clearButton) {
            idField.setText("");
            nameField.setText("");
            salaryField.setText("");
            deptBox.setSelectedIndex(0);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EmployeeRegistrationForm().setVisible(true));
    }
}