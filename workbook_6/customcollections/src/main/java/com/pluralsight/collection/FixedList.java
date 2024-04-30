package com.pluralsight.collection;
import java.util.ArrayList;
import java.util.List;

public class FixedList<T> {
    // Create the variables, as private and final.
    private final List<T> items;
    private final int maxSize;

    // Create the constructor.
    public FixedList(int maxSize) {
        this.maxSize = maxSize;
        this.items = new ArrayList<>();
    }

    // Create add method.
    public void add(T item) {
        if (items.size() < maxSize) {
            items.add(item);
        } else {
            System.out.println("Cannot add more items. Maximum size reached.");
        }
    }

    // Create getter.
    public List<T> getItems() {
        return items;
    }
}
