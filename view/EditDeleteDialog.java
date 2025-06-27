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

        JTabbedPane tabbedPane = new JTabbedPane();

        // Income Tab
        JPanel incomePanel = new JPanel(new BorderLayout());
        String[] incomeCols = {"ID", "Amount", "Source", "Date"};
        DefaultTableModel incomeModel = new DefaultTableModel(incomeCols, 0);
        JTable incomeTable = new JTable(incomeModel);
        incomePanel.add(new JScrollPane(incomeTable), BorderLayout.CENTER);
        JButton delIncomeBtn = new JButton("Delete Selected");
        delIncomeBtn.addActionListener(e -> {
            int row = incomeTable.getSelectedRow();
            if (row >= 0) {
                int id = (int) incomeModel.getValueAt(row, 0);
                controller.removeIncome(id);
                incomeModel.removeRow(row);
            }
        });
        incomePanel.add(delIncomeBtn, BorderLayout.SOUTH);

        // Expense Tab
        JPanel expensePanel = new JPanel(new BorderLayout());
        String[] expenseCols = {"ID", "Amount", "Category", "Date"};
        DefaultTableModel expenseModel = new DefaultTableModel(expenseCols, 0);
        JTable expenseTable = new JTable(expenseModel);
        expensePanel.add(new JScrollPane(expenseTable), BorderLayout.CENTER);
        JButton delExpenseBtn = new JButton("Delete Selected");
        delExpenseBtn.addActionListener(e -> {
            int row = expenseTable.getSelectedRow();
            if (row >= 0) {
                int id = (int) expenseModel.getValueAt(row, 0);
                controller.removeExpense(id);
                expenseModel.removeRow(row);
            }
        });
        expensePanel.add(delExpenseBtn, BorderLayout.SOUTH);

        tabbedPane.addTab("Income", incomePanel);
        tabbedPane.addTab("Expense", expensePanel);

        add(tabbedPane, BorderLayout.CENTER);
        JButton closeBtn = new JButton("Close");
        closeBtn.addActionListener(e -> dispose());
        add(closeBtn, BorderLayout.SOUTH);

        // Method to reload data
        Runnable reloadTables = () -> {
            incomeModel.setRowCount(0);
            for (Income i : controller.getIncomes()) {
                incomeModel.addRow(new Object[]{i.getId(), i.getAmount(), i.getSource(), i.getDate()});
            }
            expenseModel.setRowCount(0);
            for (Expense ex : controller.getExpenses()) {
                expenseModel.addRow(new Object[]{ex.getId(), ex.getAmount(), ex.getCategory(), ex.getDate()});
            }
        };

        // Reload data every time dialog is shown
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent e) {
                reloadTables.run();
            }
        });
        reloadTables.run();

        setVisible(true);
    }
}
