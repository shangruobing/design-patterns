package prototype;

import java.util.ArrayList;

/**
 * @author Ruobing Shang 2022-09-27 8:53
 */
public class ShapeGroup {
    private final ArrayList<AbstractShape> shapes = new ArrayList<>();

    public ShapeGroup() {
        Circle circle = new Circle();
        circle.setX(10);
        circle.setY(10);
        circle.setRadius(20);
        shapes.add(circle);

        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(10);
        rectangle.setHeight(20);
        shapes.add(rectangle);
    }

    public ArrayList<AbstractShape> getShapes() {
        return shapes;
    }
}
