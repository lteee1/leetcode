package com.lcj.test.graph;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

public class G1162地图分析 {
    @Test
    public void tset() {
        int[][] g = {{1, 0, 0}, {0, 0, 0}, {1, 0, 1}};
        int i = maxDistance(g);
        System.out.println(i);

    }

    public int maxDistance(int[][] grid) {
        int[][] direct = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        if (grid == null) {
            return -1;
        }
        int length = grid.length;
        int t = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            boolean flag =false;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                for (int[] ints : direct) {
                    if (poll[0] + ints[0] < length && poll[0] + ints[0] >= 0 && poll[1] + ints[1] < length && poll[1] + ints[1] >= 0
                            && grid[poll[0] + ints[0]][poll[1] + ints[1]] == 0) {
                        flag = true;
                        grid[poll[0] + ints[0]][poll[1] + ints[1]] = 1;
                        queue.add(new int[]{poll[0] + ints[0], poll[1] + ints[1]});
                    }
                }
            }
            if(flag){
                t++;
            }
        }
        return t == 0 ? -1 : t;
    }
}
