package observer;

/**
 * @author Ruobing Shang 2022-10-11 9:20
 */
public class AppStore extends Publisher {
    public void publish(String context){
        System.out.println(context);
        notifySubscribers(context);
    }
}
