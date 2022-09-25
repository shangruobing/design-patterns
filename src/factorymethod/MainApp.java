package factorymethod;

import factorymethod.factory.ClassicMusicFactory;
import factorymethod.factory.PopMusicFactory;

/**
 * @author Ruobing Shang 2022-09-24 21:18
 */
public class MainApp {
    public static void main(String[] args) {
        ClassicMusicFactory classicMusicFactory = new ClassicMusicFactory();
        classicMusicFactory.createMusic().play();
        PopMusicFactory popMusicFactory = new PopMusicFactory();
        popMusicFactory.createMusic().play();
    }
}
