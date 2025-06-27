package view;

import controller.BudgetController;
import model.*;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private BudgetController controller;

    public MainFrame(BudgetController controller) {
        this.controller = controller;
        setTitle("Personal Budget Tracker");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(0, 1, 10, 10));

        JButton addIncomeBtn = new JButton("Add Income");
        JButton addExpenseBtn = new JButton("Add Expense");
        JButton viewBalanceBtn = new JButton("View Balance");
        JButton viewReportBtn = new JButton("View Category-wise Report");
        JButton setLimitBtn = new JButton("Set Expense Limit");
        JButton editDeleteBtn = new JButton("Edit/Delete Records");
        JButton sortBtn = new JButton("Sort Records");
        JButton resetBtn = new JButton("Reset Data");
        JButton summaryBtn = new JButton("Session Summary");
        JButton exitBtn = new JButton("Exit");

        add(addIncomeBtn);
        add(addExpenseBtn);
        add(viewBalanceBtn);
        add(viewReportBtn);
        add(setLimitBtn);
        add(editDeleteBtn);
        add(sortBtn);
        add(resetBtn);
        add(summaryBtn);
        add(exitBtn);

        addIncomeBtn.addActionListener(e -> new IncomeDialog(this, controller));
        addExpenseBtn.addActionListener(e -> new ExpenseDialog(this, controller));
        viewBalanceBtn.addActionListener(e -> JOptionPane.showMessageDialog(this,
            "Current Balance: " + controller.getBalance(),
            "Balance", JOptionPane.INFORMATION_MESSAGE));
        viewReportBtn.addActionListener(e -> new ReportDialog(this, controller));
        setLimitBtn.addActionListener(e -> new LimitDialog(this, controller));
        editDeleteBtn.addActionListener(e -> new EditDeleteDialog(this, controller));
        sortBtn.addActionListener(e -> new SortDialog(this, controller));
        resetBtn.addActionListener(e -> {
            int res = JOptionPane.showConfirmDialog(this, "Are you sure to reset all data?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (res == JOptionPane.YES_OPTION) controller.resetData();
        });
        summaryBtn.addActionListener(e -> JOptionPane.showMessageDialog(this,
            controller.getSessionSummary(), "Session Summary", JOptionPane.INFORMATION_MESSAGE));
        exitBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, controller.getSessionSummary(), "Session Summary", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        });

        setVisible(true);
    }
}
