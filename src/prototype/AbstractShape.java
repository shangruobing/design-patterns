package prototype;

/**
 * @author Ruobing Shang 2022-09-27 8:06
 */
public abstract class AbstractShape {
    private int x;
    private int y;

    public AbstractShape() {
    }

    public AbstractShape(AbstractShape source) {
        this.x = source.x;
        this.y = source.y;
    }

    /**
     * clone a calling object.
     *
     * @return cloned object.
     */
    @Override
    public abstract AbstractShape clone();

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

}
