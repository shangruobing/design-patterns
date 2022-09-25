package abstractfactory.factory;

import abstractfactory.product.Fridge;
import abstractfactory.product.Television;

/**
 * @author Ruobing Shang 2022-09-25 14:49
 */
public abstract class AbstractFactory {
    /**
     * Create a television.
     *
     * @return A television instance.
     */
    public abstract Television createTelevision();

    /**
     * Create a fridge.
     *
     * @return A fridge instance.
     */
    public abstract Fridge createFridge();
}
