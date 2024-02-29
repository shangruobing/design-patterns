package command;

/**
 * @author Ruobing Shang 2022-10-07 20:00
 */
public class MainApp {
    public static void main(String[] args) {
        Waiter waiter = new Waiter();
        Order order = new Order();
        order.addItem("Steak").addItem("Fruit salad").addItem("Corn soup");
        waiter.addOrder(order);

        order = new Order();
        order.addItem("Pork chops").addItem("Red wine").addItem("Ice cream");
        waiter.addOrder(order);
        waiter.processOrders();
    }
}
