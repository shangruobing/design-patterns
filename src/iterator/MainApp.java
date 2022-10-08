package iterator;

/**
 * @author Ruobing Shang 2022-10-08 16:24
 */
public class MainApp {
    public static void main(String[] args) {
        Repository repository = new Repository();
        Iterator<String> iterator = repository.createIterator();
        System.out.print("Normal  iteration: ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

        System.out.print("\nReverse iteration: ");
        iterator = repository.createReverseIterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
