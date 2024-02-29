package composite;

/**
 * @author Ruobing Shang 2022-10-01 14:45
 */
public class MainApp {
    public static void main(String[] args) {
        SubMenu subMenu = new SubMenu("SubMenu A");
        subMenu.add(new MenuItem("MenuItem A"));
        subMenu.add(new MenuItem("MenuItem B"));
        subMenu.add(new MenuItem("MenuItem C"));

        Menu menu = new Menu("Menu A");
        menu.add(subMenu);
        menu.operation();
    }
}
