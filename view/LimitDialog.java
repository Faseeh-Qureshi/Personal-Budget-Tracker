package view;

import controller.BudgetController;
import model.Category;

import javax.swing.*;
import java.awt.*;

public class LimitDialog extends JDialog {
    public LimitDialog(JFrame parent, BudgetController controller) {
        super(parent, "Set Expense Limit", true);
        setLayout(new GridLayout(0, 2, 5, 5));
        setSize(300, 250);
        setLocationRelativeTo(parent);

        JLabel catLbl = new JLabel("Category:");
        JComboBox<Category> catBox = new JComboBox<>(Category.values());
        JLabel limitLbl = new JLabel("Limit:");
        JTextField limitField = new JTextField();

        JButton setBtn = new JButton("Set");
        JButton cancelBtn = new JButton("Cancel");

        add(catLbl); add(catBox);
        add(limitLbl); add(limitField);
        add(setBtn); add(cancelBtn);

        setBtn.addActionListener(e -> {
            try {
                Category cat = (Category) catBox.getSelectedItem();
                double limit = Double.parseDouble(limitField.getText());
                if (limit <= 0) throw new Exception();
                controller.setExpenseLimit(cat, limit);
                JOptionPane.showMessageDialog(this, "Limit set for " + cat);
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid input!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        cancelBtn.addActionListener(e -> dispose());
        setVisible(true);
    }
}
