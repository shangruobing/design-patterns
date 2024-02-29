package visitor;

/**
 * @author Ruobing Shang 2022-10-14 20:42
 */
public class University implements Building {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
