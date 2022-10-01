package composite;

import java.util.List;

/**
 * @author Ruobing Shang 2022-10-01 14:36
 */
public interface Component {
    void add(Component component);

    void remove(Component component);

    List<Component> getChildren();

    void operation();
}
