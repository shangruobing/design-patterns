package adapter;

/**
 * @author Ruobing Shang 2022-09-29 15:29
 */
public class MainApp {
    public static void main(String[] args) {
        Device device = new Device();
        ChinaStandard.charge(device);
        AmericanStandard.charge(device);

        VoltageAdapter adapter = new VoltageAdapter(device);
        ChinaStandard.charge(adapter);
        AmericanStandard.charge(adapter);
    }
}
