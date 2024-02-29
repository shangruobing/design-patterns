package decorator.decorators;

import decorator.drinks.Drink;

/**
 * @author Ruobing Shang 2022-10-02 15:12
 */
public class Decorator extends Drink {
    private final Drink drink;

    public Decorator(Drink drink) {
        this.drink = drink;
    }

    @Override
    public float calculatePrice() {
        return super.getPrice() + drink.calculatePrice();
    }

    @Override
    public String getName() {
        return super.getName() + "+" + drink.getName();
    }
}
