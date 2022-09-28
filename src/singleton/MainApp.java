package singleton;

/**
 * @author Ruobing Shang 2022-09-28 21:54
 */
public class MainApp {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance("instance No.1");
        System.out.println(instance);
        System.out.println(instance.getValue());

        // The obtained instance is still instance No.1, and they have the same memory address.
        instance = Singleton.getInstance("instance No.2");
        System.out.println(instance);
        System.out.println(instance.getValue());
    }
}
