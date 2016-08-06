package com.Generics.SwapMethod;

public class Box<T> {

    private T element;

    public Box(T element) {
        this.setElement(element);
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return String.format("%s: %s",getElement().getClass().getName(),getElement().toString());
    }
}
