package com.kijen.cs.search;

import java.util.Arrays;

public class DepthFirstSearch {
    private static void depthFirstSearch(int r, int c, int R, int C, int[][] arr, boolean[][] visited) {
        if (r == R - 1 & c == C - 1) {
            for (int[] a : arr) {
                System.out.println(Arrays.toString(a));
            }

            System.out.println();

            return;
        }

        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (int[] d : dir) {
            int nr = r + d[0];
            int nc = c + d[1];

            if (nr < 0 || nr >= R || nc < 0 || nc >= C) {
                continue;
            }

            if (visited[nr][nc]) {
                continue;
            }

            visited[nr][nc] = true;

            arr[nr][nc] = arr[r][c] + 1;

            depthFirstSearch(nr, nc, R, C, arr, visited);

            visited[nr][nc] = false;

            arr[nr][nc] = 0;
        }
    }

    public static void main(String[] args) {
        int r = 3;
        int c = 3;
        int[][] arr = new int[r][c];
        boolean[][] visited = new boolean[r][c];

        arr[0][0] = 1;
        visited[0][0] = true;

        System.out.println("Paths from (0, 0) to (r - 1, c - 1) in DFS: ");
        depthFirstSearch(0, 0, r, c, arr, visited);
    }
}
