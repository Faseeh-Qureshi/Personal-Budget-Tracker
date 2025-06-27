package model;

import java.util.HashMap;
import java.util.Map;

public class ExpenseLimit {
    private Map<Category, Double> limits = new HashMap<>();

    public void setLimit(Category category, double limit) {
        limits.put(category, limit);
    }

    public double getLimit(Category category) {
        return limits.getOrDefault(category, Double.MAX_VALUE);
    }

    public boolean isExceeded(Category category, double currentTotal) {
        return currentTotal >= getLimit(category);
    }
}
