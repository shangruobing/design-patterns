package command;

/**
 * @author Ruobing Shang 2022-10-07 19:48
 */
public class CookCommand implements Command {
    private final Order order;
    private final Chef chef;

    public CookCommand(Order order) {
        this.order = order;
        this.chef = new Chef();
    }

    @Override
    public void execute() {
        for (String item : order.getOrder()) {
            chef.cooking(item);
        }
    }
}
