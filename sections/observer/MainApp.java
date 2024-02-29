package observer;

/**
 * @author Ruobing Shang 2022-10-11 9:19
 */
public class MainApp {
    public static void main(String[] args) {
        AppStore appStore = new AppStore();
        Customer customerA = new Customer("Customer A");
        Customer customerB = new Customer("Customer B");
        Customer customerC = new Customer("Customer C");
        appStore.subscribe(customerA);
        appStore.subscribe(customerB);
        appStore.subscribe(customerC);
        appStore.publish("Appstore published the first message.");
        appStore.unsubscribe(customerC);
        appStore.publish("Appstore published the second message.");
    }
}
