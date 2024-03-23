package Characters.Data;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class MyIterator<E> implements Iterable<E> {
    private List<E> elements;

    public MyIterator() {
        elements = new ArrayList<>();
    }

    public void add(E item) {
        elements.add(item);
    }

    @Override
    public Iterator<E> iterator() {
        return new CustomIterator();
    }

    private class CustomIterator implements Iterator<E> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < elements.size();
        }

        @Override
        public E next() {
            return elements.get(currentIndex++);
        }
    }
}
