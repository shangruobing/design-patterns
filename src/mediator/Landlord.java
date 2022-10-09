package mediator;

/**
 * @author Ruobing Shang 2022-10-09 15:00
 */
public class Landlord extends Person {

    public Landlord(String name) {
        super(name);
    }

    @Override
    protected void send(String message) {
        System.out.println(name + " send: " + message);
        mediator.notify(this, message);
    }

    @Override
    protected void receive(String message) {
        System.out.println(name + " receive: " + message);
    }
}
