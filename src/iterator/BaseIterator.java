package iterator;

import java.util.List;

/**
 * @author Ruobing Shang 2022-10-08 16:17
 */
public class BaseIterator implements Iterator<String> {
    private final List<String> collection;
    private int index = 0;

    public BaseIterator(List<String> collection) {
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
