package factorymethod;

/**
 * @author Ruobing Shang 2022-09-24 21:17
 */
public class PopMusicFactory extends BaseMusicFactory {

    @Override
    public Music createMusic() {
        return new PopMusic();
    }
}
