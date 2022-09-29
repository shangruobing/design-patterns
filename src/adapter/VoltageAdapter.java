package adapter;

/**
 * @author Ruobing Shang 2022-09-29 15:32
 */
public class VoltageAdapter extends Device {
    private final Device device;

    public VoltageAdapter(Device device) {
        this.device = device;
    }

    @Override
    public int getVoltage() {
        return this.device.getVoltage() / 2;
    }
}
