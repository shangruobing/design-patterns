package factorymethod.factory;

import factorymethod.product.Music;

/**
 * @author Ruobing Shang 2022-09-24 21:08
 */
public abstract class AbstractMusicFactory {
    /**
     * Create a Music.
     *
     * @return A music instance.
     */
    public abstract Music createMusic();
}
