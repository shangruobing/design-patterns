package decorator.drinks;

/**
 * @author Ruobing Shang 2022-10-02 15:08
 */
public class Coffer extends Drink{
    @Override
    public float calculatePrice() {
        return super.getPrice();
    }
}
