package com.kijen.cs.math;

import java.util.ArrayList;

public class PowerSet {
    private final ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();

    public PowerSet(int[] arr, int n) {
        powerSet(arr, n, 0, new ArrayList<>());
    }

    private void powerSet(int[] arr, int n, int start, ArrayList<Integer> subset) {
        subsets.add(new ArrayList<>(subset));

        for (int i = start; i < n; i++) {
            subset.add(arr[i]);
            powerSet(arr, n, i + 1, subset);
            // subset.remove(subset.size() - 1); // Until Java 10
            subset.removeLast();
        }
    }

    public ArrayList<ArrayList<Integer>> get() {
        return subsets;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (ArrayList<Integer> subset : subsets) {
            result.append(subset).append("\n");
        }

        if (!result.isEmpty()) {
            result.deleteCharAt(result.length() - 1);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int n = arr.length;

        PowerSet ps = new PowerSet(arr, n);

        System.out.println("Number of Subsets : 2^n = " + (int) Math.pow(2, n) + " = " + ps.get().size() + "\n");
        System.out.println("Subsets of arr : \n" + ps);
    }
}
