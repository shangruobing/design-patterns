package abstractfactory.product;

/**
 * @author Ruobing Shang 2022-09-25 14:36
 */
public class HisenseTelevision implements Television{

    @Override
    public void play() {
        System.out.println("Hisense TV is playing.");
    }
}
