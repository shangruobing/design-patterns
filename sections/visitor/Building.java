package visitor;

/**
 * @author Ruobing Shang 2022-10-14 20:29
 */
public interface Building {
    void accept(Visitor visitor);
}
