import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator<E> implements Iterator {

    private int index = 0;
    private E[] values;

    ArrayIterator(E[] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return index < values.length;
    }

    public E next() {
        if (!hasNext()) {
            throw new NoSuchElementException("Нет больше элементов для возврата");
        }
        return values[index++];
    }
}