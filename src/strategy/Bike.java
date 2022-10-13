package strategy;

/**
 * @author Ruobing Shang 2022-10-13 15:18
 */
public class Bike implements Strategy {
    @Override
    public void execute() {
        System.out.println("It takes 3 hours to get to the destination by bike.");
    }
}
