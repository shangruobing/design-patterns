package abstractfactory.product;

/**
 * @author Ruobing Shang 2022-09-25 14:33
 */
public class HaierTelevision implements Television {

    @Override
    public void play() {
        System.out.println("Haier TV is playing.");
    }
}
