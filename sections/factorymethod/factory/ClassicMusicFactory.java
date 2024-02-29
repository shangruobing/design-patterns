package factorymethod.factory;

import factorymethod.product.ClassicMusic;
import factorymethod.product.Music;

/**
 * @author Ruobing Shang 2022-09-24 21:16
 */
public class ClassicMusicFactory extends AbstractMusicFactory {

    @Override
    public Music createMusic() {
        return new ClassicMusic();
    }
}
