package abstractfactory.product;

/**
 * @author Ruobing Shang 2022-09-25 14:33
 */
public class HisenseFridge implements Fridge {

    @Override
    public void freeze() {
        System.out.println("Hisense Fridge is freezing.");
    }
}
