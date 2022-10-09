package mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruobing Shang 2022-10-09 14:59
 */
public class HouseMediator implements Mediator {
    private final List<Person> users = new ArrayList<>();

    @Override
    public void register(Person person) {
        person.setMediator(this);
        users.add(person);
    }

    @Override
    public void notify(Person person, String message) {
        for (Person user : users) {
            if (!user.equals(person)) {
                user.receive(message);
            }
        }
    }
}
