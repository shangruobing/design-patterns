package strategy;

/**
 * @author Ruobing Shang 2022-10-13 15:18
 */
public class Car implements Strategy {
    @Override
    public void execute() {
        System.out.println("It takes 40 minutes to get to the destination by car.");
    }
}
