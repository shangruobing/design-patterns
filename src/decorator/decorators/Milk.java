package decorator.decorators;

import decorator.drinks.Drink;

/**
 * @author Ruobing Shang 2022-10-02 15:14
 */
public class Milk extends Decorator {
    public Milk(Drink drink) {
        super(drink);
        setName("Milk");
        setPrice(2);
    }
}
