package strategy;

/**
 * @author Ruobing Shang 2022-10-13 15:20
 */
public class Bus implements Strategy {
    @Override
    public void execute() {
        System.out.println("It takes 2 hours to get to the destination by bus.");
    }
}
