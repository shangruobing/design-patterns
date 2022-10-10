package memonto;

/**
 * @author Ruobing Shang 2022-10-10 9:59
 */
public class Database implements Originator {
    private int state;

    @Override
    public Memento save() {
        return new DatabaseMemento(this, state);
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getState() {
        return state;
    }

    @Override
    public String toString() {
        return "Database{" +
                "state=" + state +
                '}';
    }
}
