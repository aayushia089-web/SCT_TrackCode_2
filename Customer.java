public class Customer {

    private int customerId;
    private double annualIncome;
    private double spendingScore;

    public Customer(int customerId,
                    double annualIncome,
                    double spendingScore) {

        this.customerId = customerId;
        this.annualIncome = annualIncome;
        this.spendingScore = spendingScore;
    }

    public int getCustomerId() {
        return customerId;
    }

    public double getAnnualIncome() {
        return annualIncome;
    }

    public double getSpendingScore() {
        return spendingScore;
    }
}
