package view;

import controller.BudgetController;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class ExpenseDialog extends JDialog {
    public ExpenseDialog(JFrame parent, BudgetController controller) {
        super(parent, "Add Expense", true);
        setLayout(new GridLayout(0, 2, 5, 5));
        setSize(300, 250);
        setLocationRelativeTo(parent);

        JLabel amountLbl = new JLabel("Amount:");
        JTextField amountField = new JTextField();
        JLabel categoryLbl = new JLabel("Category:");
        JComboBox<Category> categoryBox = new JComboBox<>(Category.values());

        JButton addBtn = new JButton("Add");
        JButton cancelBtn = new JButton("Cancel");

        add(amountLbl); add(amountField);
        add(categoryLbl); add(categoryBox);
        add(addBtn); add(cancelBtn);

        addBtn.addActionListener(e -> {
            try {
                double amount = Double.parseDouble(amountField.getText());
                Category category = (Category) categoryBox.getSelectedItem();
                if (amount <= 0) throw new Exception();
                controller.addExpense(new Expense(amount, category, new Date()));
                if (controller.isLimitExceeded(category)) {
                    JOptionPane.showMessageDialog(this, "Warning: Expense limit exceeded for " + category, "Warning", JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Expense added!");
                }
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid input!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        cancelBtn.addActionListener(e -> dispose());
        setVisible(true);
    }
}
