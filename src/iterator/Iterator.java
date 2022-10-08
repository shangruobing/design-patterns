package iterator;

/**
 * @author Ruobing Shang 2022-10-08 16:12
 */
public interface Iterator<T> {
    boolean hasNext();

    T next();
}
