package command;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruobing Shang 2022-10-07 19:44
 */
public class Order {
    private final List<String> order = new ArrayList<>();

    public Order addItem(String item) {
        order.add(item);
        return this;
    }

    public List<String> getOrder() {
        return order;
    }
}
