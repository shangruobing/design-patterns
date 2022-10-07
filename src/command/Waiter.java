package command;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruobing Shang 2022-10-07 19:43
 */
public class Waiter {
    private final List<Order> orders = new ArrayList<>();

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void processOrders() {
        for (Order order : orders) {
            System.out.println("Order processing begins");
            new CookCommand(order).execute();
            System.out.println("Order processing finished");
        }
    }
}
