package com.kijen.cs.bitwise;

import java.util.ArrayDeque;
import java.util.Arrays;

public class BitMasking {
    private void bitMaskingInBFS1(int r, int c) {
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int[][] arr = new int[r][c];

        int[] visited = new int[r];
        visited[0] = 1;

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {0, 0, 1});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int[] d : dir) {
                int nr = cur[0] + d[0];
                int nc = cur[1] + d[1];

                if (nr < 0 || nr >= r || nc < 0 || nc >= c) {
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

    private void bitMaskingInBFS2(int r, int c) {
        if (r * c > 32) {
            System.out.println("r * c must be 32 or less");

            return;
        }

        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int[][] arr = new int[r][c];

        int visited = 0;
        visited |= 1;

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {0, 0, 1});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int[] d : dir) {
                int nr = cur[0] + d[0];
                int nc = cur[1] + d[1];

                if (nr < 0 || nr >= r || nc < 0 || nc >= c) {
                    continue;
                }

                if ((visited & (1 << ((nr * c) + nc))) > 0) {
                    continue;
                }

                visited |= (1 << ((nr * c) + nc));

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

        BitMasking bm = new BitMasking();

        System.out.println("BitMasking in BFS 1:");
        bm.bitMaskingInBFS1(r, c);

        System.out.println("BitMasking in BFS 2:");
        bm.bitMaskingInBFS2(r, c);
    }
}
