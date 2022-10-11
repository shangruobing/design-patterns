package observer;

/**
 * @author Ruobing Shang 2022-10-11 9:20
 */
public class Customer implements Subscriber {
    private final String name;

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public void update(Object context) {
        System.out.println(name + " receive: " + context);
    }
}
