package visitor;

/**
 * @author Ruobing Shang 2022-10-14 20:31
 */
public class BuildingVisitor implements Visitor {
    @Override
    public void visit(Park park) {
        System.out.println("The visitors visited the park.");
    }

    @Override
    public void visit(Bank bank) {
        System.out.println("The visitors visited the bank.");
    }

    @Override
    public void visit(University university) {
        System.out.println("The visitors visited the university.");
    }
}
