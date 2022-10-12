package state;

/**
 * @author Ruobing Shang 2022-10-12 8:30
 */
public abstract class State {
    protected Order order;

    public State(Order order) {
        this.order = order;
    }

    public abstract void payment();

    public abstract void outbound();
}
