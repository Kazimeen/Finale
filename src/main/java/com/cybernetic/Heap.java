package com.cybernetic;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * A generic implementation of a heap data structure.
 *
 * @param <T> the type of elements stored in the heap.
 */
public class Heap<T> {
    private final ArrayList<T> elements = new ArrayList<>();
    private final Comparator<? super T> comparator;

    /**
     * Constructs a new Heap with the specified comparator.
     *
     * @param comparator the comparator used to order the elements in the heap.
     */
    public Heap(Comparator<? super T> comparator) {
        this.comparator = comparator;
    }

    /**
     * Adds an element to the heap.
     *
     * @param element the element to add.
     */
    public void add(T element) {
        elements.add(element);
        siftUp(elements.size() - 1);
    }

    /**
     * Removes and returns the root element of the heap.
     *
     * @return the root element, or null if the heap is empty.
     */
    public T remove() {
        if (elements.isEmpty()) return null;
        T root = elements.get(0);
        T lastElement = elements.remove(elements.size() - 1);
        if (!elements.isEmpty()) {
            elements.set(0, lastElement);
            siftDown(0);
        }
        return root;
    }

    /**
     * Restores the heap property by moving the element at the specified index upwards.
     *
     * @param index the index of the element to sift up.
     */
    private void siftUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (comparator.compare(elements.get(index), elements.get(parentIndex)) >= 0) {
                break;
            }
            swap(index, parentIndex);
            index = parentIndex;
        }
    }

    /**
     * Restores the heap property by moving the element at the specified index downwards.
     *
     * @param index the index of the element to sift down.
     */
    private void siftDown(int index) {
        int size = elements.size();
        while (index < size) {
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;
            int smallest = index;

            if (leftChild < size && comparator.compare(elements.get(leftChild), elements.get(smallest)) < 0) {
                smallest = leftChild;
            }
            if (rightChild < size && comparator.compare(elements.get(rightChild), elements.get(smallest)) < 0) {
                smallest = rightChild;
            }
            if (smallest == index) break;

            swap(index, smallest);
            index = smallest;
        }
    }

    /**
     * Swaps two elements in the heap at the specified indices.
     *
     * @param i the index of the first element.
     * @param j the index of the second element.
     */
    private void swap(int i, int j) {
        T temp = elements.get(i);
        elements.set(i, elements.get(j));
        elements.set(j, temp);
    }
}
