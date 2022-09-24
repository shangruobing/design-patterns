package factorymethod;

/**
 * @author Ruobing Shang 2022-09-24 21:07
 */
public class ClassicMusic implements Music {

    @Override
    public void play() {
        System.out.println("Classical music is playing.");
    }
}
