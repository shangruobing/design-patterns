package visitor;

/**
 * @author Ruobing Shang 2022-10-14 20:29
 */
public class Park implements Building {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
