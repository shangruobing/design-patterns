package visitor;

/**
 * @author Ruobing Shang 2022-10-14 20:28
 */
public interface Visitor {
    void visit(Park park);

    void visit(Bank bank);

    void visit(University university);
}
