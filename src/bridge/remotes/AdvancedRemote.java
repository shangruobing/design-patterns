package bridge.remotes;

import bridge.devices.Device;

/**
 * @author Ruobing Shang 2022-09-30 17:38
 */
public class AdvancedRemote extends BasicRemote {
    public AdvancedRemote(Device device) {
        super(device);
    }

    public void mute() {
        device.setVolume(0);
    }
}
