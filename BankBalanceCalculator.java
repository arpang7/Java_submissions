package lab.assignments;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankBalanceCalculator extends JFrame implements ActionListener {
    private JTextField balanceField;
    private JTextField amountField;
    private JLabel resultLabel;
    private JButton depositButton;
    private JButton withdrawButton;

    public BankBalanceCalculator() {
        setTitle("Bank Balance Calculator");
        setSize(400, 260);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2, 10, 10));

        // Form Labels & TextFields
        add(new JLabel("  Current / Initial Balance ($):"));
        balanceField = new JTextField();
        add(balanceField);

        add(new JLabel("  Transaction Amount ($):"));
        amountField = new JTextField();
        add(amountField);

        // Buttons
        depositButton = new JButton("Deposit (+)");
        withdrawButton = new JButton("Withdraw (-)");
        depositButton.addActionListener(this);
        withdrawButton.addActionListener(this);

        add(depositButton);
        add(withdrawButton);

        // Result Display
        add(new JLabel("  Updated Balance:"));
        resultLabel = new JLabel("$0.00");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 14));
        add(resultLabel);

        // Reset helper notice
        JLabel noteLabel = new JLabel("  *Balance updates automatically");
        noteLabel.setFont(new Font("Arial", Font.ITALIC, 11));
        noteLabel.setForeground(Color.GRAY);
        add(noteLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double currentBalance = Double.parseDouble(balanceField.getText().trim());
            double amount = Double.parseDouble(amountField.getText().trim());

            if (amount < 0) {
                JOptionPane.showMessageDialog(this, 
                    "Transaction amount must be positive.", 
                    "Invalid Amount", 
                    JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (e.getSource() == depositButton) {
                currentBalance += amount;
            } else if (e.getSource() == withdrawButton) {
                if (amount > currentBalance) {
                    JOptionPane.showMessageDialog(this, 
                        "Insufficient funds! Cannot withdraw more than the available balance.", 
                        "Overdraft Alert", 
                        JOptionPane.ERROR_MESSAGE);
                    return;
                }
                currentBalance -= amount;
            }

            // Update balance field and result label
            balanceField.setText(String.format("%.2f", currentBalance));
            resultLabel.setText(String.format("$%.2f", currentBalance));
            amountField.setText(""); // Clear transaction input field for next entry

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, 
                "Please enter valid numeric values for balance and amount.", 
                "Input Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new BankBalanceCalculator().setVisible(true);
        });
    }
}