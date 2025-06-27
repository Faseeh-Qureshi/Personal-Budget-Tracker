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


    }
}
