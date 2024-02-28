package com.kijen.cs.bitwise;

import java.util.ArrayDeque;
import java.util.Arrays;

public class BitMasking {
    public static void main(String[] args) {
        int[][] dir = {
                {0, 1},
                {1, 0},
                {0, -1},
                {-1, 0}
        };
        int[][] arr = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };

        // 방문배열
//        boolean[][] visited = new boolean[5][5];
//        visited[0][0] = true;

        // 비트마스킹 1
//        int[] visited = new int[5];
//        visited[0] = 1;

        // 비트마스킹 2
        int visited = 0;
        visited |= (1 << 0);

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

                // 방문배열
//                if (visited[nr][nc]) {
//                    continue;
//                }
//
//                visited[nr][nc] = true;

                // 비트마스킹 1
//                if ((visited[nr] & (1 << nc)) > 0) {
//                    continue;
//                }
//
//                visited[nr] |= (1 << nc);

                // 비트마스킹 2
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
    }
}
