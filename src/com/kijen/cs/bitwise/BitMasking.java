package com.kijen.cs.bitwise;

import java.util.ArrayDeque;
import java.util.Arrays;

public class BitMasking {
    private static void bitMaskingInBFS1() {
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int[][] arr = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };

        int[] visited = new int[5];
        visited[0] = 1;

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {0, 0, 1});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int[] d : dir) {
                int nr = cur[0] + d[0];
                int nc = cur[1] + d[1];

                if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5) {
                    continue;
                }

                if ((visited[nr] & (1 << nc)) > 0) {
                    continue;
                }

                visited[nr] |= (1 << nc);

                arr[nr][nc] = cur[2];
                queue.offer(new int[] {nr, nc, cur[2] + 1});
            }
        }

        for (int[] a : arr) {
            System.out.println(Arrays.toString(a));
        }

        System.out.println();
    }

    private static void bitMaskingInBFS2() {
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int[][] arr = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };

        int visited = 0;
        visited |= 1;

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {0, 0, 1});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int[] d : dir) {
                int nr = cur[0] + d[0];
                int nc = cur[1] + d[1];

                if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5) {
                    continue;
                }

                if ((visited & (1 << (nr * 5 + nc))) > 0) {
                    continue;
                }

                visited |= (1 << (nr * 5 + nc));

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
        System.out.println("BitMasking in BFS 1:");
        bitMaskingInBFS1();

        System.out.println("BitMasking in BFS 2:");
        bitMaskingInBFS2();
    }
}
