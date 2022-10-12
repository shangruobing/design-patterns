package state;

/**
 * @author Ruobing Shang 2022-10-12 8:39
 */
public class MainApp {
    public static void main(String[] args) {
        Order order = new Order();
        order.setState(new InitialStatus(order));
        // failure: Payment is required in advance
        order.outbound();
        // ok
        order.payment();
        // ok
        order.outbound();
        // failure: has already outbound
        order.outbound();
    }
}
