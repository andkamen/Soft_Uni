package com.Generics.CustomList.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class CustomList<T extends Comparable<T>> implements Iterable<T> {
    private List<T> list;
    private Sorter<T> sorter;

    public CustomList() {
        this.list = new ArrayList<>();
        this.sorter = new BubbleSort<>();
    }

    public void add(T element) {
        this.list.add(element);
    }

    public T remove(int index) {
        if (index < 0 || index >= this.list.size()) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }

        T element = this.list.get(index);
        this.list.remove(index);

        return element;
    }

    public boolean contains(T element) {
        return this.list.contains(element);
    }

    public void swapElements(int firstIndex, int secondIndex) {
        if (firstIndex < 0 || firstIndex >= this.list.size()) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }

        if (secondIndex < 0 || secondIndex >= this.list.size()) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }

        T temp = this.list.get(firstIndex);
        this.list.set(firstIndex, this.list.get(secondIndex));
        this.list.set(secondIndex, temp);
    }

    public int countGreaterThan(T element) {
        int count = 0;

        for (T t : this.list) {
            if (t.compareTo(element) > 0) {
                count++;
            }
        }

        return count;
    }

    public T getMax() {
        if (this.list.isEmpty()) {
            throw new IllegalStateException("List is empty");
        }

        T element = this.list.get(0);

        for (T t : list) {
            if (t.compareTo(element) > 0) {
                element = t;
            }
        }

        return element;
    }

    public T getMin() {
        if (this.list.isEmpty()) {
            throw new IllegalStateException("List is empty");
        }

        T element = this.list.get(0);

        for (T t : list) {
            if (t.compareTo(element) < 0) {
                element = t;
            }
        }

        return element;
    }

    public void sort(){
        this.sorter.sort(this.list);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < list.size();
            }

            @Override
            public T next() {
                return list.get(index++);
            }
        };
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        for (Iterator<T> iter = list.iterator(); iter.hasNext(); ) {
            T var = iter.next();
            action.accept(var);
        }
    }
}
