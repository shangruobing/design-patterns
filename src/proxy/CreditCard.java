package proxy;

/**
 * @author Ruobing Shang 2022-10-05 14:33
 */
public class CreditCard implements Payment {
    private final Cash cash;
    private boolean access = true;

    public CreditCard(Cash cash) {
        this.cash = cash;
    }

    @Override
    public void pay(float price) {
        if (checkAccess()) {
            cash.pay(price);
        } else {
            System.out.println("This CreditCard is not available.");
        }
    }

    private boolean checkAccess() {
        return access;
    }

    public void setAccess(boolean access) {
        this.access = access;
    }

    @Override
    public String toString() {
        return "CreditCard has " + cash.getAmount() + ".";
    }
}
