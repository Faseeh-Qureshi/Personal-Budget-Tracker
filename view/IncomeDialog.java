package view;

import controller.BudgetController;
import model.Income;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class IncomeDialog extends JDialog {
    public IncomeDialog(JFrame parent, BudgetController controller) {
        super(parent, "Add Income", true);
        setLayout(new GridLayout(0, 2, 5, 5));
        setSize(300, 200);
        setLocationRelativeTo(parent);

        JLabel amountLbl = new JLabel("Amount:");
        JTextField amountField = new JTextField();
        JLabel sourceLbl = new JLabel("Source:");
        JTextField sourceField = new JTextField();

        JButton addBtn = new JButton("Add");
        JButton cancelBtn = new JButton("Cancel");

        add(amountLbl); add(amountField);
        add(sourceLbl); add(sourceField);
        add(addBtn); add(cancelBtn);

        addBtn.addActionListener(e -> {
            try {
                double amount = Double.parseDouble(amountField.getText());
                String source = sourceField.getText();
                if (amount <= 0 || source.isEmpty()) throw new Exception();
                controller.addIncome(new Income(amount, source, new Date()));
                JOptionPane.showMessageDialog(this, "Income added!");
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid input!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        cancelBtn.addActionListener(e -> dispose());
        setVisible(true);
    }
}
