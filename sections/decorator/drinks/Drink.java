package decorator.drinks;

/**
 * @author Ruobing Shang 2022-10-02 15:06
 */
public abstract class Drink {
    private String name;
    private float price;
    public abstract float calculatePrice();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
