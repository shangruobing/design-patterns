package decorator;

import decorator.decorators.Milk;
import decorator.decorators.Sugar;
import decorator.drinks.Americano;
import decorator.drinks.Drink;

/**
 * @author Ruobing Shang 2022-10-02 15:15
 */
public class MainApp {
    public static void main(String[] args) {
        Drink americano = new Americano();
        System.out.println(americano.getName() + "=" + americano.calculatePrice());
        americano = new Milk(americano);
        System.out.println(americano.getName() + "=" + americano.calculatePrice());
        americano = new Sugar(americano);
        System.out.println(americano.getName() + "=" + americano.calculatePrice());
    }
}
