package state;

/**
 * @author Ruobing Shang 2022-10-12 8:42
 */
public class InitialStatus extends State {

    public InitialStatus(Order order) {
        super(order);
    }

    @Override
    public void payment() {
        order.setState(new PaymentState(order));
        System.out.println("Successful payment");
    }

    @Override
    public void outbound() {
        System.out.println("Failure outbound");
    }
}
