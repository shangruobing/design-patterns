package facade.device;

/**
 * @author Ruobing Shang 2022-10-03 14:57
 */
public class CofferMaker implements Device {
    @Override
    public void run() {
        System.out.println("The CofferMaker is making coffer.");
    }
}
