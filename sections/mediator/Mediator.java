package mediator;

/**
 * @author Ruobing Shang 2022-10-09 14:50
 */
public interface Mediator {
    void register(Person person);

    void notify(Person person, String message);
}
