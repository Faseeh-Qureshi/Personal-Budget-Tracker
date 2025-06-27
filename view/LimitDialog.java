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


    }
}
