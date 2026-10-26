package lab.assignments;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Swing_Example {
    public static void main(String[] args) {
        // Create the frame (window)
        JFrame frame = new JFrame("My First Swing Program");

        // Create components
        JLabel label = new JLabel("Enter your name:");
        JTextField textField = new JTextField(15);
        JButton button = new JButton("Submit");
        JLabel result = new JLabel("");

        // Create a panel
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        // Add components to panel
        panel.add(label);
        panel.add(textField);
        panel.add(button);
        panel.add(result);

        // Button click event
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = textField.getText();
                result.setText("Hello, " + name + "!");
            }
        });

        // Add panel to frame
        frame.add(panel);

        // Frame settings
        frame.setSize(400, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}