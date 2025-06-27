package view;

import controller.BudgetController;
import model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class EditDeleteDialog extends JDialog {
    public EditDeleteDialog(JFrame parent, BudgetController controller) {
        super(parent, "Edit/Delete Records", true);
        setLayout(new BorderLayout());
        setSize(600, 400);
        setLocationRelativeTo(parent);


    }
}
