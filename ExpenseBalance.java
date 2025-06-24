public class ExpenseBalance {

    private String amount;
    private String date;
    private String category;

    public ExpenseBalance(String amount, String date, String category) {
        this.amount = amount;
        this.date = date;
        this.category = category;
    }

    public String getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "ExpenseBalance{" +
                "amount='" + amount + '\'' +
                ", date='" + date + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
