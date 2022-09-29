package adapter;

/**
 * @author Ruobing Shang 2022-09-29 15:19
 */
public class ChinaStandard {
    private final static int VOLTAGE = 220;

    public static void charge(Device device) {
        if (VOLTAGE >= device.getVoltage()) {
            System.out.println("charging...");
        } else {
            System.out.println(VOLTAGE + "V and " + device.getVoltage() + "V are incompatible!");
        }
    }
}
