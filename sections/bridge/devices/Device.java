package bridge.devices;

/**
 * @author Ruobing Shang 2022-09-30 17:26
 */
public interface Device {
    boolean isEnabled();

    void enable();

    void disable();

    int getVolume();

    void setVolume(int volume);
}
