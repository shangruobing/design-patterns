package singleton;

/**
 * @author Ruobing Shang 2022-09-28 21:47
 */
public final class Singleton {
    /**
     * The field must be declared volatile
     * so that double check lock would work correctly.
     */
    private static volatile Singleton instance;
    private final String value;

    private Singleton(String value) {
        this.value = value;
    }

    /**
     * double-checked locking (DCL)
     * threads safe
     */
    public static Singleton getInstance(String value) {
        if (instance != null) {
            return instance;
        }
        synchronized (Singleton.class) {
            if (instance == null) {
                instance = new Singleton(value);
            }
            return instance;
        }
    }

    public String getValue() {
        return value;
    }
}
