package com.kijen.cs.math;

import java.util.ArrayList;

public class PowerSet {
    static ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();

    private static void powerSet(int[] arr, int n, int start, ArrayList<Integer> subset) {
        subsets.add(new ArrayList<>(subset));

        for (int i = start; i < n; i++) {
            subset.add(arr[i]);
            powerSet(arr, n, i + 1, subset);
            subset.remove(subset.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int n = arr.length;

        powerSet(arr, n, 0, new ArrayList<>());

        System.out.println("Number of Subsets : 2^n = " + Math.pow(2, n) + " = " + subsets.size());
        System.out.println();

        System.out.println("Subsets of arr : ");

        for (ArrayList<Integer> subset : subsets) System.out.println(subset);
    }
}
