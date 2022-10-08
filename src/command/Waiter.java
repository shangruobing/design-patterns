package command;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruobing Shang 2022-10-07 19:43
 */
public class Waiter {
    private final List<CookCommand> cookCommands = new ArrayList<>();

    public void addOrder(Order order) {
        cookCommands.add(new CookCommand(order));
    }

    public void processOrders() {
        for (CookCommand cookCommand:cookCommands) {
            System.out.println("Order processing begins");
            cookCommand.execute();
            System.out.println("Order processing finished");
        }
    }
}
