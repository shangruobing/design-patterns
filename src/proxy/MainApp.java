package proxy;

/**
 * @author Ruobing Shang 2022-10-05 14:37
 */
public class MainApp {
    public static void main(String[] args) {
        CreditCard creditCard = new CreditCard(new Cash());
        creditCard.pay(30);
        System.out.println(creditCard);
        creditCard.setAccess(false);
        // Error! This CreditCard is not available.
        creditCard.pay(10);
    }
}
