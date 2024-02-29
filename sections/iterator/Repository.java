package iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ruobing Shang 2022-10-08 16:16
 */
public class Repository implements Container {
    private final List<String> collection = new ArrayList<>(Arrays.asList("A", "B", "C", "D"));

    @Override
    public Iterator<String> createIterator() {
        return new BaseIterator(collection);
    }

    @Override
    public Iterator<String> createReverseIterator() {
        return new ReverseIterator(collection);
    }
}
