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

        JTabbedPane tabbedPane = new JTabbedPane();

        // Income Tab
        JPanel incomePanel = new JPanel(new BorderLayout());
        String[] incomeCols = {"ID", "Amount", "Source", "Date"};
        DefaultTableModel incomeModel = new DefaultTableModel(incomeCols, 0);
        JComboBox<String> incomeSortBox = new JComboBox<>(new String[]{"Date", "Amount"});
        JButton sortIncomeBtn = new JButton("Sort");
        JTable incomeTable = new JTable(incomeModel);
        incomePanel.add(new JScrollPane(incomeTable), BorderLayout.CENTER);
        JPanel topIncomePanel = new JPanel();
        topIncomePanel.add(new JLabel("Sort by:"));
        topIncomePanel.add(incomeSortBox);
        topIncomePanel.add(sortIncomeBtn);
        incomePanel.add(topIncomePanel, BorderLayout.NORTH);

        sortIncomeBtn.addActionListener(e -> {
            incomeModel.setRowCount(0);
            List<Income> sorted;
            if (incomeSortBox.getSelectedItem().equals("Date")) {
                sorted = controller.getSortedIncomes(Comparator.comparing(Income::getDate));
            } else {
                sorted = controller.getSortedIncomes(Comparator.comparing(Income::getAmount));
            }
            for (Income i : sorted) {
                incomeModel.addRow(new Object[]{i.getId(), i.getAmount(), i.getSource(), i.getDate()});
            }
        });

        // Expense Tab
        JPanel expensePanel = new JPanel(new BorderLayout());
        String[] expenseCols = {"ID", "Amount", "Category", "Date"};
        DefaultTableModel expenseModel = new DefaultTableModel(expenseCols, 0);
        JComboBox<String> expenseSortBox = new JComboBox<>(new String[]{"Date", "Amount"});
        JButton sortExpenseBtn = new JButton("Sort");
        JTable expenseTable = new JTable(expenseModel);
        expensePanel.add(new JScrollPane(expenseTable), BorderLayout.CENTER);
        JPanel topExpensePanel = new JPanel();
        topExpensePanel.add(new JLabel("Sort by:"));
        topExpensePanel.add(expenseSortBox);
        topExpensePanel.add(sortExpenseBtn);
        expensePanel.add(topExpensePanel, BorderLayout.NORTH);

        sortExpenseBtn.addActionListener(e -> {
            expenseModel.setRowCount(0);
            List<Expense> sorted;
            if (expenseSortBox.getSelectedItem().equals("Date")) {
                sorted = controller.getSortedExpenses(Comparator.comparing(Expense::getDate));
            } else {
                sorted = controller.getSortedExpenses(Comparator.comparing(Expense::getAmount));
            }
            for (Expense ex : sorted) {
                expenseModel.addRow(new Object[]{ex.getId(), ex.getAmount(), ex.getCategory(), ex.getDate()});
            }
        });

        tabbedPane.addTab("Income", incomePanel);
        tabbedPane.addTab("Expense", expensePanel);

        add(tabbedPane, BorderLayout.CENTER);
        JButton closeBtn = new JButton("Close");
        closeBtn.addActionListener(e -> dispose());
        add(closeBtn, BorderLayout.SOUTH);

        setVisible(true);
    }
}
