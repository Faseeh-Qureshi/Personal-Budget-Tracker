package view;

import controller.BudgetController;
import model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Comparator;
import java.util.List;

public class SortDialog extends JDialog {
    public SortDialog(JFrame parent, BudgetController controller) {
        super(parent, "Sort Records", true);
        setLayout(new BorderLayout());
        setSize(600, 400);
        setLocationRelativeTo(parent);

 
    }
}
