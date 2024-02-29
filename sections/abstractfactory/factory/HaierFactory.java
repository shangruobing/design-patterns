package abstractfactory.factory;

import abstractfactory.product.*;

/**
 * @author Ruobing Shang 2022-09-25 14:51
 */
public class HaierFactory extends AbstractFactory {
    @Override
    public Television createTelevision() {
        return new HaierTelevision();
    }

    @Override
    public Fridge createFridge() {
        return new HaierFridge();
    }
}
