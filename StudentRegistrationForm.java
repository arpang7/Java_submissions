package lab.assignments;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentRegistrationForm extends JFrame implements ActionListener {
    private JTextField nameField, emailField;
    private JRadioButton maleRadio, femaleRadio;
    private JComboBox<String> courseBox;
    private JButton submitButton, resetButton;

    public StudentRegistrationForm() {
        setTitle("Student Registration Form");
        setSize(420, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 2, 10, 10));

        // Name
        add(new JLabel("  Full Name:"));
        nameField = new JTextField();
        add(nameField);

        // Email
        add(new JLabel("  Email Address:"));
        emailField = new JTextField();
        add(emailField);

        // Gender (Radio Buttons + ButtonGroup)
        add(new JLabel("  Gender:"));
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        maleRadio = new JRadioButton("Male");
        femaleRadio = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);
        genderPanel.add(maleRadio);
        genderPanel.add(femaleRadio);
        add(genderPanel);

        // Course Dropdown
        add(new JLabel("  Course:"));
        String[] courses = {"Computer Science", "Information Technology", "Mechanical", "Civil", "Electronics"};
        courseBox = new JComboBox<>(courses);
        add(courseBox);

        // Action Buttons
        submitButton = new JButton("Register");
        resetButton = new JButton("Reset");
        submitButton.addActionListener(this);
        resetButton.addActionListener(this);
        add(submitButton);
        add(resetButton);

        // Bottom status placeholder
        add(new JLabel(""));
        add(new JLabel(""));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String name = nameField.getText().trim();
            String email = emailField.getText().trim();
            String gender = maleRadio.isSelected() ? "Male" : (femaleRadio.isSelected() ? "Female" : "Not specified");
            String course = (String) courseBox.getSelectedItem();

            if (name.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill out Name and Email.", "Missing Information", JOptionPane.WARNING_MESSAGE);
                return;
            }

            String summary = "Student Registered Successfully!\n\n"
                    + "Name: " + name + "\n"
                    + "Email: " + email + "\n"
                    + "Gender: " + gender + "\n"
                    + "Course: " + course;

            JOptionPane.showMessageDialog(this, summary, "Registration Summary", JOptionPane.INFORMATION_MESSAGE);

        } else if (e.getSource() == resetButton) {
            nameField.setText("");
            emailField.setText("");
            courseBox.setSelectedIndex(0);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentRegistrationForm().setVisible(true));
    }
}