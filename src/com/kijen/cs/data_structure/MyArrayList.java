package com.kijen.cs.data_structure;

import java.util.Arrays;

public class MyArrayList<E> {
    private static final int DEFAULT_CAPACITY = 10;

    private Object[] elementData;
    private int size;

    public MyArrayList() {
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
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

    private void checkBounds(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
    }

    public void add(int index, E data) {
        checkBounds(index);

        resize();

        for (int i = size; i > index; i--) {
            elementData[i] = elementData[i - 1];
        }

        elementData[index] = data;
        size++;
    }

    public E remove(int index) {
        checkBounds(index);

        Object result = elementData[index];

        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }

        elementData[--size] = null;

        resize();

        return (E) result;
    }

    public E get(int index) {
        checkBounds(index);

        return (E) elementData[index];
    }

    public E set(int index, E data) {
        checkBounds(index);

        E result = (E) elementData[index];
        elementData[index] = data;

        return result;
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

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[");

        for (int i = 0; i < size - 1; i++) {
            result.append(elementData[i]).append(", ");
        }

        result.append(elementData[size - 1]).append("]");

        return result.toString();
    }

    public static void main(String[] args) {
        MyArrayList<Integer> mal = new MyArrayList<>();

        System.out.println("isEmpty() : " + mal.isEmpty());

        mal.add(0, 3);
        mal.add(0, 2);
        mal.add(0, 1);
        mal.add(3, 4);
        System.out.println("After add(...) : " + mal);

        System.out.println("isEmpty() : " + mal.isEmpty());

        System.out.println("size() : " + mal.size());

        mal.set(3, 5);
        System.out.println("After set(3, 5) : " + mal);

        mal.remove(3);
        System.out.println("remove(3) : " + mal);

        System.out.println("size : " + mal.size());

        System.out.println("indexOf(2) : " + mal.indexOf(2));

        System.out.println("get(1) : " + mal.get(1));
    }
}
