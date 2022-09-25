package abstractfactory.factory;

import abstractfactory.product.Fridge;
import abstractfactory.product.HisenseFridge;
import abstractfactory.product.HisenseTelevision;
import abstractfactory.product.Television;

/**
 * @author Ruobing Shang 2022-09-25 14:52
 */
public class HisenseFactory extends AbstractFactory {

    @Override
    public Television createTelevision() {
        return new HisenseTelevision();
    }

    @Override
    public Fridge createFridge() {
        return new HisenseFridge();
    }
}
