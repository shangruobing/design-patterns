package facade.device;

/**
 * @author Ruobing Shang 2022-10-03 14:58
 */
public class EggSteamer implements Device {
    @Override
    public void run() {
        System.out.println("The EggSteamer is steaming eggs.");
    }
}
