import java.util.ArrayList;
import java.util.List;

public class Cluster {

    private double centroidIncome;
    private double centroidSpending;

    private List<Customer> customers;

    public Cluster(double centroidIncome,
                   double centroidSpending) {

        this.centroidIncome = centroidIncome;
        this.centroidSpending = centroidSpending;

        customers = new ArrayList<>();
    }

    public void clearCustomers() {
        customers.clear();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public double getCentroidIncome() {
        return centroidIncome;
    }

    public double getCentroidSpending() {
        return centroidSpending;
    }

    public void updateCentroid() {

        if(customers.isEmpty()) {
            return;
        }

        double totalIncome = 0;
        double totalSpending = 0;

        for(Customer customer : customers) {

            totalIncome += customer.getAnnualIncome();
            totalSpending += customer.getSpendingScore();
        }

        centroidIncome = totalIncome / customers.size();
        centroidSpending = totalSpending / customers.size();
    }
}