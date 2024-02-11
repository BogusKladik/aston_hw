package aston_hw.first;

import java.util.Arrays;
import java.util.Collection;

public class MyArrayList<T extends Comparable<T>> {
    private T[] array;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    @SuppressWarnings("unchecked")
    public MyArrayList() {
        array = (T[]) new Comparable[DEFAULT_CAPACITY];
        size = 0;
    }

    @SuppressWarnings("unchecked")
    public MyArrayList(int capacity) {
        array = (T[]) new Comparable[capacity];
        size = 0;
    }

    public MyArrayList(Collection<? extends T> collection) {
        this(collection.size());
        addAll(collection);
    }

    public void add(T val) {
        if (size == array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
        array[size++] = val;
    }

    public void addAll(Collection<? extends T> collection) {
        for (T val : collection) {
            add(val);
        }
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("The index is either less than 0 or greater than the available size");
        }
        return array[index];
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("The index is either less than 0 or greater than the available size");
        }
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }

    @Override
    public String toString() {
        StringBuilder stringArr = new StringBuilder();
        stringArr.append("[");
        for (int i = 0; i < size; i++) {
            stringArr.append(array[i]);
            if (i!= size - 1) {
                stringArr.append(", ");
            }
        }
        stringArr.append("]");
        return stringArr.toString();
    }

    public int size() {
        return size;
    }

    public void bubbleSort() {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < size - 1; i++) {
                if (array[i].compareTo(array[i + 1]) > 0) {
                    T temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    sorted = false;
                }
            }
        }
    }

    public static <T extends Comparable<T>> void bubbleSort(Collection<T> collection) {
        MyArrayList<T> array = new MyArrayList<>(collection);
        array.bubbleSort();

        collection.clear();
        for (int i = 0; i < array.size(); i++) {
            collection.add(array.get(i));
        }
    }
}
