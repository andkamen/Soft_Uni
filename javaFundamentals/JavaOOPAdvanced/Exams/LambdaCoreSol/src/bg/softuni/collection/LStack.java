package bg.softuni.collection;

import bg.softuni.interfaces.Fragment;

import java.util.Iterator;
import java.util.LinkedList;

public class LStack<T extends Fragment> implements Iterable<T> {

    private LinkedList<T> innerList;

    public LStack() {
        this.innerList = new LinkedList<T>();
    }

    public Integer size() {
        return this.innerList.size();
    }

    public T push(T item) {
        this.innerList.addLast(item);
        return item;
    }

    public T pop() {
        T removedItem = this.innerList.removeLast();
        return removedItem;
    }

    public T peek() {
        T peekedItem = this.innerList.getLast();
        return peekedItem;
    }

    public Boolean isEmpty() {
        return this.innerList.isEmpty();
    }

    @Override
    public Iterator<T> iterator() {
        return this.innerList.iterator();
    }
}