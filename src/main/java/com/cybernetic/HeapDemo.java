package com.cybernetic;

import java.util.Comparator;

/**
 * Demonstrates the functionality of the Heap class.
 */
public class HeapDemo {
    public static void main(String[] args) {
        Comparator<Integer> comparator = Integer::compareTo;
        Heap<Integer> heap = new Heap<>(comparator);

        System.out.println("Adding elements to heap:");
        for (int i = 0; i < 20; i++) {
            int number = (int) (Math.random() * 100);
            System.out.print(number + " ");
            heap.add(number);
        }
        System.out.println("\n\nRemoving elements from heap:");
        Integer number;
        while ((number = heap.remove()) != null) {
            System.out.print(number + " ");
        }
    }
}
