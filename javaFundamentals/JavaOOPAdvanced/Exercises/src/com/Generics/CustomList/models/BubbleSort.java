package com.Generics.CustomList.models;

import java.util.List;

public class BubbleSort<T extends Comparable<T>> implements Sorter<T> {

    @Override
    public void sort(List<T> collection) {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < collection.size(); i++) {
                if (collection.get(i - 1).compareTo(collection.get(i)) > 0) {
                    swap(collection, i - 1, i);
                    swapped = true;
                }
            }

        } while (swapped);
    }

    public void swap(List<T> collection, int first, int second) {
        T temp = collection.get(first);
        collection.set(first, collection.get(second));
        collection.set(second, temp);
    }
}
