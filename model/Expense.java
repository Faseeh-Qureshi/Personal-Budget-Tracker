package model;

import java.util.Date;

public class Expense {
    private static int counter = 1;
    private int id;
    private double amount;
    private Category category;
    private Date date;

    public Expense(double amount, Category category, Date date) {
        this.id = counter++;
        this.amount = amount;
        this.category = category;
        this.date = date;
    }

    public int getId() { return id; }
    public double getAmount() { return amount; }
    public Category getCategory() { return category; }
    public Date getDate() { return date; }

    public void setAmount(double amount) { this.amount = amount; }
    public void setCategory(Category category) { this.category = category; }
    public void setDate(Date date) { this.date = date; }
}
