import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Customer> customers = new ArrayList<>();

        customers.add(new Customer(1, 15, 39));
        customers.add(new Customer(2, 16, 81));
        customers.add(new Customer(3, 17, 6));
        customers.add(new Customer(4, 18, 77));
        customers.add(new Customer(5, 19, 40));

        customers.add(new Customer(6, 20, 76));
        customers.add(new Customer(7, 21, 6));
        customers.add(new Customer(8, 22, 94));
        customers.add(new Customer(9, 23, 3));
        customers.add(new Customer(10, 24, 72));

        customers.add(new Customer(11, 60, 20));
        customers.add(new Customer(12, 62, 25));
        customers.add(new Customer(13, 65, 30));
        customers.add(new Customer(14, 68, 15));

        customers.add(new Customer(15, 90, 90));
        customers.add(new Customer(16, 88, 95));
        customers.add(new Customer(17, 85, 85));

        KMeans kMeans = new KMeans(4);

        kMeans.fit(customers);

        kMeans.printClusters();

        System.out.println(
                "\nCustomer Segmentation Completed Successfully!"
        );
    }
}
