package iterator;

import java.util.Collections;
import java.util.List;

/**
 * @author Ruobing Shang 2022-10-08 16:26
 */
public class ReverseIterator implements Iterator<String> {
    private final List<String> collection;
    private int index = 0;

    public ReverseIterator(List<String> collection) {
        Collections.reverse(collection);
        this.collection = collection;
    }

    @Override
    public boolean hasNext() {
        return collection.size() > index;
    }

    @Override
    public String next() {
        String element = collection.get(index);
        index++;
        return element;
    }
}
