package com.IteratorsAndComparators.Froggy;

import java.util.*;

public class Lake<T> implements Iterable<T> {
    private List<T> numbers;

    public Lake(List<T> numbers) {
        this.numbers = numbers;
    }

    @Override
    public Iterator<T> iterator() {
        Frog frog = new Frog();

        return frog;
    }

    private class Frog implements Iterator<T> {

        private int evenIndex = 0;
        private int oddIndex = 1;

        @Override
        public boolean hasNext() {
            return !(this.evenIndex >= numbers.size()) || !(this.oddIndex >= numbers.size());
        }

        @Override
        public T next() {
            if (hasNext()) {
                if (this.evenIndex < numbers.size()) {
                    T element = numbers.get(evenIndex);
                    this.evenIndex += 2;
                    return element;
                }

                T element = numbers.get(oddIndex);
                this.oddIndex += 2;
                return element;
            }
            throw new NoSuchElementException();
        }
    }
}
