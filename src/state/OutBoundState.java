package state;

/**
 * @author Ruobing Shang 2022-10-12 8:39
 */
public class OutBoundState extends State {
    public OutBoundState(Order order) {
        super(order);
    }

    @Override
    public void payment() {
        System.out.println("has already payment");
    }

    @Override
    public void outbound() {
        System.out.println("has already outbound");
    }
}
