package mediator;

/**
 * @author Ruobing Shang 2022-10-09 14:56
 */
public class Tenant extends Person {

    public Tenant(String name) {
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