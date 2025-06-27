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

 
    }
}
