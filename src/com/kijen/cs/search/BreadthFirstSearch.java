package com.kijen.cs.search;

import java.util.ArrayDeque;
import java.util.Arrays;

public class BreadthFirstSearch {
    private void breadthFirstSearch(int r, int c, int[][] arr, boolean[][] visited) {
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {0, 0, arr[0][0] + 1});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int[] d : dir) {
                int nr = cur[0] + d[0];
                int nc = cur[1] + d[1];

                if (nr < 0 || nr >= r || nc < 0 || nc >= c) {
                    continue;
                }

                if (visited[nr][nc]) {
                    continue;
                }

                visited[nr][nc] = true;

                arr[nr][nc] = cur[2];
                queue.offer(new int[] {nr, nc, cur[2] + 1});
            }
        }

        for (int[] a : arr) {
            System.out.println(Arrays.toString(a));
        }

        System.out.println();
    }

    public static void main(String[] args) {
        int r = 5;
        int c = 5;
        int[][] arr = new int[r][c];
        boolean[][] visited = new boolean[r][c];

        arr[0][0] = 1;
        visited[0][0] = true;

        BreadthFirstSearch bfs = new BreadthFirstSearch();

        System.out.println("Visit level in BFS: ");
        bfs.breadthFirstSearch(r, c, arr, visited);
    }
}
