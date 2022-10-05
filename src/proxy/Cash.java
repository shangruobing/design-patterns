package proxy;

/**
 * @author Ruobing Shang 2022-10-05 14:29
 */
public class Cash implements Payment {
    private float amount = 100;

    @Override
    public void pay(float price) {
        amount = amount - price;
    }

    public float getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Cash has " + amount + ".";
    }
}
