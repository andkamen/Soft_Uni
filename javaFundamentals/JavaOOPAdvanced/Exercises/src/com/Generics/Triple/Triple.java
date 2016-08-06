package com.Generics.Triple;

public class Triple<I, J, K> {
    private I item1;
    private J item2;
    private K item3;

    public Triple(I item1, J item2, K item3) {
        this.setItem1(item1);
        this.setItem2(item2);
        this.setItem3(item3);
    }

    public I getItem1() {
        return item1;
    }

    public void setItem1(I item1) {
        this.item1 = item1;
    }

    public J getItem2() {
        return item2;
    }

    public void setItem2(J item2) {
        this.item2 = item2;
    }

    public K getItem3() {
        return item3;
    }

    public void setItem3(K item3) {
        this.item3 = item3;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s -> %s", getItem1(), getItem2(), getItem3());
    }
}
