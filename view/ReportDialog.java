package view;

import controller.BudgetController;
import model.Category;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class ReportDialog extends JDialog {
    public ReportDialog(JFrame parent, BudgetController controller) {
        super(parent, "Category-wise Expense Report", true);
        setLayout(new BorderLayout());
        setSize(350, 250);
        setLocationRelativeTo(parent);

        JTextArea reportArea = new JTextArea();
        reportArea.setEditable(false);

        StringBuilder sb = new StringBuilder();
        Map<Category, Double> map = controller.getCategoryWiseExpense();
        for (Category cat : Category.values()) {
            sb.append(cat).append(": ").append(map.getOrDefault(cat, 0.0)).append("\n");
        }
        reportArea.setText(sb.toString());

        add(new JScrollPane(reportArea), BorderLayout.CENTER);
        JButton closeBtn = new JButton("Close");
        closeBtn.addActionListener(e -> dispose());
        add(closeBtn, BorderLayout.SOUTH);

        setVisible(true);
    }
}
