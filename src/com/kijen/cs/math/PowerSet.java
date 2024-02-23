package com.kijen.cs.math;

import java.util.ArrayList;

public class PowerSet {
    static ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();

    private static void powerSet(int[] arr, int start, ArrayList<Integer> subset) {
        subsets.add(new ArrayList<>(subset));

        for (int i = start; i < arr.length; i++) {
            subset.add(arr[i]);
            powerSet(arr, i + 1, subset);
            subset.remove(subset.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        powerSet(arr, 0, new ArrayList<>());

        for (ArrayList<Integer> subset : subsets) System.out.println(subset);
    }
}
