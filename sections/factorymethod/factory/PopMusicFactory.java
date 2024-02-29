package factorymethod.factory;

import factorymethod.product.Music;
import factorymethod.product.PopMusic;

/**
 * @author Ruobing Shang 2022-09-24 21:17
 */
public class PopMusicFactory extends AbstractMusicFactory {

    @Override
    public Music createMusic() {
        return new PopMusic();
    }
}
