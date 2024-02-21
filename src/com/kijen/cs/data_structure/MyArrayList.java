package com.kijen.cs.data_structure;

import java.util.Arrays;

public class MyArrayList<E> {
    private static final int DEFAULT_CAPACITY = 10;

    private Object[] elementData;
    private int size;

    public MyArrayList() {
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
    }

    private void resize() {
        int elementCapacity = elementData.length;

        if (elementCapacity == size) {
            elementData = Arrays.copyOf(elementData, elementCapacity * 2);
        } else if (elementCapacity / 2 > size) {
            elementData = Arrays.copyOf(elementData, Math.max(elementCapacity / 2, DEFAULT_CAPACITY));
        } else if (size == 0) {
            this.elementData = new Object[DEFAULT_CAPACITY];
        }
    }

    public boolean add(E data) {
        resize();

        elementData[size++] = data;

        return true;
    }

    public boolean add(int index, E data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }

        resize();

        for (int i = size; i > index; i--) {
            elementData[i] = elementData[i - 1];
        }

        elementData[index] = data;
        size++;

        return true;
    }

    public E remove() {
        if (isEmpty()) throw new IllegalArgumentException("Empty List");

        Object result = elementData[--size];
        elementData[size] = null;

        resize();

        return (E) result;
    }

    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }

        Object result = elementData[index];

        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }

        elementData[--size] = null;

        resize();

        return (E) result;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }

        return (E) elementData[index];
    }

    public int indexOf(E data) {
        if (data == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (data.equals(elementData[i])) {
                    return i;
                }
            }
        }

        return -1;
    }

    public int LastIndexOf(E data) {
        if (data == null) {
            for (int i = size - 1; i >= 0; i--) {
                if (elementData[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (data.equals(elementData[i])) {
                    return i;
                }
            }
        }

        return -1;
    }

    public boolean set(int index, E data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }

        elementData[index] = data;

        return true;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[");

        for (int i = 0; i < size - 1; i++) {
            result.append(elementData[i]).append(", ");
        }

        result.append(elementData[size - 1]).append("]");

        return result.toString();
    }
    // contains
    // addAll
    // clear
    // subList
    // removeall
    // retainall
    // getordefault
    // iterator
    // clone
    // toArray

    public static void main(String[] args) {
        MyArrayList<Integer> a = new MyArrayList<>();
        Integer b = null;

        a.add(1234);
        a.add(null);
        a.add(5);
        a.get(0);
//        System.out.println(a.indexOf(5));
        System.out.println(a.toString());
//        for (Integer i : a) {
//            System.out.println(i);
//        }
    }
}
