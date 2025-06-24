public class Income {
    private double salary;
    private String source;

    public Income(double salary, String source) {
        this.salary = salary;
        this.source = source;
    }

    public double calculateIncome() {
        // Implement any logic here to calculate income based on salary and source
        // For now, it just returns the salary
        return salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
  