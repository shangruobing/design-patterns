package factorymethod;

/**
 * @author Ruobing Shang 2022-09-24 21:16
 */
public class ClassicMusicFactory extends BaseMusicFactory {

    @Override
    public Music createMusic() {
        return new ClassicMusic();
    }
}
