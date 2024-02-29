package factorymethod.product;

/**
 * @author Ruobing Shang 2022-09-24 21:07
 */
public class PopMusic implements Music {

    @Override
    public void play() {
        System.out.println("Pop music is playing.");
    }
}
