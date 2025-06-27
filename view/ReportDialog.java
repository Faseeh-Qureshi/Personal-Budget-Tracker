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

}
}
