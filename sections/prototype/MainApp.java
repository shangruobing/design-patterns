package prototype;

import java.util.ArrayList;

/**
 * @author Ruobing Shang 2022-09-27 8:14
 */
public class MainApp {

    public static void main(String[] args) {
        ShapeGroup shapeGroup = new ShapeGroup();
        ArrayList<AbstractShape> shapes = shapeGroup.getShapes();
        ArrayList<AbstractShape> shapesCopy = new ArrayList<>();

        for (AbstractShape shape : shapes) {
            shapesCopy.add(shape.clone());
        }
        shapes.forEach(System.out::println);
        shapesCopy.forEach(System.out::println);
    }
}
