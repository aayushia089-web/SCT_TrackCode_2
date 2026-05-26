import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class KMeans {

    private int k;
    private List<Cluster> clusters;

    public KMeans(int k) {

        this.k = k;
        clusters = new ArrayList<>();
    }

    public void fit(List<Customer> customers) {

        initializeClusters(customers);

        for(int iteration = 0; iteration < 100; iteration++) {

            for(Cluster cluster : clusters) {
                cluster.clearCustomers();
            }

            for(Customer customer : customers) {

                Cluster nearestCluster =
                        findNearestCluster(customer);

                nearestCluster.addCustomer(customer);
            }

            for(Cluster cluster : clusters) {
                cluster.updateCentroid();
            }
        }
    }

    private void initializeClusters(List<Customer> customers) {

        Random random = new Random();

        for(int i = 0; i < k; i++) {

            Customer customer =
                    customers.get(
                            random.nextInt(customers.size())
                    );

            clusters.add(new Cluster(
                    customer.getAnnualIncome(),
                    customer.getSpendingScore()
            ));
        }
    }

    private Cluster findNearestCluster(Customer customer) {

        Cluster nearestCluster = null;

        double minDistance = Double.MAX_VALUE;

        for(Cluster cluster : clusters) {

            double distance = calculateDistance(
                    customer.getAnnualIncome(),
                    customer.getSpendingScore(),
                    cluster.getCentroidIncome(),
                    cluster.getCentroidSpending()
            );

            if(distance < minDistance) {

                minDistance = distance;
                nearestCluster = cluster;
            }
        }

        return nearestCluster;
    }

    private double calculateDistance(
            double x1,
            double y1,
            double x2,
            double y2) {

        return Math.sqrt(
                Math.pow(x1 - x2, 2)
                        +
                        Math.pow(y1 - y2, 2)
        );
    }

    public void printClusters() {

        int clusterNumber = 1;

        for(Cluster cluster : clusters) {

            System.out.println(
                    "\n========== Cluster "
                            + clusterNumber +
                            " =========="
            );

            for(Customer customer :
                    cluster.getCustomers()) {

                System.out.println(
                        "Customer ID: "
                                + customer.getCustomerId()
                                + " | Income: "
                                + customer.getAnnualIncome()
                                + " | Spending Score: "
                                + customer.getSpendingScore()
                );
            }

            clusterNumber++;
        }
    }
}
