package com.Generics.CustomList.models;

import java.util.List;

public interface Sorter <T extends Comparable<T>> {

    void sort(List<T> collection);
}
