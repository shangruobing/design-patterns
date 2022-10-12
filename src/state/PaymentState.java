package state;

/**
 * @author Ruobing Shang 2022-10-12 8:36
 */
public class PaymentState extends State {
    public PaymentState(Order order) {
        super(order);
    }

    @Override
    public void payment() {
        System.out.println("Has already payment");
    }

    @Override
    public void outbound() {
        order.setState(new OutBoundState(order));
        System.out.println("Successful outbound");
    }
}
