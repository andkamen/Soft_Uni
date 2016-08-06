package com.IteratorsAndComparators.StackIterator;

import java.util.*;

public class StackIterator<T> implements Iterable<T> {
    private LinkedList<T> data;

    public StackIterator() {
        this.data = new LinkedList<>();
    }

    public void push(T element) {
        this.data.add(element);
    }

    public T pop() {
        if (this.data.isEmpty()) {
            throw new IllegalStateException("No elements");
        }

        return this.data.removeLast();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = data.size() - 1;

            @Override
            public boolean hasNext() {
                return index >= 0;
            }

            @Override
            public T next() {
                if (hasNext()) {
                    return data.get(index--);
                }

                throw new NoSuchElementException();
            }
        };
    }
}
