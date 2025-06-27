package controller;

import model.*;
import java.util.*;
import java.util.stream.Collectors;

public class BudgetController {
    private List<Income> incomes = new ArrayList<>();
    private List<Expense> expenses = new ArrayList<>();
    private ExpenseLimit expenseLimit = new ExpenseLimit();

    public void addIncome(Income income) { incomes.add(income); }
    public void addExpense(Expense expense) { expenses.add(expense); }
    public void removeIncome(int id) { incomes.removeIf(i -> i.getId() == id); }
    public void removeExpense(int id) { expenses.removeIf(e -> e.getId() == id); }

    public List<Income> getIncomes() { return incomes; }
    public List<Expense> getExpenses() { return expenses; }

    public double getTotalIncome() {
        return incomes.stream().mapToDouble(Income::getAmount).sum();
    }

    public double getTotalExpense() {
        return expenses.stream().mapToDouble(Expense::getAmount).sum();
    }

    public double getBalance() {
        return getTotalIncome() - getTotalExpense();
    }

    public Map<Category, Double> getCategoryWiseExpense() {
        Map<Category, Double> map = new HashMap<>();
        for (Expense e : expenses) {
            map.put(e.getCategory(), map.getOrDefault(e.getCategory(), 0.0) + e.getAmount());
        }
        return map;
    }

    public void setExpenseLimit(Category category, double limit) {
        expenseLimit.setLimit(category, limit);
    }

    public double getExpenseLimit(Category category) {
        return expenseLimit.getLimit(category);
    }

    public boolean isLimitExceeded(Category category) {
        double total = getCategoryWiseExpense().getOrDefault(category, 0.0);
        return expenseLimit.isExceeded(category, total);
    }

    public void resetData() {
        incomes.clear();
        expenses.clear();
    }

    public String getSessionSummary() {
        double totalIncome = getTotalIncome();
        double totalExpense = getTotalExpense();
        double balance = getBalance();
        Map<Category, Double> catMap = getCategoryWiseExpense();
        Category highestCat = null;
        double max = 0;
        for (Map.Entry<Category, Double> entry : catMap.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                highestCat = entry.getKey();
            }
        }
        return String.format(
            "Session Summary:\nTotal Income: %.2f\nTotal Expense: %.2f\nBalance: %.2f\nHighest Expense Category: %s (%.2f)",
            totalIncome, totalExpense, balance,
            highestCat != null ? highestCat : "N/A", max
        );
    }

    public List<Expense> getSortedExpenses(Comparator<Expense> comparator) {
        return expenses.stream().sorted(comparator).collect(Collectors.toList());
    }

    public List<Income> getSortedIncomes(Comparator<Income> comparator) {
        return incomes.stream().sorted(comparator).collect(Collectors.toList());
    }
}
