package com.kijen.cs.math;

import java.util.ArrayList;

public class Permutation {
    private final ArrayList<ArrayList<Integer>> permutations = new ArrayList<>();

    public Permutation(int[] arr, int n, int r) {
        permutation(arr, n, r, 0, new ArrayList<>(), new boolean[n]);
    }

    private void permutation(int[] arr, int n, int r, int depth, ArrayList<Integer> permutation, boolean[] visited) {
        if (permutation.size() == r) {
            permutations.add(new ArrayList<>(permutation));

            return;
        }

        if (depth == n) {
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;

                permutation.add(arr[i]);

                permutation(arr, n, r, depth + 1, permutation, visited);

                visited[i] = false;

                permutation.remove(permutation.size() - 1); // Until Java 10
                // permutation.removeLast();
            }
        }
    }

    public ArrayList<ArrayList<Integer>> get() {
        return permutations;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (ArrayList<Integer> permutation : permutations) {
            result.append(permutation).append("\n");
        }

        if (!result.isEmpty()) {
            result.deleteCharAt(result.length() - 1);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int n = arr.length;
        int r = 2;

        Permutation pr = new Permutation(arr, n, r);
        Factorial fc = new Factorial();

        System.out.println("Number of permutations : (n!) / ((n - r)!) = "
                + fc.factorial(n) / fc.factorial(n - r) + " = "
                + pr.get().size() + "\n");
        System.out.println("Permutations of arr : \n" + pr);
    }
}
