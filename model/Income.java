package model;

import java.util.Date;

public class Income {
    private static int counter = 1;
    private int id;
    private double amount;
    private String source;
    private Date date;

    public Income(double amount, String source, Date date) {
        this.id = counter++;
        this.amount = amount;
        this.source = source;
        this.date = date;
    }

    public int getId() { return id; }
    public double getAmount() { return amount; }
    public String getSource() { return source; }
    public Date getDate() { return date; }

    public void setAmount(double amount) { this.amount = amount; }
    public void setSource(String source) { this.source = source; }
    public void setDate(Date date) { this.date = date; }
}
