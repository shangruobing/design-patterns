package abstractfactory;

import abstractfactory.factory.HaierFactory;
import abstractfactory.factory.HisenseFactory;

/**
 * @author Ruobing Shang 2022-09-25 14:56
 */
public class MainApp {
    public static void main(String[] args) {
        HisenseFactory hisenseFactory = new HisenseFactory();
        hisenseFactory.createTelevision().play();
        hisenseFactory.createFridge().freeze();

        HaierFactory haierFactory = new HaierFactory();
        haierFactory.createTelevision().play();
        haierFactory.createFridge().freeze();
    }
}
