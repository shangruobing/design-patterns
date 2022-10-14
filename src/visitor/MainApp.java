package visitor;

/**
 * @author Ruobing Shang 2022-10-14 20:31
 */
public class MainApp {
    public static void main(String[] args) {
        Building[] buildings = new Building[]{new Park(), new Bank(), new University()};
        BuildingVisitor buildingVisitor = new BuildingVisitor();
        for (Building building : buildings) {
            building.accept(buildingVisitor);
        }
    }
}
