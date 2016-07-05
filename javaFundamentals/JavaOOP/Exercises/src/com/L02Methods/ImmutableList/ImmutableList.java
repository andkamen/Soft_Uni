package com.L02Methods.ImmutableList;

import java.util.List;

public class ImmutableList {
    private List<Integer> collection;

    public ImmutableList(List<Integer> collection) {
        this.collection = collection;
    }

    public ImmutableList returnCollection(){
        return new ImmutableList(this.collection);
    }
}
