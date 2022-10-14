package visitor;

/**
 * @author Ruobing Shang 2022-10-14 20:41
 */
public class Bank implements Building {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
