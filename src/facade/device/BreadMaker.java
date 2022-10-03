package facade.device;

/**
 * @author Ruobing Shang 2022-10-03 14:54
 */
public class BreadMaker implements Device {
    @Override
    public void run() {
        System.out.println("The BreadMaker is making bread.");
    }
}
