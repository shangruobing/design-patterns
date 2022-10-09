package mediator;

/**
 * @author Ruobing Shang 2022-10-09 14:54
 */
public abstract class Person {
    protected String name;
    protected Mediator mediator;

    public Person(String name) {
        this.name = name;
    }

    protected abstract void send(String message);

    protected abstract void receive(String message);

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }
}