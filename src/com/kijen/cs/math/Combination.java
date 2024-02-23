package com.kijen.cs.math;

import java.util.ArrayList;

public class Combination {
    private final ArrayList<ArrayList<Integer>> combinations = new ArrayList<>();

    public Combination(int[] arr, int n, int r) {
        combination(arr, n, r, 0, new ArrayList<>());
    }

    private void combination(int[] arr, int n, int r, int depth, ArrayList<Integer> combination) {
        if (combination.size() == r) {
            combinations.add(new ArrayList<>(combination));

            return;
        }

        if (depth == n) {
            return;
        }

        combination.add(arr[depth]);

        combination(arr, n, r, depth + 1, combination);

        // combination.remove(subset.size() - 1); // Until Java 10
        combination.removeLast();

        combination(arr, n, r, depth + 1, combination);
    }

    public ArrayList<ArrayList<Integer>> get() {
        return combinations;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (ArrayList<Integer> combination : combinations) {
            result.append(combination).append("\n");
        }

        if (!result.isEmpty()) {
            result.deleteCharAt(result.length() - 1);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int n = arr.length;
        int r = 3;

        Combination cm = new Combination(arr, n, r);
        Factorial fc = new Factorial();

        System.out.println("Number of Combinations : (n!) / (r!(n - r)!) = "
                + fc.factorial(n) / (fc.factorial(r) * fc.factorial(n - r)) + " = "
                + cm.get().size() + "\n");
        System.out.println("Combinations of arr : \n" + cm);
    }
}
