package strategy;

/**
 * @author Ruobing Shang 2022-10-13 15:21
 */
public class MainApp {
    public static void main(String[] args) {
        Context context = new Context();
        context.setStrategy(new Bike());
        context.executeStrategy();
        context.setStrategy(new Bus());
        context.executeStrategy();
        context.setStrategy(new Car());
        context.executeStrategy();
    }
}
