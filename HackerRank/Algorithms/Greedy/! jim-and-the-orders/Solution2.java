import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {
    static class Order implements Comparable<Order>{
        public int customerID;
        public int orderNo;
        public int prepTime;

        public Order(int customerID, int orderNo, int prepTime) {
            this.customerID = customerID;
            this.orderNo = orderNo;
            this.prepTime = prepTime;
        }

        public int computeTotal() {
            return this.orderNo + this.prepTime;
        }

        public int compareTo(Order other) {
            if (this.computeTotal() == other.computeTotal()) {
                return this.customerID - other.customerID;
            }

            return this.computeTotal() - other.computeTotal();
        }
    }

    /*
     * Complete the 'jimOrders' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts 2D_INTEGER_ARRAY orders as parameter.
     */

    public static List<Integer> jimOrders(List<List<Integer>> orders) {
        ArrayList<Order> sortedOrders = new ArrayList<>();
        ArrayList<Integer> servingOrder = new ArrayList<>();

        for (int i = 0; i < orders.size(); i++) {
            sortedOrders.add(new Order(i + 1, orders.get(i).get(0), orders.get(i).get(1)));
        }

        Collections.sort(sortedOrders);

        for (Order order : sortedOrders) {
            servingOrder.add(order.customerID);
        }

        return servingOrder;
    }

}

// https://www.hackerrank.com/challenges/jim-and-the-orders/problem
public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> orders = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] ordersRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> ordersRowItems = new ArrayList<>();

            for (int j = 0; j < 2; j++) {
                int ordersItem = Integer.parseInt(ordersRowTempItems[j]);
                ordersRowItems.add(ordersItem);
            }

            orders.add(ordersRowItems);
        }

        List<Integer> result = Result.jimOrders(orders);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
