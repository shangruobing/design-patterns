package state;

/**
 * @author Ruobing Shang 2022-10-12 8:30
 */
public class Order {
    private State state;

    public void setState(State state) {
        this.state = state;
    }

    public void payment() {
        state.payment();
    }

    public void outbound() {
        state.outbound();
    }
}
