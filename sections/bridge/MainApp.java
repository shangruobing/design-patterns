package bridge;

import bridge.devices.Television;
import bridge.remotes.AdvancedRemote;
import bridge.remotes.BasicRemote;

/**
 * @author Ruobing Shang 2022-09-30 17:35
 */
public class MainApp {
    public static void main(String[] args) {
        Television tv=new Television();
        System.out.println(tv.getVolume());

        BasicRemote basicRemote=new BasicRemote(tv);
        basicRemote.volumeDown();
        System.out.println(tv.getVolume());

        AdvancedRemote advancedRemote=new AdvancedRemote(tv);
        advancedRemote.mute();
        System.out.println(tv.getVolume());
    }
}
