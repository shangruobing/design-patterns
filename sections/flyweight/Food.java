package flyweight;

/**
 * @author Ruobing Shang 2022-10-04 16:34
 */
public class Food {
    private final String name;

    public Food(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + "@" + Integer.toHexString(hashCode());
    }
}
