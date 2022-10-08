package iterator;

/**
 * @author Ruobing Shang 2022-10-08 16:14
 */
public interface Container {
    Iterator<?> createIterator();

    Iterator<?> createReverseIterator();
}
