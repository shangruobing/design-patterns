package decorator.decorators;

import decorator.drinks.Drink;

/**
 * @author Ruobing Shang 2022-10-02 15:14
 */
public class Sugar extends Decorator {
    public Sugar(Drink drink) {
        super(drink);
        setName("Sugar");
        setPrice(1);
    }
}
